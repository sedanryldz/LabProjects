
package labproject9;


public class Mage extends GameCharacter implements Attacker,Supporter{
    private int mana;

    public Mage(int mana, String name, int level, int health, int maxHealth) {
        super(name, level, health, maxHealth);
        this.mana = Math.max(0, mana);
    }

    @Override
    public String getCharacterInfo() {
        return "[Mage] " + getName() + " | LVL: " + getLevel() + " | HP: "
                + getHealth() + "/" + getMaxHealth() + " | Mana: " + this.mana
                + " | Power: " + calculatePower() + " | Alive: " + isAlive();
    }

    @Override
    public int calculatePower() {
        return (getLevel() * 8) + this.mana;
    }

    @Override
    public int attack(GameCharacter target) {
        if (!this.isAlive() || target == null || !target.isAlive()) {
            return 0;
        }
        if (this.mana >= 20) {
            int damage = calculatePower() / 3;
            this.mana -= 20;
            return target.takeDamage(damage);
        } else {
            System.out.println(getName() + " does not have enough mana to attack!");
            return 0;
        }
    }

    @Override
    public int heal(GameCharacter target) {
        if (!this.isAlive() || target == null || !target.isAlive()) {
            return 0;
        }
        if (this.mana >= 15) {
            int healAmount = getLevel() * 2;
            this.mana -= 15;
            return target.restoreHealth(healAmount);
        } else {
            System.out.println(getName() + " does not have enough mana to heal!");
            return 0;
        }
    }
}
