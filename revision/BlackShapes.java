package revision;

import java.util.PriorityQueue;
import java.util.Queue;

public class BlackShapes {
    
    public int black(String[] A) {
        int totalShapes = 0;
        int n = A.length;
        int m = A[0].length();
        char[][] mat = new char[n][m];
        
            
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = A[i].charAt(j);
            }
        
        }
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 'X'){
                    dfs(mat,i,j);
                    totalShapes += 1;
                }
            }
        }
        
        return totalShapes;
    }
    
    private void dfs(char[][] mat, int i, int j) {
        int n = mat.length;
        int m = mat[0].length;
        if (i >=0 && i <= n && j >= 0 && j <= m && mat[i][j] == 'X'){
            mat[i][j] = '0';
            return;
        }
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for (int k = 0; k < 4; k++) {
            dfs(mat, i + dx[k], j + dy[k] );
        }
    }

    public static void main(String[] args) {
        String[] arrS = {"XXX","XXX","XXX"};
        BlackShapes bs = new BlackShapes();
        System.out.println(bs.black(arrS));
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b - a));
        maxHeap.offer(1);
        maxHeap.offer(2);
        System.out.println(maxHeap.poll());
    }
}
