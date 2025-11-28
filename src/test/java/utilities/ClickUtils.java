package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;
import java.util.List;

public class ClickUtils extends BasePage {

    public ClickUtils(WebDriver driver) {
        super(driver);
    }

    public static void guaranteedClick( By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        // Helper: محاولة واحدة على العنصر الموجود في السياق الحالي
        java.util.function.Supplier<Boolean> tryClickInCurrentContext = () -> {
            try {
                // 1) انتظار العنصر ليكون موجود وقابل للـ clickable (لو أمكن)
                WebElement element = null;
                try {
                    element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                } catch (Exception ignored) {
                    // لو ما قدرناش عن طريق elementToBeClickable، نحاول وجوده فقط
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                }

                // 2) Scroll to view
                js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);

                // 3) حاول click عادي أولاً
                try {
                    element.click();
                    return true;
                } catch (ElementClickInterceptedException | MoveTargetOutOfBoundsException e) {
                    // لو حصل اعتراض أو المشكلة بسبب overlay/position
                } catch (StaleElementReferenceException sere) {
                    // العنصر تغير — نعيد المحاولة من البداية في هذه الدالة الخارجية
                    return false;
                }

                // 4) Actions move + click كخطة بديلة
                try {
                    actions.moveToElement(element).pause(Duration.ofMillis(200)).click().perform();
                    return true;
                } catch (Exception ignored) {}

                // 5) JS click مباشر
                try {
                    js.executeScript("arguments[0].click();", element);
                    return true;
                } catch (Exception ignored) {}

                // 6) Dispatch actual MouseEvent (أحيانًا الموقع يستمع لـ real MouseEvent)
                try {
                    String script =
                            "const el = arguments[0];" +
                                    "var ev = new MouseEvent('click', {bubbles: true, cancelable: true, view: window});" +
                                    "el.dispatchEvent(ev);";
                    js.executeScript(script, element);
                    return true;
                } catch (Exception ignored) {}

                // 7) كحل أخير: تعديل checked لو checkbox
                try {
                    WebElement el = driver.findElement(locator);
                    String type = el.getAttribute("type");
                    if (type != null && (type.equalsIgnoreCase("checkbox") || type.equalsIgnoreCase("radio"))) {
                        js.executeScript("arguments[0].checked = true; arguments[0].dispatchEvent(new Event('change', {bubbles:true}));", el);
                        return true;
                    }
                } catch (Exception ignored) {}

            } catch (Exception e) {
                // أي استثناء عام — نعيد false عشان نجرب سياقات أخرى (iframes)
            }
            return false;
        };

        // 1) حاول في السياق الحالي
        if (tryClickInCurrentContext.get()) {
            System.out.println("✅ Click succeeded in current context for: " + locator);
            return;
        }

        // 2) جرب الانتقال بين كل iframes و محاولة نفس الشيء داخل كل frame
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        for (int i = 0; i < frames.size(); i++) {
            try {
                driver.switchTo().defaultContent();
                driver.switchTo().frame(frames.get(i));
                if (tryClickInCurrentContext.get()) {
                    System.out.println("✅ Click succeeded inside iframe index " + i + " for: " + locator);
                    driver.switchTo().defaultContent();
                    return;
                }
            } catch (Exception ignored) {
                // لو frame رسبنا فيه، نكمل للي بعده
            } finally {
                driver.switchTo().defaultContent();
            }
        }

        // 3) جرب البحث داخل Shadow DOM باستخدام JS (محاولة عامة)
        try {
            String shadowQueryScript =
                    "function queryDeep(selector){" +
                            "  const find = (root) => {" +
                            "    const el = root.querySelector(selector);" +
                            "    if (el) return el;" +
                            "    const children = root.querySelectorAll('*');" +
                            "    for (let i=0;i<children.length;i++){" +
                            "      const child = children[i];" +
                            "      if (child.shadowRoot) {" +
                            "        const found = find(child.shadowRoot);" +
                            "        if (found) return found;" +
                            "      }" +
                            "    }" +
                            "    return null;" +
                            "  }" +
                            "  return find(document);" +
                            "}" +
                            "return queryDeep(arguments[0]);";
            // نمرر locator كسيلكتور CSS string لو كان By.cssSelector
            String selector = locatorToCss(locator);
            if (selector != null) {
                Object shadowEl = js.executeScript(shadowQueryScript, selector);
                if (shadowEl instanceof WebElement) {
                    WebElement real = (WebElement) shadowEl;
                    try {
                        js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", real);
                        System.out.println("✅ Click succeeded in Shadow DOM for: " + locator);
                        return;
                    } catch (Exception ignored) {}
                }
            }
        } catch (Exception ignored) {}

