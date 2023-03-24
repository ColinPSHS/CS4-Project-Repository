import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JFrame;

public class InfoScreen extends JFrame {
  

  public InfoScreen() {
    super("Information");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.setSize(800, 600);
  }
}