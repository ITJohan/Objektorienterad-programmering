import java.util.Random;
import java.lang.Math;

public class MusicUtils {
    // global arrayLength
    static int arrayLength;

    // generates sine sound
    public static double[] sine(double freq, double duration) {
        int n = (int)(duration*SoundDevice.SAMPLING_RATE);
        double[] a = new double[n];
        double dx = 2*Math.PI*freq / SoundDevice.SAMPLING_RATE;
        for (int i = 0; i < n; i = i + 1) {
            a[i] = Math.sin(i * dx);
        }
        return a;
    }//sine

    // generates pluck sound
    public static double[] pluck(double freq, double duration) {
        Random r = new Random();
        double[] a = new double[arrayLength];
        int p = (int)(SoundDevice.SAMPLING_RATE / freq); // number of samplings in a cycle

        // fill first cycle of samplings, p, with randomized numbers between -1.0 and 1.0
        for (int i = 0; i < arrayLength; i++) {
            if (i < p) {
                a[i] = -1.0 + r.nextDouble() * 2.0;
            } else {
                a[i] = (a[i - p] + a[i - (p - 1)]) * 0.498;
            }
        }

        return a;
    }

    // easier note input than pluck
    public static double[] note(int pitch, double duration) {
        return pluck(440 * Math.pow(2, (double)pitch/12), duration);
    }

    // returns the average of two note arrays
    public static double[] average(double[] t1, double[] t2) {
        double average[] = new double[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            average[i] = (t1[i] + t2[i]) / 2;
        }

        return average;
    }

    // returns average (harmonic) of three note arrays
    public static double[] harmonic(int pitch, double duration) {
        arrayLength = (int)(duration*SoundDevice.SAMPLING_RATE);
        double[] harmonic = new double[arrayLength];

        return average(average(note(pitch - 12, duration), note(pitch + 12, duration)), note(pitch, duration));
    }
}
