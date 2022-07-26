package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish{
    public static final int INITIAL_SIZE = 5;
    public static final int SIZE_INCREMENT = 2;

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.setSize(INITIAL_SIZE);
    }

    @Override
    public void eat() {
        this.setSize(this.getSize() + SIZE_INCREMENT);
    }
}
