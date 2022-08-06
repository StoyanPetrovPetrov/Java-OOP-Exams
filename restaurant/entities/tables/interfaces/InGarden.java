package restaurant.entities.tables.interfaces;

public class InGarden extends BaseTable{
    private final static double pricePerPerson = 4.50;

    public InGarden(int number, int size) {
        super(number, size, pricePerPerson);
    }
}
