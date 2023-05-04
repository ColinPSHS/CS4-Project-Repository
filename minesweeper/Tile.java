import java.util.ArrayList;

public class Tile {
  protected final String type;
  boolean dug = false;
  boolean flag = false;
  Game game;
  int number = 0;
  int x, y;
  ArrayList<ArrayList<Tile>> array;

  public Tile(String t, Game g, int X, int Y) {
    type = t;
    game = g;
    x = X;
    y = Y;

    array = game.getGridMatrix();
  }

  public String getType() {
    return type;
  }

  public int getNum() {
    return number;
  }

  public boolean getDigState() {
    return dug;
  }

  public int checkNumber() {
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        if (((x + j) < 0) || ((y + i) < 0) || ((x + j) >= array.size()) || ((y + i) >= array.size())) {
          continue;
        } else {
          if (array.get(y + i).get(x + j).getType() == "mine") {
            number++;
          }
        }
      }
    }

    return number;
  }

  public void dig() {
    if (!dug) {
      if (!game.firstDig) {
        game.generateGame();
        game.firstDig = true;
        System.out.println(game.firstDig);
      }
      if (type == "mine") {
        game.lost = true;
        game.checkState();
      } else if (type == "safe") {
        checkNumber();
      } else if (type == "powerup") {
        // add powerup
        checkNumber();
      }
      dug = true;
    }

  }

  public void flagTile() {
    if (flag) {
      flag = false;
    } else {
      flag = true;
    }
  }
}