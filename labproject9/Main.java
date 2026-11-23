
package labproject9;


public class Main {

    public static void main(String[] args) {
        Warrior invalidChar = new Warrior(20, "TestDummy", 150, 50, -50);
        System.out.println(invalidChar.getCharacterInfo());
        
        Warrior w = new Warrior(40, "Titan", 10, 500, 500);
        Mage m = new Mage(60, "Carmilla", 11, 300, 300);
        Healer h = new Healer(50, "Rager", 12, 350, 350);

        Team team = new Team();
        team.addCharacter(w);
        team.addCharacter(m);
        team.addCharacter(h);
        
        team.addCharacter(new Warrior(10, "Titan", 5, 200, 200));
        
        Warrior golem = new Warrior(60, "Golem", 15, 800, 800);

        System.out.println("\n--- Initial Team ---");
        team.displayTeam();
        System.out.println("Total Alive Power: " + team.getTotalPower());
        
        for (int round = 1; round <= 2; round++) {
            System.out.println("\n--- Round " + round + " ---");
            team.attackAll(golem);
            System.out.println("After Team Attack -> " + golem.getCharacterInfo());

            golem.attack(w);
            golem.attack(m);

            team.healTeam();
            team.displayTeam();
        }
        
        System.out.println("\n--- Search & Remove ---");
        GameCharacter searched = team.findByName("Carmilla");
        System.out.println("Found: " + (searched != null ? searched.getCharacterInfo() : "Not found"));

        team.removeCharacter("Rager");
        System.out.println("\n--- Final Team ---");
        team.displayTeam();
        
        
        
        
    }
    
}
