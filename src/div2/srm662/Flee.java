public class Flee{
    
    public double maximalSafetyLevel(int[] x, int[] y){
        double ret = 0;
        int len = x.length;
        if(len == 1){
            ret = getDist(0, 0, x[0], y[0]);
        }else if(len ==2){
            ret = Math.min(getDist(0, 0, x[0], y[0]), getDist(0, 0, x[1], y[1]));
        }else{
            if(!insideTriangle(0, 0, x, y)){
                double dist1 = getDist(0, 0, x[0], y[0]);
                double dist2 = getDist(0, 0, x[1], y[1]);
                double dist3 = getDist(0, 0, x[2], y[2]);
                return Math.min(dist3, Math.min(dist1, dist2));
            }else{
                double dist1 = helper(x[0], y[0], x[1], y[1], x[2], y[2]);
                double dist2 = helper(x[2], y[2], x[1], y[1], x[0], y[0]);
                double dist3 = helper(x[0], y[0], x[2], y[2], x[1], y[1]);
                ret = Math.max(dist3, Math.max(dist1, dist2));
            }
            
        }
        return ret;
    }
    
    private boolean insideTriangle(int x, int y, int[] xx, int[] yy){
        int totalArea = area(xx[0], yy[0], xx[1], yy[1], xx[2], yy[2]);
        int area1 = area(x, y, xx[0], yy[0], xx[1], yy[1]);
        int area2 = area(x, y, xx[1], yy[1], xx[2], yy[2]);
        int area3 = area(x, y, xx[2], yy[2], xx[0], yy[0]);
        if(totalArea == area1 + area2 + area3){
            return true;
        }else{
            return false;
        }
    }
    
    private int area(int x1, int y1, int x2, int y2, int x3, int y3){
        return Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    }
    
    private double helper(int x1, int y1, int x2, int y2, int x3, int y3){
                double dist1 = getDist(x1, y1, x2, y2) /2;
                double dist2 = getDist(0, 0, x3, y3);
                return Math.min(dist1, dist2);
    } 
    
    private double getDist(int x1, int y1, int x2, int y2){
        int d1 = Math.abs(x1 - x2);
        int d2 = Math.abs(y1 - y2);
        return Math.sqrt(d1 * d1 + d2 * d2);
    }
}