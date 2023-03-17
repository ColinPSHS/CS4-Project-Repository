import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JFrame;

public class EndScreen extends JFrame {
  JPanel message = new JPanel();
  JPanel buttons = new JPanel();

  String gameState = "You win!";

  public EndScreen() {
    super("Minesweeper++");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.setSize(800, 600);

    JLabel winOrLose = new JLabel(gameState);
    JButton playAg = new JButton("Play Again");
    JButton mainMen = new JButton("Main Menu");

    this.add(message, BorderLayout.CENTER);
    this.add(buttons, BorderLayout.SOUTH);
    
    message.setLayout(new FlowLayout());
    message.add(winOrLose);

    buttons.add(playAg);
    buttons.add(mainMen);
  }
}