import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapEntryExercises {





    //answer for F2 from lab 3 ??????????????+

    List<Map.Entry<Object, Integer>> list = new ArrayList<>();


    public static void main(String[] args) {

        Map<String, Integer> m = new HashMap<>();

        m.put("Lund", 20);
        m.put("Malmo", 30);
        m.put("Goteborg", 15);
        m.put("Copenhagen", 60);
        m.put("Karlshamn", 5);




        //Solution to F3 from lab 3

        List<Map.Entry<String, Integer>> list = new ArrayList<>(m.entrySet());

        System.out.println(list);
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        System.out.println("__________________________________________________");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("after comparsion");
        System.out.println(list);

    }


}
