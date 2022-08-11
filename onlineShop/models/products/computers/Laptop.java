package onlineShop.models.products.computers;

public class Laptop extends BaseComputer{
    public static final int LAPTOP_OVERALL_PERFORMANCE = 10;

    public Laptop(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, LAPTOP_OVERALL_PERFORMANCE);
    }
}
