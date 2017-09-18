public class Uppgift12 {
    public static void main(String[] args) {

        // variable setup
        double sum = 0, n = 1, pm = 1;

        // calculate the sum
        for (int i = 0; i < 500; i++) {
            sum = sum + pm * (1 / n);
            n += 2;
            pm = pm * -1;
        }

        // print the sum
        System.out.println(sum * 4);
    }
}