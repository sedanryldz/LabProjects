
package labproject9;


public abstract class GameCharacter {
    private String name;
    private int level;
    private int health;
    private int maxHealth;
    
    public GameCharacter(String name, int level, int health, int maxHealth) {
        this.name = name;

        if (level >= 1 && level <= 100) {
            this.level = level;
        } else {
            System.out.println("Invalid level! Setting level to 1.");
            this.level = 1;
        }

        if (maxHealth > 0) {
            this.maxHealth = maxHealth;
        } else {
            System.out.println("Invalid maxHealth! Setting maxHealth to 100.");
            this.maxHealth = 100;
        }

        if (health > 0 && health <= this.maxHealth) {
            this.health = health;
        } else if (health > this.maxHealth) {
            this.health = this.maxHealth;
        } else {
            System.out.println("Invalid health! Setting health to maxHealth.");
            this.health = this.maxHealth;
        }
    }
    
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }

    public abstract String getCharacterInfo();
    public abstract int calculatePower();

    public boolean isAlive() {
        return this.health > 0;
    }

    public int takeDamage(int damage) {
        if (damage <= 0 || !isAlive()) {
            return 0;
        }
        int actualDamage;
        if (damage >= this.health) {
            actualDamage = this.health;
            this.health = 0;
        } else {
            actualDamage = damage;
            this.health -= damage;
        }
        return actualDamage;
    }

    public int restoreHealth(int amount) {
        if (!isAlive() || amount <= 0) {
            return 0;
        }
        int missingHealth = this.maxHealth - this.health;
        int actualRestored = Math.min(amount, missingHealth);
        this.health += actualRestored;
        return actualRestored;
    }
}
