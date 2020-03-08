package project.com.DTO;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.com.model.Store;


import javax.validation.constraints.NotBlank;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoreDto {


    private String storeId;

    @NotBlank(message = "name cannot be empty")
    private String name;
    @NotBlank(message = "longitude cannot be empty")
    private Double longitude;
    @NotBlank(message = "latitude cannot be empty")
    private Double latitude;
    @NotBlank(message = "type cannot be empty")
    private String type;


    public Store toEntity() {
        return Store.builder()
                .storeId(storeId)
                .name(name)
                .longitude(longitude)
                .latitude(latitude)
                .type(type)
                .build();
    }
}
