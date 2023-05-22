public class Defuser extends Powerup{
  public Defuser(Game game){
    super("Defuser", game);
  }

  public void effect(Board board){
    used = true;
    remove();
  }
}