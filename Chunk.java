import java.util.Arrays;

public class Chunk {

    private int chunkX;
    private int chunkY;
    private int chunkSize;
    private double[][] heightMap;
    private SimplexNoise globalNoise;
    private double zoomFactor; //smaller -> more zoomed in
    private int octaves;
    private int frequency;

    Chunk(int chunkX, int chunkY, int chunkSize, SimplexNoise golbalNoise){
        this.chunkX = chunkX;
        this.chunkY = chunkY;
        this.chunkSize = chunkSize;
        this.heightMap = new double[chunkSize][chunkSize];
        this.globalNoise = golbalNoise;
        zoomFactor = 0.1;
        octaves = 16;
        frequency = 2;

        generate(chunkX, chunkY, globalNoise);
    }

    public void test(){
        // String arrayToString = Arrays.deepToString(heightMap);
        // System.out.println(arrayToString);
        // System.out.println("");
        
        for (int localX = 0; localX < chunkSize; localX++) {
            for (int localY = 0; localY < chunkSize; localY++) {
                
                int heightMapVal = (int) (heightMap[localX][localY] * 3);
                
                if(heightMapVal < 3){ 
                    System.out.print("I");
                } else if(heightMapVal < 5){
                    System.out.print("L");
                } else if(heightMapVal < 8){
                    System.out.print("U");
                } else {
                    System.out.print("O");
                }
                
                // System.out.print((int) (heightMap[localX][localY] * 10) + " ");
            }
            System.out.println("");
        }
    }

    public void generate(int chunkX, int chunkY, SimplexNoise globalNoise){
        for (int localX = 0; localX < chunkSize; localX++) {
            for (int localY = 0; localY < chunkSize; localY++) {

                int globalX = chunkX * chunkSize + localX;
                int globalY = chunkY * chunkSize + localY;
                
                for(int i = 1; i < octaves + 1; i++){
                    double noiseVal = globalNoise.noise(globalX * (zoomFactor * i), globalY * (zoomFactor * i)) + 1;
                    double corrNoiseVal = (noiseVal / i);
                    heightMap[localX][localY] = heightMap[localX][localY] + corrNoiseVal; 
                }
            }
        }
    }
}