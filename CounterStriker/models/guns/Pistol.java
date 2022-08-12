package CounterStriker.models.guns;

public class Pistol extends GunImpl{
    public final static int PISTOL_BULLETS_PER_SHOOT = 1;
    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
        setBulletsPerShoot(PISTOL_BULLETS_PER_SHOOT);
    }
}
