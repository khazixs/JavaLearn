package Learn;

import javax.swing.*;
import java.awt.*;

public class Example1 extends JFrame {
    public void CreatJFrame(String title){
        JFrame jf = new JFrame(title);
        Container container = jf.getContentPane();
        JLabel jl = new JLabel("这是一个JFrame窗口");
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(jl);
        container.setBackground(Color.white);
        jf.setVisible(true);
        jf.setSize(200,150);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Example1().CreatJFrame("创建一个JFrame窗体");
    }
}
