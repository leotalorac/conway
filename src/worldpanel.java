import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class worldpanel extends JPanel implements ActionListener{
    private Timer timer;
    private cells ctable;
    private int w =4;

    public worldpanel() throws FileNotFoundException {
        this.setBackground(Color.white);
        this.timer = new Timer(1000,this);
        timer.start();
        ctable = new cells("table3.txt");
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.blue);
        ArrayList tem = ctable.getlist();
        for(int i =0;i<tem.size();i++){
            int[] j = (int[])(tem.get(i));
            g.fillRect(j[0],j[1],w,w);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        try {
            ctable.recalculate();
//            Thread.sleep(10);
//        } catch (InterruptedException e1) {
//            e1.printStackTrace();
//        }
        repaint();
    }
}
