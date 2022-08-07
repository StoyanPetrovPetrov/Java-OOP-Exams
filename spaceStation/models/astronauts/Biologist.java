package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    public Biologist(String name) {
        super(name,70);
    }

    @Override
    public void breath() {
        double oxygen = getOxygen() >= 5 ? getOxygen()-5 : 0;
        setOxygen(oxygen);
    }
}
