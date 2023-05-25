import java.util.ArrayList;
import java.util.Random;

public class Tile {
  protected final String type;
  boolean dug = false;
  boolean flag = false;
  Game game;
  int number = 0;
  int x, y;
  ArrayList<ArrayList<Tile>> array;

  Random rand = new Random(); 

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
    new Xray(game);
    if (!dug) {
      dug = true;
      if (!game.firstDig) {
        game.generateGame(x, y);
        game.firstDig = true;
        System.out.println(game.firstDig);
      }
      if (type == "mine") {
        game.lost = true;
        game.checkState(this);
      } else if (type == "safe") {
        checkNumber();
        game.dug++;
        game.checkState(this);
      } else if (type == "powerup") {
        checkNumber();
        game.dug++;
        game.checkState(this);
        // add powerup
        int x = rand.nextInt(3);

        if (x == 0) {
          new ReverseMine(game);
        } else if (x == 1) {
          new Defuser(game);
        } else if (x == 2) {
          new Xray(game);
        }
      }
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