import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JFrame;

public class InfoScreen extends JFrame {
  JPanel panel = new JPanel();
  JLabel label = new JLabel();

  private ImageIcon info = new ImageIcon(MainScreen.class.getResource("minesweeper/imgs/info.png"));

  public InfoScreen() {
    super("Information");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.setSize(800, 600);
    this.setVisible(true);
    this.add(panel, BorderLayout.NORTH);

    label.setPreferredSize(new Dimension(733, 550));
    label.setIcon(info);
    panel.add(label);
  }
}