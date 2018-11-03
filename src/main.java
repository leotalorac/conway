import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        JFrame window = new JFrame("world");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500,500);
        window.setResizable(false);
        JPanel mainpanel = new worldpanel();
        window.add(mainpanel);
        window.setVisible(true);
    }
}
