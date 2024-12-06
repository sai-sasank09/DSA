package TCS_Codevita;
import java.util.*;

class DanceRevolution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); 
        String[] instr = new String[n];
        for (int i = 0; i < n; i++) {
            instr[i] = sc.nextLine();
        }
        int res = Integer.MAX_VALUE;
        Map<String, Integer> memo = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                res = Math.min(res, helper(instr, 0, i, j, memo));
            }
        }
        System.out.println(res);
    }

    static Map<String, Integer> mpp = Map.of("up", 0, "down", 1, "left", 2, "right", 3);

    public static int helper(String[] instr, int index, int left, int right, Map<String, Integer> memo) {
        if (index == instr.length) {
            return 0;
        }

        // ummm we are doing memo here (memorization) we can consider this as a dp method
        String key = index + "," + left + "," + right;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int curr = mpp.get(instr[index]);
        int mleft = helper(instr, index + 1, curr, right, memo) + (left == curr ? 0 : 1);
        int mright = helper(instr, index + 1, left, curr, memo) + (right == curr ? 0 : 1);

        
        int result = Math.min(mleft, mright);
        memo.put(key, result);
        return result;
    }
}

