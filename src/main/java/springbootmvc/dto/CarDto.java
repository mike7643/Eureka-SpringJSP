package springbootmvc.dto;

public class CarDto {

    private String name;
    private int price2;
    private String owner;

    public CarDto() {
    }

    public CarDto(String name, int price2, String owner) {
        this.name = name;
        this.price2 = price2;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price2;
    }

    public void setPrice(int price) {
        this.price2 = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "name='" + name + '\'' +
                ", price2=" + price2 +
                ", owner='" + owner + '\'' +
                '}';
    }
}
