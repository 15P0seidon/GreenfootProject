import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World{

    boolean test = true;
    private int chunkSize;
    private int worldWidth, worldHeight;
    private SimplexNoise noise;
    private Chunk[][] chunks;
    private Camera cam; //For Movement
    private WorldDrawer worldDrawer;

    public MyWorld(){
        super(1400, 800, 1);

        chunkSize = 16;
        worldWidth = 5 * 16;
        worldHeight = 2 * 16;
        noise = new SimplexNoise();
        chunks = new Chunk[worldWidth / chunkSize][worldHeight / chunkSize];

        for(int chunkX = 0; chunkX < (worldWidth / chunkSize); chunkX++){
            for(int chunkY = 0; chunkY < (worldHeight / chunkSize); chunkY++){
                chunks[chunkX][chunkY] = new Chunk(chunkX, chunkY, chunkSize, noise);
            }
        }
        cam = new Camera();
        worldDrawer = new WorldDrawer(cam, chunkSize, chunks);

        // test();
        
        addObject(cam, 0, 0);
        addObject(worldDrawer, 0, 0);
    }

    public void act(){
        
    }

    public void test(){
        for(int x = 0; x < worldWidth; x++){
            for(int y = 0; y < worldHeight; y++){
                System.out.print((int) (chunks[x / chunkSize][y / chunkSize].getHeightMapXY(x % chunkSize, y % chunkSize)) + " ");
            }
            System.out.println();
        }
    }
}