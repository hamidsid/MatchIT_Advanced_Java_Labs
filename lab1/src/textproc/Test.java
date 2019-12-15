package textproc;

import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

        //List<Integer> nbrs = new ArrayList<Integer>();
        Set<Integer> nbrs = new HashSet<Integer>();

        for (int i = 0; i < 100; i += 10) {
            nbrs.add(i);
            nbrs.add(i); // Note, the number is added twice
        }
        for (int a : nbrs) {
            System.out.println(a);
        }
    }
}
