import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Armoury implements Iterable {

    private List<Suit> list = null;

    public Armoury() {
        // Fill the List with data
        list = new LinkedList<Suit>();
        list.add(new Suit("HOTROD", 22));
        list.add(new Suit("SILVER CENTURION", 33));
        list.add(new Suit("SOUTHPAW", 34));
        list.add(new Suit("HULKBUSTER 2.0", 48));
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}