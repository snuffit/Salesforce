package dto;

public class Account {

    private String name, phone, fax, rating, accountNumber, website, accountSite, tickerSymbol, type, ownership,
            industry, billingStreet, billingCity, billingZip, billigCountry, description;
    private boolean isVipClient, isTeachMeSkills;

    public Account(String name, String phone, String fax, String rating, String accountNumber, String website,
                   String accountSite, String tickerSymbol, String type, String ownership, String industry,
                   String billingStreet, String billingCity, String billingZip, String billigCountry,
                   String description, boolean isVipClient, boolean isTeachMeSkills) {
        this.name = name;
        this.phone = phone;
        this.fax = fax;
        this.rating = rating;
        this.accountNumber = accountNumber;
        this.website = website;
        this.accountSite = accountSite;
        this.tickerSymbol = tickerSymbol;
        this.type = type;
        this.ownership = ownership;
        this.industry = industry;
        this.billingStreet = billingStreet;
        this.billingCity = billingCity;
        this.billingZip = billingZip;
        this.billigCountry = billigCountry;
        this.description = description;
        this.isVipClient = isVipClient;
        this.isTeachMeSkills = isTeachMeSkills;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getRating() {
        return rating;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getWebsite() {
        return website;
    }

    public String getAccountSite() {
        return accountSite;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public String getType() {
        return type;
    }

    public String getOwnership() {
        return ownership;
    }

    public String getIndustry() {
        return industry;
    }

    public String getBillingStreet() {
        return billingStreet;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public String getBillingZip() {
        return billingZip;
    }

    public String getBilligCountry() {
        return billigCountry;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVipClient() {
        return isVipClient;
    }

    public boolean isTeachMeSkills() {
        return isTeachMeSkills;
    }
}
