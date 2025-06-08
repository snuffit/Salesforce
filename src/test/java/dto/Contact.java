package dto;

public class Contact {

    private String phone, homePhone, salutation, lastName, department, assistant, leadSource, languages, level;

    public Contact(String phone, String homePhone, String salutation, String lastName, String department,
                   String assistant, String leadSource, String languages, String level) {
        this.phone = phone;
        this.homePhone = homePhone;
        this.salutation = salutation;
        this.lastName = lastName;
        this.department = department;
        this.assistant = assistant;
        this.leadSource = leadSource;
        this.languages = languages;
        this.level = level;
    }

    public String getPhone() {
        return phone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getAssistant() {
        return assistant;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public String getLanguages() {
        return languages;
    }

    public String getLevel() {
        return level;
    }
}
