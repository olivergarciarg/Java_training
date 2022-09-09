public class PaintJob {
    public static int getBucketCount(double w, double h, double apb, int extraB) {
        if (apb < 0 || extraB<0) {
            return -1;
        }
        return (int) Math.round((h*w)/(apb*extraB));
    }
}
