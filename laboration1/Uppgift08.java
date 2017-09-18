/**
 * Created by jolindk on 2017-09-05.
 */
import javax.swing.*;

public class Uppgift08 {
    public static void main(String[] arg) {

        // ask for input
        String indata = JOptionPane.showInputDialog("Ange växelkursen mellan Euro och SEK: ");
        double vaxelkurs = Double.parseDouble(indata);
        indata = JOptionPane.showInputDialog("Ange antal SEK: ");
        double sek = Double.parseDouble(indata);

        // calculate exchange rate and print
        String euro = String.format("%.2f", sek * vaxelkurs);
        JOptionPane.showMessageDialog(null, sek + " SEK motsvarar " + euro + " Euro");
    }
}