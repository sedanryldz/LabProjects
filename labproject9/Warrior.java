
package labproject9;


public class Warrior extends GameCharacter implements Attacker{
    private int armor;

    public Warrior(int armor, String name, int level, int health, int maxHealth) {
        super(name, level, health, maxHealth);
        this.armor = Math.max(0, armor);
    }
    
    @Override
    public String getCharacterInfo() {
        return "[Warrior] " + getName() + " | LVL: " + getLevel() + " | HP: "
                + getHealth() + "/" + getMaxHealth() + " | Armor: " + this.armor
                + " | Power: " + calculatePower() + " | Alive: " + isAlive();
    }

    @Override
    public int calculatePower() {
        return (getLevel() * 10) + (this.armor * 2);
    }

    @Override
    public int takeDamage(int damage) {
        if (!isAlive() || damage <= 0) {
            return 0;
        }
        int reducedDamage = Math.max(1, damage - (this.armor / 2));
        return super.takeDamage(reducedDamage);
    }

    @Override
    public int attack(GameCharacter target) {
        if (!this.isAlive() || target == null || !target.isAlive()) {
            return 0;
        }
        int damage = calculatePower() / 4;
        return target.takeDamage(damage);
    }
}
