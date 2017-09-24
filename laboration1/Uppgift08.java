import javax.swing.*;

public class Uppgift08 {
    public static void main(String[] arg) {
        // variable initialization
        double vaxelkurs = 0, sek = 0;

        // ask for input
        String indata = JOptionPane.showInputDialog("Ange växelkursen mellan Euro och SEK: ");
        if (indata != null) { // handle cancel option
            vaxelkurs = Double.parseDouble(indata);
        }
        
        indata = JOptionPane.showInputDialog("Ange antal SEK: ");
        if (indata != null) { // handle cancel option
            sek = Double.parseDouble(indata);
        }

        // calculate exchange rate and print
        String euro = String.format("%.2f", sek * vaxelkurs);
        JOptionPane.showMessageDialog(null, sek + " SEK motsvarar " + euro + " Euro");
    }
}
