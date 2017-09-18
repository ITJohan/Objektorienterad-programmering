/**
 * Created by jolindk on 2017-09-05.
 */
import java.util.Scanner;
import javax.swing.*;

public class Uppgift10 {
    public static void main(String[] arg) {

        // ask for input
        String indata = JOptionPane.showInputDialog("Ange d, A, L och f i följd, separerade med mellanslag: ");
        Scanner sc = new Scanner(indata).useDelimiter("\\s* \\s*");
        double d = sc.nextDouble();
        double A = sc.nextDouble();
        double L = sc.nextDouble();
        double f = sc.nextDouble();
        sc.close();

        // calculate class of boat
        double val = (2 * d + Math.sqrt(A) + L - f) / 2.37;

        // print class of boat
        JOptionPane.showMessageDialog(null, "Båtens klass: " + val);
    }
}
