package CounterStriker.models.guns;

public class Rifle extends GunImpl{
    public final static int RIFLE_BULLETS_PER_SHOOT = 10;
    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
        setBulletsPerShoot(RIFLE_BULLETS_PER_SHOOT);
    }
}
