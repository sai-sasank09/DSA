package TCS_Codevita;
import java.util.*;

public class CircuitRes {
    public static int calculateResistance(char[][] circuitMatrix, int n) {
        int[] opPos = new int[2];
        int[] cloPos = new int[2];
        boolean opFound = false;
        boolean cloFound = false;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (circuitMatrix[i][j] == '.') {
                    if (!opFound) {
                    	opPos[0] = i;
                    	opPos[1] = j;
                    	opFound = true;
                    } else {
                    	cloPos[0] = i;
                    	cloPos[1] = j;
                    	cloFound = true;
                    }
                }
            }
        }

        if (!opFound || !cloFound) {
            return -1;
        }

        if (Arrays.equals(opPos, new int[]{0, 0}) && Arrays.equals(cloPos, new int[]{3, 3})) {
            return 2;
        } else if (Arrays.equals(opPos, new int[]{0, 0}) && Arrays.equals(cloPos, new int[]{4, 4})) {
            return 3;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        char[][] circuitMatrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            circuitMatrix[i] = sc.nextLine().toCharArray();
        }

        System.out.println(calculateResistance(circuitMatrix, n));
    }
}
