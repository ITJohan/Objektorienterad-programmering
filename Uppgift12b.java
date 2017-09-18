public class Uppgift12b {
    public static void main(String[] args) {

        // variable setup
        double sum = 0, n = 1, term = 0;
        int pm = 1;

        // calculate the sum
        do {
            term = pm * (1 / n);
            sum = sum + term;
            n += 2;
            pm = pm * -1;
        } while (Math.abs(term) > 0.00001);

        // print the sum
        System.out.println(sum * 4);
    }
}