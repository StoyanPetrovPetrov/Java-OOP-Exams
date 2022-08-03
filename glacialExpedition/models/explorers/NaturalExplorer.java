package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{
    public NaturalExplorer(String name) {
        super(name, 60);
    }

    @Override
    public void search() {
        double newEnergy = getEnergy() - 7;
        if (newEnergy < 0){
            setEnergy(0);
        }else {
            setEnergy(newEnergy);
        }
    }
}
