import java.util.ArrayList;

public class Tile {
  protected final String type;
  boolean dug = false;
  Game game;
  int number = 0;
  int x, y;
  
  public Tile(String t, Game g, int X, int Y) {
    type = t;
    game = g;
    x = X;
    y = Y;

    ArrayList<ArrayList<Tile>> array = game.getGridMatrix();
  }

  public String getType () {
    return type;
  }

  public int getNum () {
    return number;
  }

  public boolean getDigState () {
    return dug;
  }

  public void dig() {
    if (type == "mine") {
      game.lost = true;
      dug == true;
    } else if (type == "safe") {
      for (int i = -1; i < 2; i++) {
        for (int j = -1; j < 2; j++) {
          if (array.get(i).get(j).getType() == "mine") {
            number++;
          }
        }
      }

      dug == true;
    } else if (type == "powerup") {
      
    } 
  }
}