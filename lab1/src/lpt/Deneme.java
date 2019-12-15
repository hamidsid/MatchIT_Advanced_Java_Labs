package lpt;

import java.util.HashMap;
import java.util.Map;

public class Deneme {

    public static void main(String[] args) {

       /* //List<Integer> nbrs = new ArrayList<Integer>();
        Set<Integer> nbrs = new HashSet<>();
        for (int i = 0; i < 100; i += 10) {
            nbrs.add(i);
            nbrs.add(i); // Note, the number is added twice
        }
        for (int a : nbrs) {
            System.out.println(a);
        }*/


        Map<String, Integer> m = new HashMap<>();
        m.put("albatross", 12);
        m.put("pelikan", 27);
        m.put("lunnefagel", 19);
        m.put("zzz", 29);
        m.put("adfd", 192);

        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        //F4 --------------------- !map.containsKey("albatross")





        /*String string = "Balkrishan Nagpal --> 1111, 2222, 3333, 23, 45,66";
        Pattern pattern = Pattern.compile("[0-9]+");

        Scanner scanner = new Scanner(string);

        while (scanner.hasNext()) {
            System.out.println("scanner.findWithinHorizon(pattern) = " + scanner.findWithinHorizon(pattern, 26));
            System.out.println(scanner.toString());
        }*/


    }
}
