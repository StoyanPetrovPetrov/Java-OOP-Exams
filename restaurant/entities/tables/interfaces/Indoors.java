package restaurant.entities.tables.interfaces;

public class Indoors extends BaseTable{
    private final static double pricePerPerson = 3.50;

    public Indoors(int number, int size) {
        super(number, size, pricePerPerson);
    }
}
