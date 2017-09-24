import javax.swing.*;

public class Uppgift11 {
    public static void main(String[] arg) {

        // variable setup
        String indata = "", newDate = "";
        int date, year, day, month;

        // do until cancel
        while (indata != null) {

            // ask user for input
            indata = JOptionPane.showInputDialog("Ange datum på formen yymmdd: ");
            if (indata != null) {
                date = Integer.parseInt(indata);
            } else {
                date = 0;
            }

            // calculate new date format
            day = date % 100;
            month = (date % 10000 - day) / 100;
            year = (date - month * 100 - day) / 10000;
            
            // date formatting
            newDate = String.format("%02d/%02d/%02d", month, day, year);

            // print the converted year
            JOptionPane.showMessageDialog(null, newDate);
        }
    }
}
