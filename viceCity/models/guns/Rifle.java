package viceCity.models.guns;

public class Rifle extends BaseGun{
    public static final int RIFLE_BULLETS_PER_BARREL = 50;
    public static final int RIFLE_TOTAL_BULLETS = 500;
    public static final int RIFLE_BULLETS_PER_SHOT = 5;

    public Rifle(String name) {
        super(name, RIFLE_BULLETS_PER_BARREL, RIFLE_TOTAL_BULLETS);
        setBulletsPerShoot(RIFLE_BULLETS_PER_SHOT);
    }
}
