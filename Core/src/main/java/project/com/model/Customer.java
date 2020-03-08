package project.com.model;


import project.com.DTO.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Builder
@NoArgsConstructor
@Data
@Document(collection = "Customer")
@AllArgsConstructor
public class Customer {

    @Id
    private String customerId;

    @NotBlank(message = "firstName cannot be empty")
    private String firstName;
    @NotBlank(message = "firstName cannot be empty")
    private String lastName;
    @NotBlank(message = "firstName cannot be empty")
    private String profil;

    public Customer(String firstName, String lastName, String profil) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profil = profil;
    }


    public CustomerDto toDto() {
        return CustomerDto.builder()
                .customerId(customerId)
                .firstName(firstName)
                .lastName(lastName)
                .profil(profil)
                .build();
    }

}
