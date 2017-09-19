import java.util.Scanner;

public class Uppgift13 {
    public static void main(String[] args) {

        // variable setup
        int y, n, a, b, m, q, w, d;
        Scanner sc = new Scanner(System.in);

        // run until escape cmd
        while (true) {

            // ask for input and check correct usage
            do {
                System.out.print("Ange ett år mellan 1900 och 2099: ");
                y = sc.nextInt();
                if (y < 1900 || y > 2099)
                    System.out.println("Fel årtal!\n");
            } while (y < 1900 || y > 2099);

            // calculate the day
            n = y - 1900;
            a = n % 19;
            b = (7 * a + 1) / 19;
            m = (11 * a + 4 - b) % 29;
            q = n / 4;
            w = (n + q + 31 - m) % 7;
            d = 25 - m - w;

            // print datekjhg
            if (d > 0) {
                System.out.println(y + " inföll påskdagen " + d + " april\n");
            } else {
                d = 31 + d;
                System.out.println(y + " inföll påskdagen " + d + " mars\n");
            }
        }
    }
}
