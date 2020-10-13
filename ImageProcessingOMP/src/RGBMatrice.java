public class RGBMatrice {

    private int height;
    private int width;
    private RGB rgbImage[][];
    private HSV hsvImage[][];

    public  RGBMatrice () {
        this.height = 0;
        this.width = 0;
        this.rgbImage = new RGB[width][height];
        this.hsvImage = new HSV[width][height];
    }

}