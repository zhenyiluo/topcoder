package div2.srm547;

/**
 * Created by Eric on 15-3-5.
 */
public class MinimalTriangle {
    public double maximalArea(int length){
        double area = 1.0 * length * length *  Math.sin(Math.toRadians(30)) * Math.sin(Math.toRadians(60));
        return area;
    }
}
