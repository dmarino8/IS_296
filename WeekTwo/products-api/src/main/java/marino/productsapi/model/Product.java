package marino.productsapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {

    //*****************************************
    // Instances
    //*****************************************
    @Id
    @Column
    Integer id;
    @Column
    String name;
    @Column
    String crop;

    //*****************************************
    // Setters
    //*****************************************
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCrop(String crop) {
        this.crop = crop;
    }

    //*****************************************
    // Getters
    //*****************************************
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCrop() {
        return crop;
    }
}
