package interfaces;

public interface Hero {
    String getName();// – returns the name of the hero.
    int getHealth();// – returns the health of the hero.
    double getOffense();// – returns the offense of the hero.
    double getDefense();// – returns the defense of the hero.
    double getTotalPoints();// – returns the total points of the hero.
    boolean isDead();// - returns “true” if the hero is dead.
    void attack(Hero hero);// - attack another character.
    void receiveDamage(double amount);// – receive damage equal to the double amount.
}
