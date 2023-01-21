import java.io.FileNotFoundException;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        String file = "WordLibrary.txt";
        WordLibrary w = new WordLibrary("WordLibrary.txt");
        System.out.println(w);

    }
}