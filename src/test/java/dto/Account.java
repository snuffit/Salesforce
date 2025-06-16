package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Account {

    private String name;
    private String phone;
    private String fax;
    private String rating;
    private String accountNumber;
    private String website;
    private String accountSite;
    private String tickerSymbol;
    private String type;
    private String ownership;
    private String industry;
    private String billingStreet;
    private String billingCity;
    private String billingZip;
    private String billigCountry;
    private String description;
    private boolean isVipClient;
    private boolean isTeachMeSkills;
}
