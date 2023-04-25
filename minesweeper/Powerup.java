import java.util.ArrayList;

public abstract class Powerup{
  String type;
  boolean used = false;
  Game game;

  
  public Powerup(String t, Game g){
    type = t;
    game = g;
    g.inventory.add(this);
  }

  public String getType(){
    return this.type;    
  }

  public boolean getUsed(){
    return this.used;
  }

  public void setUsed(){
    used = true;
  }

  public void remove(){
    if(used=true){
      game.inventory.remove(this);
    }
  }

  public abstract void effect();
}