package onlineShop.models.products.components;

public class SolidStateDrive extends BaseComponent{
    public static final double MULTIPLIER_SOLIDSTATEDRIVE = 1.20;

    public SolidStateDrive(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance * MULTIPLIER_SOLIDSTATEDRIVE, generation);
    }
}
