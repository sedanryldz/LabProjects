package javaapplication48;

import java.util.Scanner;

public class LabProject1 {

    public static void main(String[] args) {

        System.out.println("------------------------------");
        System.out.println("Welcome to tournament app");
        String ifade = "Match score -> 1 \n"
                + "Table score -> 2 \n"
                + "Quit -> -1";
        System.out.println(ifade);
        System.out.println("------------------------------");

        boolean var = true;
        Scanner input = new Scanner(System.in);

        String[] teams = {"Team A", "Team B", "Team C", "Team D"};
        int[] mp = new int[4];
        int[] w = new int[4];
        int[] d = new int[4];
        int[] l = new int[4];
        int[] gf = new int[4];
        int[] ga = new int[4];
        int[] pts = new int[4];

        int[] home = {0, 0, 0, 1, 1, 2};
        int[] away = {1, 2, 3, 3, 2, 3};

        do {
            System.out.print("Option: ");
            int value = input.nextInt();

            switch (value) {
                case 1:
                    for (int i = 0; i < 6; i++) {
                        int t1 = home[i];
                        int t2 = away[i];

                        System.out.printf("Match %d: %s vs %s\n", (i + 1), teams[t1], teams[t2]);
                        System.out.print("  " + teams[t1] + " goals: ");
                        int g1 = input.nextInt();
                        System.out.print("  " + teams[t2] + " goals: ");
                        int g2 = input.nextInt();

                        mp[t1]++;
                        mp[t2]++;
                        gf[t1] += g1;
                        ga[t1] += g2;
                        gf[t2] += g2;
                        ga[t2] += g1;

                        if (g1 > g2) {
                            w[t1]++;
                            pts[t1] += 3;
                            l[t2]++;
                        } else if (g2 > g1) {
                            w[t2]++;
                            pts[t2] += 3;
                            l[t1]++;
                        } else {
                            d[t1]++;
                            pts[t1] += 1;
                            d[t2]++;
                            pts[t2] += 1;
                        }
                    }

                    break;

                case 2:
                    System.out.println("\n-------------------------------------------");
                    System.out.printf("%-10s %-4s %-4s %-4s %-4s %-5s %-4s\n", "Team", "MP", "W", "D", "L", "GD", "Pts");
                    System.out.println("-------------------------------------------");

                    for (int i = 0; i < 4; i++) {
                        int gd = gf[i] - ga[i];
                        System.out.printf("%-10s %-4d %-4d %-4d %-4d %-5d %-4d\n",
                                teams[i], mp[i], w[i], d[i], l[i], gd, pts[i]);
                    }
                    
                    int championIndex = 0;
                    
                    for(int i=1; i< teams.length; i++){
                        int currentPts = pts[i];
                        int champPts = pts[championIndex];
                        
                        int currentGD = gf[i] - ga[i];
                        int champGD = gf[championIndex] - ga[championIndex];
                        
                        if(currentPts > champPts){
                            championIndex = i;
                        }
                        else if(currentPts == champPts && currentGD > champGD){
                            championIndex = i;
                        }
                    }
                    
                    System.out.println("\n Champion: "+ teams[championIndex] + " Points: " + pts[championIndex]);
                    
                    break;
                case -1:
                    System.out.println("System is closed");
                    var = false;
                    break;
                default:
                    System.out.println("Invalid expression!");
                    break;
            }

        } while (var);

    }

}
