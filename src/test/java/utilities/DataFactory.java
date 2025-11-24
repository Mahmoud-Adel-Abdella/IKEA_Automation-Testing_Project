package utilities;

import com.github.javafaker.Faker;

public final class DataFactory {
    private static final Faker faker = new Faker();

    private static final String fName = faker.name().firstName();
    private static final String lName = faker.name().lastName();
    private static final String phoneNumber = faker.phoneNumber().phoneNumber();
    private static final String email = faker.internet().emailAddress();
    private static final String password = "Pa$$w0rd22w";


    public static String getFirstName() {
        return fName;
    }

    public static String getLastName() {
        return lName;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }
}
