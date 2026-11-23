
package labproject9;

import java.util.ArrayList;


public class Team {
    private ArrayList<GameCharacter> characters = new ArrayList<>();

    public void addCharacter(GameCharacter character) {
        if (character == null) return;
        if (findByName(character.getName()) != null) {
            System.out.println("Character with name '" + character.getName() + "' already exists in the team!");
            return;
        }
        characters.add(character);
    }

    public void removeCharacter(String name) {
        GameCharacter found = findByName(name);
        if (found != null) {
            characters.remove(found);
            System.out.println(name + " removed from the team.");
        } else {
            System.out.println(name + " not found in the team.");
        }
    }

    public GameCharacter findByName(String name) {
        for (GameCharacter g : characters) {
            if (g.getName().equalsIgnoreCase(name)) {
                return g;
            }
        }
        return null;
    }

    public void attackAll(GameCharacter target) {
        for (GameCharacter g : characters) {
            if (g.isAlive() && g instanceof Attacker) {
                ((Attacker) g).attack(target);
            }
        }
    }

    public void healTeam() {
        GameCharacter lowestTarget = null;
        double lowestRatio = Double.MAX_VALUE;

        for (GameCharacter g : characters) {
            if (g.isAlive()) {
                double ratio = (double) g.getHealth() / g.getMaxHealth();
                if (ratio < lowestRatio) {
                    lowestRatio = ratio;
                    lowestTarget = g;
                }
            }
        }

        if (lowestTarget != null) {
            for (GameCharacter g : characters) {
                if (g.isAlive() && g instanceof Supporter) {
                    ((Supporter) g).heal(lowestTarget);
                }
            }
        }
    }

    public int getTotalPower() {
        int total = 0;
        for (GameCharacter g : characters) {
            if (g.isAlive()) {
                total += g.calculatePower();
            }
        }
        return total;
    }

    public void displayTeam() {
        for (GameCharacter g : characters) {
            System.out.println(g.getCharacterInfo());
        }
    }
}
