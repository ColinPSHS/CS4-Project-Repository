import java.util.ArrayList;

public abstract class Game {
  protected final String difficulty;
  protected final int mines, powerUps, tiles;
  
  public Game(String d, int m, int p, int t) {
    difficulty = d;
    mines = m;
    powerUps = p;
    tiles = t;

    int size = Math.sqrt(t);
    Tile matrix = new Tile[size][size];
  }

  public String getDifficulty () {
    return difficulty;
  }

  public int getMines () {
    return mines;
  }

  public int getPowerUps () {
    return powerUps;
  }

  public int getTiles () {
    return tiles;
  }
}