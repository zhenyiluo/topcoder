package div2.srm633;

/**
 * Created by Eric on 15-3-4.
 */
public class Target {
    public String[] draw(int n){
        String[] result = new String[n];
        char[][] c = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                c[i][j] = ' ';
            }
        }
        int startX = 0;
        int startY = 0;
        for(int num = n; num >= 1; num = num -4) {
            for (int i = 0; i < num - 1; i++) {
                c[startX][startY + i] = '#';
            }

            for (int i = 0; i < num - 1; i++) {
                c[startX + i][startY + num - 1] =  '#';
            }

            for(int i = 0; i < num -1; i++){
                c[startX + num -1][startY + num -1 -i] = '#';
            }

            for(int i = 0; i < num -1; i++){
                c[startX + num -1 -i][startY] = '#';
            }
            startX += 2;
            startY += 2;
        }
        c[n/2][n/2] = '#';
        for(int i = 0; i < n; i++) {
            result[i] = new String(c[i]);
        }
        return result;
    }
}
