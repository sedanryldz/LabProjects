

package labproject9;


public class Healer extends GameCharacter implements Supporter{
    private int healAmount;

    public Healer(int healAmount, String name, int level, int health, int maxHealth) {
        super(name, level, health, maxHealth);
        this.healAmount = Math.max(0, healAmount);
    }

    @Override
    public String getCharacterInfo() {
        return "[Healer] " + getName() + " | LVL: " + getLevel() + " | HP: "
                + getHealth() + "/" + getMaxHealth() + " | Heal Amount: " + this.healAmount
                + " | Power: " + calculatePower() + " | Alive: " + isAlive();
    }

    @Override
    public int calculatePower() {
        return (getLevel() * 5) + this.healAmount;
    }

    @Override
    public int heal(GameCharacter target) {
        if (!this.isAlive() || target == null || !target.isAlive()) {
            return 0;
        }
        int amount = this.healAmount + getLevel();
        return target.restoreHealth(amount);
    }
}
