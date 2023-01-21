import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        String file = "WordLibrary.txt";
        WordLibrary w = new WordLibrary("WordLibrary.txt");
        System.out.println(w);

    }

    public boolean checkLetterInWord(char letter, String word) {
        char[] charArray = word.toCharArray();
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            charList.add(charArray[i]);

        }
        return charList.contains(letter);
    }
}