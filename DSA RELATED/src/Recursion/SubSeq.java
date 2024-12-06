package Recursion;
import java.util.*;
import java.util.ArrayList;

public class SubSeq {
	//subsequence is for strings
	//subsets is for arrays
	public static void main(String[] args) {
		Subsequence("","abc");
		System.out.print(Subseq("","abc"));
		SubseqASCII("","abc");
		System.out.print(SubseqAscii("","abc"));

	}
	static void Subsequence(String p,String up) {
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char ch= up.charAt(0);
		Subsequence(p+ch,up.substring(1));
		Subsequence(p,up.substring(1));
	}
	
	static void SubseqASCII(String p,String up) {
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char ch= up.charAt(0);
		SubseqASCII(p+ch,up.substring(1));
		SubseqASCII(p,up.substring(1));
		SubseqASCII(p+(ch+0),up.substring(1));
	}
	static ArrayList<String> Subseq(String p, String up){
		
		if (up.isEmpty()) {
			ArrayList<String> list= new ArrayList<>();
			list.add(p);
			return list;
		}
		char ch=up.charAt(0);
		ArrayList<String> l= Subseq(p+ch,up.substring(1));
		ArrayList<String> r= Subseq(p,up.substring(1));
		l.addAll(r);
		return l;
	}
	static ArrayList<String> SubseqAscii(String p, String up){
	
		if (up.isEmpty()) {
		ArrayList<String> list= new ArrayList<>();
		list.add(p);
		return list;
		}
		char ch=up.charAt(0);
		ArrayList<String> l= Subseq(p+ch,up.substring(1));
		ArrayList<String> r= Subseq(p,up.substring(1));
		ArrayList<String> t= Subseq(p+(ch+0),up.substring(1));
		l.addAll(r);
		l.addAll(t);
		return l;
	}

}
