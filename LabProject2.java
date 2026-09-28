package LabProject2;

import java.util.ArrayList;
import java.util.Scanner;

public class LabProject2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Otobüs yolcu kapasitesini giriniz: ");
        int kapasite = input.nextInt();
        System.out.print("Durak sayısını giriniz: ");
        int durakSayısı = input.nextInt();

        ArrayList<String> stopName = new ArrayList<>();
        ArrayList<Integer> passengerBoard = new ArrayList<>();
        ArrayList<Integer> passengerGetOff = new ArrayList<>();
        ArrayList<Integer> currentPassenger = new ArrayList<>();
        int totalYolcu = 0;
        int overflow = 0;
        int currentYolcu = 0;

        for (int i = 0; i < durakSayısı; i++) {
            System.out.println("---" + (i + 1) + "." + "Durak Bilgileri---");
            System.out.print("Durak adı: ");
            String durakismi = input.next();
            stopName.add(durakismi);

            System.out.print("Binen yolcu sayısı: ");
            int binenYolcu = input.nextInt();
            if (binenYolcu > kapasite) {
                System.out.println("Kapasiteden fazla yolcu biniyor...");
            }
            passengerBoard.add(binenYolcu);

            while (true) {
                System.out.print("İnen yolcu sayısı: ");
                int inenYolcu = input.nextInt();
                if (inenYolcu > (binenYolcu + currentYolcu)) {
                    System.out.println("İnen yolcu mevcut yolcu sayısında fazla olamaz!");
                } else {
                    passengerGetOff.add(inenYolcu);
                    currentYolcu = currentYolcu + binenYolcu - inenYolcu;
                    currentPassenger.add(currentYolcu);
                    totalYolcu += currentYolcu;
                    break;
                }
            }

        }

        for (int i = 0; i < durakSayısı; i++) {
            System.out.println("-----------------------------");
            System.out.println("[" + stopName.get(i) + "]" + "duragındaki yolcu sayisi: " + currentPassenger.get(i));

            if (passengerBoard.get(i) > kapasite) {
                System.out.println("[" + stopName.get(i) + "]" + "Warning! Kapasiteden fazla " + (passengerBoard.get(i) - kapasite) + " kadar yolcu bindi!");
                overflow++;
            }

        }

        System.out.println("-----------------------------------------------");

        System.out.printf("%-20s %-5s %-5s %-5s\n", "Mevcut Durak", "Binen", "İnen", "Total");
        for (int i = 0; i < currentPassenger.size(); i++) {
            System.out.println("-----------------------------------------------");
            System.out.printf("%-20s %-5s %-5s %-5s\n", stopName.get(i), passengerBoard.get(i), passengerGetOff.get(i), currentPassenger.get(i));
        }
        System.out.println("-----------------------------------------------");

        System.out.println("Toplam Yolcu: " + totalYolcu);
        double average = (double) totalYolcu / durakSayısı;
        System.out.println("Ortalama: " + average);
        System.out.println("Kapasite asılan durak sayısı: " + overflow);

        int max = passengerBoard.get(0);
        String name = stopName.get(0);
        for (int i = 1; i < passengerBoard.size(); i++) {
            if (passengerBoard.get(i) > max) {
                max = passengerBoard.get(i);
                name = stopName.get(i);
            }
        }

        System.out.println("Maximum yolcu miktarı olan durak: " + name + " (Yolcu Miktarı): " + max);

        int kalanYolcu = currentPassenger.get(currentPassenger.size() - 1);
        if (kalanYolcu != 0) {
            System.out.println("Warning: " + kalanYolcu + " kadar yolcu hala otobüste !");
        } else {
            System.out.println("Otobüste kalan yolcu yok.");
        }
    }

}
