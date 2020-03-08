package project.com.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.com.model.Customer;

import javax.validation.constraints.NotBlank;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {


    private String customerId;

    @NotBlank(message = "firstName cannot be empty")
    private String firstName;
    @NotBlank(message = "lastname cannot be empty")
    private String lastName;
    @NotBlank(message = "profil cannot be empty")
    private String profil;

    public Customer toEntity() {
        return Customer.builder()
                .customerId(customerId)
                .firstName(firstName)
                .lastName(lastName)
                .profil(profil)
                .build();
    }
}
