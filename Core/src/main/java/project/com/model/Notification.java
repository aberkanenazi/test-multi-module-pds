package project.com.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notification {

    private String id;
    private String name;
    private String body;
    private boolean hasBeenSent;
    private int timeTolive;

    public String toString() {
        return ("{ \n"
                + "\"name\": \""+name+"\" \n"
                + "\"body\": \""+body+"\" \n"
                + "}");
    }

}