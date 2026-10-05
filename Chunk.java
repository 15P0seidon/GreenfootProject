import java.util.Arrays;

public class Chunk {

    private int chunkX;
    private int chunkY;
    private int chunkSize;
    private double[][] heightMap;
    private SimplexNoise globalNoise;

    Chunk(int chunkX, int chunkY, int chunkSize, SimplexNoise golbalNoise){
        this.chunkX = chunkX;
        this.chunkY = chunkY;
        this.chunkSize = chunkSize;
        this.globalNoise = golbalNoise;
        this.heightMap = new double[chunkSize][chunkSize];

        generate(chunkX, chunkY, globalNoise);
        test();
    }

    public void test(){
        String arrayToString = Arrays.deepToString(heightMap);
        System.out.println(arrayToString);
    }

    public void generate(int chunkX, int chunkY, SimplexNoise globalNoise){
        for (int localX = 0; localX < chunkSize; localX++) {
            for (int localY = 0; localY < chunkSize; localY++) {

                int globalX = chunkX * chunkSize + localX;
                int globalY = chunkY * chunkSize + localY;

                heightMap[localX][localY] = globalNoise.noise(globalX, globalY);

            }
        }
    }

}
