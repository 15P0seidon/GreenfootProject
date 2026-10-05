import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World{

    boolean test = true;
    private SimplexNoise noise;
    private Chunk chunk00, chunk01, chunk02, chunk03;
    
    public MyWorld(){
        super(600, 400, 1);
        
        noise = new SimplexNoise();
        chunk00 = new Chunk(0, 0, 16, noise);
        chunk01 = new Chunk(0, -1, 16, noise);
        chunk02 = new Chunk(0, -2, 16, noise);
        chunk03 = new Chunk(0, -3, 16, noise);
        
        test();
    }

    public void act(){
        if(test == true){
            test();
            test = false;
        }
    }
    
    public void test(){
        chunk00.test();
        chunk01.test();
        chunk02.test();
        chunk03.test();
    }
    
}