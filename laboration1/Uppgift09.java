import javax.swing.*;

public class Uppgift09 {
    public static void main(String[] arg) {
        // variable initialization
        double v = 0, alpha = 0, g = 9.82;

        // ask for input
        String indata = JOptionPane.showInputDialog("Ange utgångshastigheten i m/s: ");
        if (indata != null) {
            v = Double.parseDouble(indata);
        }

        indata = JOptionPane.showInputDialog("Ange kastvinkeln i grader: ");
        if (indata != null) {
            alpha = Double.parseDouble(indata);
        }

        // calculate variables
        String h = String.format("%.2f", (Math.pow(v, 2) * Math.pow(Math.sin(Math.toRadians(alpha)), 2)) / (2 * g));
        String d = String.format("%.2f", (Math.pow(v, 2) * Math.pow(Math.sin(Math.toRadians(2 * alpha)), 2)) / g);

        // print result
        JOptionPane.showMessageDialog(null, "h = " + h + " meter\nd = " + d + " meter");
    }
}
