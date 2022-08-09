package viceCity.models.guns;

public class Pistol extends BaseGun {
    public static final int PISTOL_BULLETS_PER_BARREL = 10;
    public static final int PISTOL_TOTAL_BULLETS = 100;
    public static final int BULLETS_PER_SHOT = 1;

    public Pistol(String name) {
        super(name, PISTOL_BULLETS_PER_BARREL, PISTOL_TOTAL_BULLETS);
        setBulletsPerShoot(BULLETS_PER_SHOT);


    }
}
