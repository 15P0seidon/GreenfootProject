import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World{

    boolean test = true;
    private SimplexNoise noise;
    private Chunk chunk;
    
    public MyWorld(){
        super(600, 400, 1);
        
        noise = new SimplexNoise();
        chunk = new Chunk(0, 0, 16, noise);
        
        test();
    }

    public void act(){
        if(test == true){
            test();
            test = false;
        }
    }
    
    public void test(){
        chunk.test();
    }
    
}
