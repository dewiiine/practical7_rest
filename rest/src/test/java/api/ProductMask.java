package api;

import lombok.Getter;

@Getter
public class ProductMask {
    private final String name;
    private final String type;
    private final Boolean exotic;

    public ProductMask() {
        this.name = "default_name";
        this.type = "default_type";
        this.exotic = false;
    }

    public ProductMask(String name, String type, Boolean exotic) {
        this.name = name;
        this.type = type;
        this.exotic = exotic;
    }


}
