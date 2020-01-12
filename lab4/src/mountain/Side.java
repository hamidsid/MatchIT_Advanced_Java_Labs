package mountain;

public class Side {

    Point start;
    Point end;

    /**
     * Constructs and initializes a Side with points start and end
     *
     * @param start the first point of the side
     * @param end   the second point of the side
     */
    public Side(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Returns the first point of the side
     *
     * @return the first point of the side
     */
    public Point getStart() {
        return start;
    }

    /**
     * Returns the second point of the side
     *
     * @return the second point of the side
     */
    public Point getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Side) {
            Side s = (Side) o;
            if ((start.equals(s.getStart()) && end.equals(s.getEnd())) || (start.equals(s.getEnd()) && end.equals(s.getStart()))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return start.hashCode() + end.hashCode();
    }
}
