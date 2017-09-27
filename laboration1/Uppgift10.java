import java.util.Scanner;
import javax.swing.*;

public class Uppgift10 {
    public static void main(String[] arg) {
        // variable initialization
        double d = 0, A = 0, L = 0, f = 0;

        // ask for input
        String indata = JOptionPane.showInputDialog("Ange d, A, L och f i följd, separerade med mellanslag: ");
        if (indata != null && !(indata.equals(""))) { // handle null case
            Scanner sc = new Scanner(indata).useDelimiter("\\s* \\s*");
            d = sc.nextDouble();
            A = sc.nextDouble();
            L = sc.nextDouble();
            f = sc.nextDouble();
            sc.close();


            // calculate class of boat
            double val = (2 * d + Math.sqrt(A) + L - f) / 2.37;

            // print class of boat
            JOptionPane.showMessageDialog(null, "Båtens klass: " + val);
        }
    }
}
