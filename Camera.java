import greenfoot.*;
import greenfoot.Actor;

/**
 * This class is for handling Position in the World
 */
public class Camera extends Actor {
    
    private int x, y;
    
    public Camera(){
        x = 0;
        y = 0;
    }
    
    public void act(){
        SimpleMovement();
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void SimpleMovement(){
        if(Greenfoot.isKeyDown("d")){
            x += 1;
        } else
        if(Greenfoot.isKeyDown("a")){
            x -= 1;
        }
    }
    
}
