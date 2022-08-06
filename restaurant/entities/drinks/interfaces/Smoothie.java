package restaurant.entities.drinks.interfaces;

public class Smoothie extends BaseBeverage{
    private final static double smoothiePrice = 4.50;

    public Smoothie(String name, int counter, String brand) {
        super(name, counter, smoothiePrice, brand);
    }
}
