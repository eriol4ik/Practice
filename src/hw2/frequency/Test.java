package hw2.frequency;

/**
 * Created by eriol4ik on 13/01/2017.
 */
public class Test {
    public static void main(String[] args) {
        Freq freq = new Freq();
//        System.out.println(freq.setTextFromFile("file"));
        System.out.println(freq.generateRandomTextWithVocabulary());
//        System.out.println(freq.getMapOfFrequencies());
//        System.out.println(freq.getWordsByFrequencyMoreThan(2));
        System.out.println(freq.getWordsByFrequency(4));
        freq.printAcs(true);
        freq.printAcs(false);
    }
}
