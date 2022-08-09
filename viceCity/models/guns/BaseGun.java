package viceCity.models.guns;

import viceCity.common.ExceptionMessages;

public abstract class BaseGun implements Gun{
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;
    private int bulletsInBarrel;
    private int bulletsPerShoot = 0;

    public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        setName(name);
        setBulletsPerBarrel(bulletsPerBarrel);
        setTotalBullets(totalBullets);
        this.canFire = true;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.NAME_NULL);
        }
        this.name = name;
    }

    private void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0){
            throw new IllegalArgumentException(ExceptionMessages.BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    private void setTotalBullets(int totalBullets) {
        if (totalBullets < 0){
            throw new IllegalArgumentException(ExceptionMessages.TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;
    }
    void setBulletsPerShoot(int bulletsPerShoot) {
        this.bulletsPerShoot = bulletsPerShoot;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return bulletsInBarrel + totalBullets > 0;
    }

    @Override
    public int getTotalBullets() {
        return totalBullets;
    }
    private void reload() {
        int needBulletsForReload = bulletsPerBarrel - bulletsInBarrel;
        int reloadedBullets = Math.min(totalBullets, needBulletsForReload);
        bulletsInBarrel += reloadedBullets;
        totalBullets -= reloadedBullets;
    }
    private boolean canNoReload() {
        return totalBullets == 0;
    }
    private boolean hasNoBulletInBarrel() {
        return bulletsInBarrel == 0;
    }

    @Override
    public int fire() {

        if (hasNoBulletInBarrel()) {
            if (canNoReload()) {
                return 0;
            }

            reload();
        }

        bulletsInBarrel -= bulletsPerShoot;
        return bulletsPerShoot;
    }
    }

