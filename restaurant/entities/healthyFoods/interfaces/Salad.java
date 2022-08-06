package restaurant.entities.healthyFoods.interfaces;

public class Salad extends Food{
    private final static double InitialSaladPortion = 150;

    public Salad(String name, double price) {
        super(name, InitialSaladPortion, price);
    }
}
