package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Contact {

    private String phone;
    private String homePhone;
    private String salutation;
    private String lastName;
    private String department;
    private String assistant;
    private String leadSource;
    private String languages;
    private String level;
}