        // 4) لو كل المحاولات فشلت
        System.out.println("❌ guaranteedClick FAILED for: " + locator);
    }

    // Helper: حاول نحول By إلى CSS selector string لو أمكن (ترجع null لو مش CSS)
    private static String locatorToCss(By locator) {
        try {
            String s = locator.toString(); // شكل By.cssSelector: "By.cssSelector: input[data-testid='privacy-policy-checkbox']"
            if (s.startsWith("By.cssSelector: ")) {
                return s.replace("By.cssSelector: ", "").trim();
            }
            if (s.startsWith("By.selector: ")) { // بعض الإصدارات
                return s.replace("By.selector: ", "").trim();
            }
        } catch (Exception ignored) {}
        return null;
    }

    public static void guaranteedClick(WebElement elementParam) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        java.util.function.Supplier<Boolean> tryClickInCurrentContext = () -> {
            try {
                WebElement element = elementParam;

                // حاول التأكد إن العنصر ما زال حاضر وقابل للتفاعل قدر الإمكان
                try {
                    // If the element is stale, this will throw StaleElementReferenceException
                    if (!element.isDisplayed() || !element.isEnabled()) {
                        // نسمح بمحاولة غير مباشرة ولكن لن نكرر البحث لأننا لا نملك locator هنا
                    }
                } catch (StaleElementReferenceException sere) {
                    return false; // العنصر تغير — caller يمكنه إعادة استدعاء مع عنصر جديد
                } catch (Exception ignored) {}

                // Scroll to view
                try {
                    js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
                } catch (Exception ignored) {}

                // 1) Click عادي
                try {
                    element.click();
                    return true;
                } catch (ElementClickInterceptedException | MoveTargetOutOfBoundsException e) {
                    // اعتراض أو مشكلة موضع — نجرب البدائل
                } catch (StaleElementReferenceException sere) {
                    return false;
                } catch (Exception ignored) {}

                // 2) Actions move + click
                try {
                    actions.moveToElement(element).pause(Duration.ofMillis(200)).click().perform();
                    return true;
                } catch (Exception ignored) {}

                // 3) JS click
                try {
                    js.executeScript("arguments[0].click();", element);
                    return true;
                } catch (Exception ignored) {}

                // 4) Dispatch actual MouseEvent
                try {
                    String script =
                            "const el = arguments[0];" +
                                    "var ev = new MouseEvent('click', {bubbles: true, cancelable: true, view: window});" +
                                    "el.dispatchEvent(ev);";
                    js.executeScript(script, element);
                    return true;
                } catch (Exception ignored) {}

                // 5) Checkbox / radio fallback
                try {
                    String type = element.getAttribute("type");
                    if (type != null && (type.equalsIgnoreCase("checkbox") || type.equalsIgnoreCase("radio"))) {
                        js.executeScript("arguments[0].checked = true; arguments[0].dispatchEvent(new Event('change', {bubbles:true}));", element);
                        return true;
                    }
                } catch (Exception ignored) {}

            } catch (Exception e) {
                // أي استثناء عام — نعيد false
            }
            return false;
        };

        // نجرب في السياق الحالي فقط (لا نستطيع التنقل بين iframes بدون locator)
        if (tryClickInCurrentContext.get()) {
            System.out.println("✅ Click succeeded in current context for WebElement");
            return;
        }

        System.out.println("❌ guaranteedClick FAILED for provided WebElement (current context). " +
                "If the element might be inside a different iframe or shadow root, call the overloaded guaranteedClick(By locator) instead.");
    }

}
