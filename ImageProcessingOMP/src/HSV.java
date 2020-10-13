public class HSV {
    private float H;
    private float S;
    private float V;

    public HSV (){
        this.H = this.S = this.V = 0;
    }

    public HSV (float H, float S, float V) {
        this.H = H;
        this.S = S;
        this.V = V;
    }
    public HSV (float R, float G, float B, boolean fromRgb){
        this.fromRgbToHsv(R, G, B);
    }

    public HSV (RGB rgbValue){
        this.fromRgbToHsv(rgbValue.getR(), rgbValue.getG(), rgbValue.getB());
    }

    private void fromRgbToHsv (float R, float G, float B) {
        float minimum, maximum, delta;
        minimum = Math.min(R, G);
        minimum = Math.min(minimum, B);

        maximum = Math.max(R, G);
        maximum = Math.max(maximum, B);

        this.setV(maximum);
        delta = maximum - minimum;
        if (maximum != 0)
        {
            this.setS(delta / maximum);
            if (R == maximum)
                this.setH((G - B) / delta);
            else if (G == maximum)
                this.setH(2 + (B - R) / delta);
            else
                this.setH(4 + (R - G) / delta);
            this.setH(this.getH() * 60);
            if (this.getH() < 0)
                this.setH(this.getH() + 360);
        }
        else {
            this.setS(0);
            this.setH(-1);
        }
    }

    public float getH() {
        return H;
    }

    public void setH(float h) {
        this.H = h;
    }

    public float getS() {
        return this.S;
    }

    public void setS(float s) {
        this.S = s;
    }

    public float getV() {
        return this.V;
    }

    public void setV(float v) {
        this.V = v;
    }

    public short getS255() {
        return (short) (this.S * 255);
    }

    public void setS255(short s) {
        this.S = s / 255;
    }

    public short getV255() {
        return (short) (this.V * 255);
    }

    public void setV255(short v) {
        this.V = v / 255;
    }
}
