package app.model.drinks;

public class Drink implements IDrink{
    private String name, description;
    private float price;

    public Drink(String name, String description, float price){
        this.name = name;
        this.description = description;
        this.price = price;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String prepare() {
        return String.format("This %s is delicious", name);
    }
}
