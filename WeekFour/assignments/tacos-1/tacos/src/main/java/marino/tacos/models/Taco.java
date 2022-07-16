package marino.tacos.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class Taco {
    //****************************************
    // Attribute Instances
    //****************************************
    private String name;
    private List<String> ingredients;
}
