import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.*;

public class EndScreen extends JFrame implements ActionListener {
  //private ImageIcon head = new ImageIcon(MainScreen.class.getResource("minesweeper/imgs/win.png"));

    //private ImageIcon head = new ImageIcon(MainScreen.class.getResource("minesweeper/imgs/lose.png"));

    //private ImageIcon head = new ImageIcon(MainScreen.class.getResource("minesweeper/imgs/playag.png"));

    //private ImageIcon head = new ImageIcon(MainScreen.class.getResource("minesweeper/imgs/mainmen.png"));

    //private ImageIcon head = new ImageIcon(MainScreen.class.getResource("minesweeper/imgs/tips.png"));
  
  JPanel message = new JPanel();
  JPanel buttons = new JPanel();

  JButton playAg, mainMen;

  String gameState = "You win!";
  

  public EndScreen(boolean l) {
    super("Minesweeper++");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.setSize(800, 600);

    if(!l){
      gameState = "You win!";
    } else {
      gameState = "You lost!";
    }
    JLabel winOrLose = new JLabel(gameState);
    playAg = new JButton("Play Again");
    mainMen = new JButton("Main Menu");

    this.add(message, BorderLayout.CENTER);
    this.add(buttons, BorderLayout.SOUTH);
    
    message.setLayout(new FlowLayout());
    message.add(winOrLose);

    buttons.add(playAg);
    playAg.addActionListener(this);
    buttons.add(mainMen);
    mainMen.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == playAg) {
      Game game = new EasyGame();
      this.dispose();
    } else if (e.getSource() == mainMen) {
      JFrame screen = new MainScreen();
      screen.setVisible(true);
      this.dispose();
    }
  }
}