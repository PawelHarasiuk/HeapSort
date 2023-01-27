public class Main {
    public static void main(String[] args) {
        HeapSolution1 heap1_1 = new HeapSolution1("datain/datain_50.txt");
        HeapSolution1 heap1_2 = new HeapSolution1("datain/datain_100.txt");
        HeapSolution1 heap1_3 = new HeapSolution1("datain/datain_200.txt");

        HeapSolution2 heap2_1 = new HeapSolution2("datain/datain_50.txt");
        HeapSolution2 heap2_2 = new HeapSolution2("datain/datain_100.txt");
        HeapSolution2 heap2_3 = new HeapSolution2("datain/datain_200.txt");

        System.out.println("\nROZWIAZANIE1\n");
        System.out.println("50 danych");
        heap1_1.talk();
        System.out.print("Pozostale zetonow: ");
        heap1_1.displayLeftTokens();
        System.out.println("Zarobiono: " + heap1_1.money + " zl\n");

        System.out.println("100 danych");
        heap1_2.talk();
        System.out.print("Pozostale zetonow: ");
        heap1_2.displayLeftTokens();
        System.out.println("Zarobiono: " + heap1_2.money + " zl\n");

        System.out.println("200 danych");
        heap1_3.talk();
        System.out.print("Pozostalo zetonow: ");
        heap1_3.displayLeftTokens();
        System.out.println("Zarobiono: " + heap1_3.money + " zl\n");

        System.out.println("==========================================================\n");

        System.out.println("ROZWIAZANIE2\n");
        System.out.println("50 danych");
        heap2_1.talk();
        System.out.print("Pozostalo zetonow: ");
        heap2_1.displayLeftTokens();
        System.out.println("Zarobiono: " + heap2_1.money + " zl\n");

        System.out.println("100 danych");
        heap2_2.talk();
        System.out.print("Pozostalo zetonow: ");
        heap2_2.displayLeftTokens();
        System.out.println("Zarobiono: " + heap2_2.money + " zl\n");

        System.out.println("200 danych");
        heap2_3.talk();
        System.out.print("Pozostalo zetonow: ");
        heap2_3.displayLeftTokens();
        System.out.println("Zarobiono: " + heap2_3.money + " zl\n");

        System.out.println("==========================================================\n");

        System.out.println("PODSUMOWANIE\n");
        System.out.println("Zarobek dla 50 danych");
        System.out.println("Rozwiazanie 1: " + heap1_1.money + " zl");
        System.out.println("Rozwiazanie 2: " + heap2_1.money + " zl");
        int roznica1 = heap2_1.money - heap1_1.money;

        if (roznica1 > 0) {
            System.out.println("Wiekszy jest zarobek dla Rozwiazania2\n");
        } else if (roznica1 == 0) {
            System.out.println("Zarobek jest rowny dla obu rozwiazan\n");
        } else {
            System.out.println("Wiekszy jest zarobek dla Rozwiazania1\n");
        }

        System.out.println("Zarobek dla 100 danych");
        System.out.println("Rozwiazanie 1: " + heap1_2.money + " zl");
        System.out.println("Rozwiazanie 2: " + heap2_2.money + " zl");
        int roznica2 = heap2_2.money - heap1_2.money;

        if (roznica2 > 0) {
            System.out.println("Wiekszy jest zarobek dla Rozwiazania2\n");
        } else if (roznica2 == 0) {
            System.out.println("Zarobek jest rowny dla obu rozwiazan\n");
        } else {
            System.out.println("Wiekszy jest zarobek dla Rozwiazania1\n");
        }

        System.out.println("Zarobek dla 200 danych");
        System.out.println("Rozwiazanie 1: " + heap1_3.money + " zl");
        System.out.println("Rozwiazanie 2: " + heap2_3.money + " zl");
        int roznica3 = heap2_3.money - heap1_3.money;

        if (roznica3 > 0) {
            System.out.println("Wiekszy jest zarobek dla Rozwiazania2");
        } else if (roznica3 == 0) {
            System.out.println("Zarobek jest rowny dla obu rozwiazan");
        } else {
            System.out.println("Wiekszy jest zarobek dla Rozwiazania1");
        }
    }
}
