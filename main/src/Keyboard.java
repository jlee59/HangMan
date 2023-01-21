import javax.crypto.Cipher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
public class Keyboard extends JComponent {
    static int guess = 0;
    static WordLibrary wb = new WordLibrary();
    static String answer = wb.WordLibrary("WordLibrary.txt");
    static JPanel screen;
    static JTextField textField0 = new JTextField();
    static JTextField textField1 = new JTextField();
    static JTextField textField2 = new JTextField();
    static JTextField textField3 = new JTextField();
    static JTextField textField4 = new JTextField();
    static JTextField textField5 = new JTextField();
    static JTextField textField6 = new JTextField();
    static JTextField[] textFields = {textField0, textField1, textField2, textField3, textField4, textField5, textField6};

    private static void addButton(JPanel jp, String thing) {
        JButton button = new JButton(thing);
        button.setActionCommand(thing);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonChr = e.getActionCommand();
                Character chr = buttonChr.charAt(0);
                if (!Main.checkLetterInWord(chr, answer)) {
                    guess += 1;
                    button.setBackground(Color.red);
                    if (!(guess < 5)) {
                        for (int i = 0; i < answer.length(); i++) {
                            textFields[i].setText(String.valueOf(answer.charAt(i)).toUpperCase());

                        }
                    }
                } else {
                    for (int i = 0; i < answer.length(); i++) {
                        System.out.println((answer.charAt(i)) + buttonChr.toLowerCase());
                        char newChar = buttonChr.toLowerCase().charAt(0);
                        if (newChar == answer.charAt(i)) {
                            button.setBackground(Color.green);
                            textFields[i].setText(String.valueOf(answer.charAt(i)).toUpperCase());
                        }
                    }
                }

            }
        });
        jp.add(button);
    }
    static String[] list = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static JPanel keyboard() {
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(3,8));
        for (String character : list) {
            addButton(jp, character);
            //Add action listener here
        }
        return jp;
    }

    public static void createGUI() {
        JFrame frame = new JFrame("Keyboard");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel jp =  keyboard();
        frame.add(jp, BorderLayout.SOUTH);
        screen = new JPanel();
        screen.setLayout(new GridLayout(0,answer.length()));
        for (int i = 0; i < answer.length(); i++) {
            screen.add(textFields[i]);
        }
        frame.add(screen, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }
}
