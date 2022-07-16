package marino.tacos.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Ingredient {
    //****************************************
    // Attribute Instances
    //****************************************
    private final String id;
    private final String name;
    private final Type type;

    //****************************************
    // ENUMS
    //****************************************
    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
