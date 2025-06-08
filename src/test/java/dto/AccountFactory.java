package dto;

import com.github.javafaker.Faker;

public class AccountFactory {

    public static Account getAccount(String rating, String type, String ownership, String industry) {
        Faker faker = new Faker();
        return new Account(faker.name().name(), faker.phoneNumber().phoneNumber(), faker.number().digit(), rating,
                faker.phoneNumber().cellPhone(), faker.address().buildingNumber(), faker.beer().hop(),
                faker.phoneNumber().subscriberNumber(), type, ownership, industry, faker.animal().name(),
                faker.address().city(), faker.address().zipCode(), faker.address().country(),
                faker.backToTheFuture().quote(), faker.bool().bool(), faker.bool().bool());
    }
}
