import javax.swing.*;

public class Uppgift11 {
    public static void main(String[] arg) {

        // variable setup
        String indata = null;
        int date = 0, year = 0, day = 0, month = 0;

        // do until cancel
        while (true) {

            // ask user for input
            indata = JOptionPane.showInputDialog("Ange datum på formen yymmdd: ");
            date = Integer.parseInt(indata);

            // calculate new date format
            day = date % 100;
            month = (date % 10000 - day) / 100;
            year = (date - month * 100 - day) / 10000;

            // print the converted year
            JOptionPane.showMessageDialog(null, zero(month) + "/" + zero(day) + "/" + zero(year));
        }
    }

    // adds a zero in front of the input number if single digit
    public static String zero(int i) {

        if (i < 10) {
            return "0" + i;
        } else {
            return "" + i;
        }
    }
}