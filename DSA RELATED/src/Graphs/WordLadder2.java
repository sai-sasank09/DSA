package Graphs;
import java.util.*;

public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, 
            String endWord, List<String> wordList) {
        
        Set<String> st = new HashSet<>(wordList);
        Queue<List<String>> q = new LinkedList<>();
        List<String> lst = new ArrayList<>();
        lst.add(beginWord);
        q.add(lst);
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;
        List<List<String>> result = new ArrayList<>();

        while (!q.isEmpty()) {
            List<String> top = q.peek();
            q.poll();
            if (top.size() > level) {
                level++;
                for (String it : usedOnLevel) {
                    st.remove(it);
                }
            }
            String word = top.get(top.size() - 1);
            if (word.equals(endWord)) {
                if (result.size() == 0) result.add(top);
                else if (result.get(0).size() == top.size()) result.add(top);
            }
            for (int i = 0; i < word.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    char[] replArr = word.toCharArray();
                    replArr[i] = j;
                    String newWord = new String(replArr);
                    if (st.contains(newWord)) {
                        top.add(newWord);
                        List<String> temp = new ArrayList<>(top);
                        q.add(temp);
                        usedOnLevel.add(newWord);
                        top.remove(top.size() - 1);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        WordLadder2 wordLadder = new WordLadder2();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        List<List<String>> ladders = wordLadder.findLadders(beginWord, endWord, wordList);

        System.out.println("Shortest transformation sequences from " + beginWord + " to " + endWord + ":");
        for (List<String> ladder : ladders) {
            System.out.println(ladder);
        }
    }
}
