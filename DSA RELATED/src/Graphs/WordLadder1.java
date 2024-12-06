package Graphs;
import java.util.*;
public class WordLadder1 {
	class Pair{
		String first;
		int second;
		Pair(String first, int second){
			this.first=first;
			this.second=second;
		}
	}	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<Pair> q= new LinkedList<>();
		q.add(new Pair(beginWord,1));
		Set<String> stt= new HashSet<>();
		for (String word: wordList) {
			stt.add(word);
		}
		stt.remove(beginWord);
		while (!q.isEmpty()) {
			String word= q.peek().first;
			int steps= q.peek().second;
			q.poll();
			if(word.equals(endWord)) {
				return steps;
			}
			for (int i=0;i<word.length();i++) {
				for(char ch='a';ch<='z' ;ch++) {
					char[] charArr= word.toCharArray();
					charArr[i]=ch;
					String replacedWord= new String(charArr);
					//if exits then remove it from the set dude :)
					if(stt.contains(replacedWord)) {
						stt.remove(replacedWord);
						q.add(new Pair(replacedWord,steps+1));
					}
				}
			}
		}
		return 0;
	}
}
