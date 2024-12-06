package TCS_Codevita;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaiMiniProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int b = scanner.nextInt(); // initial balance
        int n = scanner.nextInt(); // number of operations
        int cb = 0; // current balance index
        List<Integer> t = new ArrayList<>(); // transaction history
        List<Integer> cs = new ArrayList<>(); // balance states
        cs.add(b); // add initial balance
       
        for (int i = 0; i < n; i++) {
            String placementlelo = scanner.next();
            if (placementlelo.equals("read")) {
                System.out.println(cs.get(cb)); // output current balance
            } else if (placementlelo.equals("credit") || placementlelo.equals("debit")) {
                int x = scanner.nextInt();
                if (placementlelo.equals("credit")) {
                    cs.set(cb, cs.get(cb) + x); // credit operation
                    t.add(x); // log the transaction
                } else {
                    cs.set(cb, cs.get(cb) - x); // debit operation
                    t.add(-x); // log the transaction
                }
            } else if (placementlelo.equals("abort")) {
                int x = scanner.nextInt();
                if (x <= t.size()) {
                    cs.set(cb, cs.get(cb) - t.get(x - 1)); // reverse transaction
                    t.set(x - 1, 0); // mark transaction as aborted
                }
            } else if (placementlelo.equals("rollback")) {
                int x = scanner.nextInt();
                cb = x - 1; // switch to the specified balance state
                cs = cs.subList(0, cb + 1); // resize the balance states
            } else if (placementlelo.equals("commit")) {
                cs.add(cs.get(cb)); // commit the current balance
                cb++;
            }
        }
//        System.out.println(t);
        scanner.close(); // close the scanner resource
    }
}