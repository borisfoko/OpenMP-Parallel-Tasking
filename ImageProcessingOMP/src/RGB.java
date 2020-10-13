public class RGB {
    private float R;
    private float G;
    private float B;

    public RGB (){
        R = G = B = 0;
    }

    public RGB (float R, float G, float B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public RGB (short R255, short G255, short B255) {
        this.R = R255 / 255;
        this.G = G255 / 255;
        this.B = B255 / 255;
    }

    public RGB (HSV hsvValue){
        this.fromHSVToRgb(hsvValue.getH(), hsvValue.getS(), hsvValue.getV());
    }

    public RGB (float H, float S, float V, boolean fromHSV){
        this.fromHSVToRgb(H, S, V);
    }

    public short getR255() {
        return (short) (this.R * 255);
    }

    public void setR255(short R255) {
        this.R = R255 / 255;
    }

    public short getG255() {
        return (short) (this.G * 255);
    }

    public void setG255(short G255) {
        this.G = G255 / 255;
    }
    public short getB255() {
        return (short) (this.B * 255);
    }

    public void setB255(short B255) {
        this.B = B255 / 255;
    }

    public float getR() {
        return this.R;
    }

    public void setR(float R) {
        this.R = R;
    }

    public float getG() {
        return this.G;
    }

    public void setG(float G) {
        this.G = G;
    }
    public float getB() {
        return this.B;
    }

    public void setB(float B) {
        this.B = B;
    }

    private void fromHSVToRgb (float H, float S, float V) {
        float HH, P, Q, T, FF;
        long i;

        if (S <= 0) {
            this.R = this.G = this.B = V;
        } else {
            HH = H;
            if (HH >= 360)
                HH = 0;
            HH /= 60;
            i = (long) HH;
            FF = HH - i;
            P = V * (1 - S);
            Q = V * (1 - (S * FF));
            T = V * (1 - (S * (1 - FF)));

            switch ((int) i) {
                case 0:
                    this.R = V;
                    this.G = T;
                    this.B = P;
                    break;
                case 1:
                    this.R = Q;
                    this.G = V;
                    this.B = P;
                    break;
                case 2:
                    this.R = P;
                    this.G = V;
                    this.B = T;
                    break;
                case 3:
                    this.R = P;
                    this.G = Q;
                    this.B = V;
                    break;
                case 4:
                    this.R = T;
                    this.G = P;
                    this.B = V;
                    break;
                default:
                    this.R = V;
                    this.G = P;
                    this.B = Q;
                    break;
            }
        }
    }
}
