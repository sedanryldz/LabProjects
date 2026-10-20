
package labproject5;


public class Main {

    
    public static void main(String[] args) {
        
        Package p1 = new Package("Sedanur Yıldız", "Erciyes Üni", "Kayseri", "Türkiye", "TR038", "Ayşe Yıldız", "Süha Kasabı", "Konya", "Türkiye", "TR042", 5, 100);
        TwoDayPackage t1 = new TwoDayPackage("Sedanur Yıldız", "Erciyes Üni", "Kayseri", "Türkiye", "TR038", "Ayşe Yıldız", "Süha Kasabı", "Konya", "Türkiye", "TR042", 5, 100);
        OverNightPackage o1 = new OverNightPackage("Sedanur Yıldız", "Erciyes Üni", "Kayseri", "Türkiye", "TR038", "Ayşe Yıldız", "Süha Kasabı", "Konya", "Türkiye", "TR042", 5, 100);
        
        p1.showing();
        t1.showing();
        o1.showing();
    }
    
}
