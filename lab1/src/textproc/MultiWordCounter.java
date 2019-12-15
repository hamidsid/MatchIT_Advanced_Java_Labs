package textproc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor {

    private Map<String, Integer> m;

    public MultiWordCounter(String[] states) {

        m = new HashMap<>();
        for (String state : states) {
            m.put(state, 0);
        }
    }

    @Override
    public void process(String w) {

        for (String key : m.keySet()) {
            if (key.equals(w)) {
                m.put(key, m.get(key) + 1);
            }
        }
    }

    @Override
    public void report() {

        for (String key : m.keySet()) {
            System.out.println(key + " : " + m.get(key));
        }

    }
}
