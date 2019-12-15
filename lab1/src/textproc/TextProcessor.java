package textproc;

public interface TextProcessor {

    /**
     * Called when a word is read.
     * The method will then update the statistics.
     */
    void process(String w);

    /**
     * Method called when all the words in the sequence are read.
     * The method should print a readable representation of the statistics.
     */
    void report();
}