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

  public void dig() {
    if (type == "mine") {
      game.lost = true;
    } else if (type == "safe") {
      // for (int i = 0)
      
    } else if (type == "powerup") {
      
    } 
  }
}