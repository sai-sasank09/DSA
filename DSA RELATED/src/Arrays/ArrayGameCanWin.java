package Arrays;
import java.util.*;

public class ArrayGameCanWin {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        int n=game.length;
        boolean[] visit= new boolean[n];
        Queue<Integer> que= new ArrayDeque<>();
        
        que.add(0);
        
        while(!que.isEmpty()){
            int pos= que.poll(); 
            if (pos>=n){
                return true;
            }
            if (pos<0 || visit[pos] || game[pos]==1){
                continue;   
            }
            visit[pos]=true;
            que.offer(pos+1);
            que.offer(pos+leap);
            que.offer(pos-1);
 
        }
        return false;
 
      
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
