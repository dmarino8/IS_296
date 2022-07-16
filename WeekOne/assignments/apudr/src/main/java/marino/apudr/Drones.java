package marino.apudr;

public class Drones {

    //***************************
    // Attribute Instances
    //***************************
    Integer id;
    String name;
    String service;
    Boolean available;

    //***************************
    // Constructors
    //***************************
    Drones() {

    }

    //***************************
    // Getters
    //***************************
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getService() {
        return service;
    }

    public Boolean getAvailable() {
        return available;
    }

    //***************************
    // Setters
    //***************************
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
