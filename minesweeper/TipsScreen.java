import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TipsScreen extends JFrame{
    JPanel header = new JPanel();

    public TipsScreen(){
        this.setLayout(new FlowLayout());
        this.setSize(500, 360);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        label.setBorder(border);
        label.setPreferredSize(new Dimension(500, 360));
        try{
          String lineWanted = Files.readAllLines(Paths.get("txts/legit tips.txt")).get(3);
          label.setText(lineWanted);
        }
        catch (Exception ex){
          return;
        }
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        this.add(label);
        this.setVisible(true);
    }

    }