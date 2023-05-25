public class Defuser extends Powerup{
  public Defuser(Game game){
    super("Defuser", game);
  }

  public void effect(Board board){
    System.out.println("defuser");
    
    this.used = true;
    remove();
  }
}