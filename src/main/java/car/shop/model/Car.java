package car.shop.model;

public class Car {

    Long id;
    private String name;
    private String description;
    private String speed;
    private Double price;
    private Integer year;

    public Car() {}

    public Car(Long id, String name, String description, String speed, Double price, Integer year) {
        this.id = id;
        this.setName(name);
        this.setDescription(description);
        this.setSpeed(speed);
        this.setPrice(price);
        this.setYear(year);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
