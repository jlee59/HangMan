import javax.crypto.Cipher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
public class Keyboard extends JComponent {
    private static void addButton(JPanel jp, String thing) {
        JButton button = new JButton(thing);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        }
        return jp;
    }

    public static void createGUI() {
        JFrame frame = new JFrame("Keyboard");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel jp =  keyboard();
        frame.add(jp);
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
