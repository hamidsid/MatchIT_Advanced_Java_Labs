package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Holgersson {

    public static final String[] REGIONS = {"blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
            "halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
            "södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
            "öland", "östergötland"};

    public static void main(String[] args) throws FileNotFoundException {



        ArrayList<TextProcessor> list = new ArrayList<TextProcessor>();
        //list.add(new SingleWordCounter("nils"));
        //list.add(new SingleWordCounter("norge"));
        //list.add(new MultiWordCounter(REGIONS));

        Scanner s = new Scanner(new File("nilsholg.txt"));
        s.findWithinHorizon("\uFEFF", 1);
        s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

        Scanner stopwords = new Scanner(new File("undantagsord.txt"));
        list.add(new GeneralWordCounter(stopwords));

        long t0 = System.nanoTime();
        while (s.hasNext()) {
            String word = s.next().toLowerCase();
            for (TextProcessor tp : list) {
                tp.process(word);
            }
        }

        s.close();
        long t1 = System.nanoTime();

        for (TextProcessor tp : list) {
            tp.report();
        }

        System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");
    }
}