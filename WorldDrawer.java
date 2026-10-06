import greenfoot.*;

/**
 * Draws the World Tiles
 */
public class WorldDrawer extends Actor {

    private int PosX, PosY;
    private int chunkSize;
    private Chunk[][] chunks;
    private Camera cam;
    private int tileSize = 16; //Maybe add variable into Main (MyWorld)

    public WorldDrawer(Camera cam, int chunkSize, Chunk[][] chunks){

        PosX = cam.getX();
        PosY = cam.getY();
        this.chunkSize = chunkSize;
        this.chunks = chunks;
        this.cam = cam;
        
    }
    
    public void act(){
        resetPos();
        draw();
    }

    public void resetPos(){
        PosX = cam.getX();
        PosY = cam.getY();
    }
    
    public void draw(){
        getWorld().getBackground().clear();
        
        //create all the Images once for less lag
        GreenfootImage blue = new GreenfootImage("Blue.png");
        GreenfootImage green = new GreenfootImage("Green.png");
        GreenfootImage brown = new GreenfootImage("Brown.png");
        
        for(int x = 0; x < chunks.length * chunkSize; x++){
            for(int y = 0; y < chunks[0].length * chunkSize; y++){
                int value = (int) (chunks[x / chunkSize][y / chunkSize].getHeightMapXY(x % chunkSize, y % chunkSize));

                if(value < 2){
                    getWorld().getBackground().drawImage(blue, x * tileSize + PosX, y * tileSize + PosY);
                } else 
                if(value < 4){
                    getWorld().getBackground().drawImage(green, x * tileSize + PosX, y * tileSize + PosY);
                } else {
                    getWorld().getBackground().drawImage(brown, x * tileSize + PosX, y * tileSize + PosY);
                }
            }
        }
    }
}