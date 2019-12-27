import textproc.TextProcessor;
import textproc.WordCountComparator;

import java.util.*;

public class GeneralWordCounter implements TextProcessor {
    private Set<String> exceptions;
    private Map<String, Integer> m;


    public GeneralWordCounter(Set<String> exceptions) {
        this.exceptions = exceptions;
        m = new TreeMap<>();

    }

    @Override
    public void process(String w) {

        //first make sure that the given word is not an exception
        if (!exceptions.contains(w)) {

            //if no such word in the map then add it to the map
            if (m.get(w) == null) {
                m.put(w, 1);
            } else {
                m.put(w, m.get(w) + 1); // if already there, increment its value
            }
        }
    }

    @Override
    public void report() {


        /*for (String key : m.keySet()) {
            if (m.get(key) >= 200) {
                System.out.println(key + ": " + m.get(key));
            }
        }*/

        Set<Map.Entry<String, Integer>> wordSet = m.entrySet();
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);


        wordList.sort(new WordCountComparator());

        for (int i = 0; i < 100; i++) {
            System.out.println(wordList.get(i));

        }
    }

    public Set<Map.Entry<String, Integer>> getWords() {
        return m.entrySet();
    }
}