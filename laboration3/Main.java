import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/*


    USAGE: java Main txtfile tempo
    EX: java Main elise.txt 2


 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // read text file and arguments
        Scanner sc = new Scanner(new File(args[0]));
        double tempo = Double.parseDouble(args[1]);

        // setup song
        SoundDevice device = new SoundDevice();
        Song song = new Song(50);

        // setup variables
        int pitch;
        double duration;

        // read file and add notes until EOF
        while (sc.hasNext()) {
            pitch = Integer.parseInt(sc.next());
            duration = Double.parseDouble(sc.next());
            song.add(MusicUtils.harmonic(pitch, duration * tempo));
        }

        // close scanner
        sc.close();

        // play and create song file
        song.play(device);
        song.save(device.getFormat(),new File("furelise.wav"));
    }//main 
}//Main
