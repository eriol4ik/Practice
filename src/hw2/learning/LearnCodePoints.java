package hw2.learning;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by eriol4ik on 12/01/2017.
 */
public class LearnCodePoints {
    public static void main(String[] args) {
        String[] alphabet = new String[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = new String(Character.toChars(i + 97));
        }
        System.out.println(Arrays.toString(alphabet));
    }
}
