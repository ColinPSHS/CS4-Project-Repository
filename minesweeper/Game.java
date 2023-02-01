public abstract class Game {
  protected final String difficulty;
  protected final int mines, powerUps, tiles;
  
  public Game(String d, int m, int p, int t) {
    difficulty = d;
    mines = m;
    powerUps = p;
    tiles = t;
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