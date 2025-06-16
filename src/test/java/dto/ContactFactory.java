package dto;

import com.github.javafaker.Faker;

public class ContactFactory {

    public static Contact getContact(String salution, String leadSource, String level) {
        Faker faker = new Faker();
        return new Contact(faker.phoneNumber().phoneNumber(), faker.phoneNumber().cellPhone(), salution,
                faker.name().lastName(), faker.address().buildingNumber(), faker.ancient().god(),
                leadSource, faker.lordOfTheRings().location(), level);
    }
}
