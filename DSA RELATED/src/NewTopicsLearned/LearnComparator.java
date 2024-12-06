package NewTopicsLearned;
import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " " + score;
    }
}

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        // Compare by score in descending order
        if (a.score != b.score) {
            return Integer.compare(b.score, a.score);
        } 
        // Compare by name in alphabetical order if scores are the same
        else {
            return a.name.compareTo(b.name);
        }
    }
}

public class LearnComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        Player[] players = new Player[n];
        
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int score = scanner.nextInt();
            players[i] = new Player(name, score);
        }
        
        // Sort using the Checker comparator
        Arrays.sort(players, new Checker());
        
        for (Player player : players) {
            System.out.println(player);
        }
        
        scanner.close();
    }
}
