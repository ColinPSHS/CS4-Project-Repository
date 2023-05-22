import javax.swing.*;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.*;

public class EndScreen extends JFrame implements ActionListener {
  private ImageIcon winner = new ImageIcon(EndScreen.class.getResource("minesweeper/imgs/win.png"));

    private ImageIcon loser = new ImageIcon(EndScreen.class.getResource("minesweeper/imgs/lose.png"));

    private ImageIcon imgPlayAg = new ImageIcon(EndScreen.class.getResource("minesweeper/imgs/playag.png"));

    private ImageIcon imgMainMen = new ImageIcon(EndScreen.class.getResource("minesweeper/imgs/mainmen.png"));

    private ImageIcon helpTips = new ImageIcon(EndScreen.class.getResource("minesweeper/imgs/tips.png"));
  
  JPanel message = new JPanel();
  JPanel buttons = new JPanel();
  JLabel messContent = new JLabel();

  JButton playAg, mainMen, hTips;
  

  public EndScreen(boolean l) {
    super("Minesweeper++");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.setSize(800, 600);
    this.add(message, BorderLayout.NORTH);
    this.add(buttons, BorderLayout.CENTER);

    if(!l){
      messContent = new JLabel(winner, JLabel.CENTER);
    } else {
      messContent = new JLabel(loser, JLabel.CENTER);
    }

    
    playAg = new JButton(imgPlayAg);
    mainMen = new JButton(imgMainMen);
    hTips = new JButton(helpTips);
    
    message.setLayout(new FlowLayout());
    message.add(messContent);

    playAg.setAlignmentX(Component.CENTER_ALIGNMENT);
    mainMen.setAlignmentX(Component.CENTER_ALIGNMENT);
    hTips.setAlignmentX(Component.CENTER_ALIGNMENT);
    playAg.setPreferredSize(new Dimension(700, 100));
    mainMen.setPreferredSize(new Dimension(700, 100));
    hTips.setPreferredSize(new Dimension(700, 100));
    buttons.add(playAg);
    buttons.add(mainMen);
    buttons.add(hTips);
    playAg.addActionListener(this);
    mainMen.addActionListener(this);
    hTips.addActionListener(this);
    
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