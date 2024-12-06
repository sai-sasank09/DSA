package Strings;
import java.util.*;
public class CompressedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compress("aaabbccc"));
	}
	static String compress(String str) {
		StringBuilder strr= new StringBuilder();
		HashMap<Character, Integer> mpp = new HashMap<>();
		for(Character ch : str.toCharArray()) {
			mpp.put(ch, mpp.getOrDefault(ch, 0)+1);
		}
		System.out.println(mpp);
		for (Map.Entry<Character,Integer> entry: mpp.entrySet()) {
			char chh= entry.getKey();
			strr.append(chh);
			int count= entry.getValue();
			strr.append(count);
		}
//		return strr.toString();
		
		// other method
		int countt=1;
		for (int i=0;i<str.length()-1;i++) {
			if (str.charAt(i) == str.charAt(i+1)) {
				countt++;
				if (i==str.length()-2) {
					strr.append(str.charAt(i));
					strr.append(countt+1);
				}
			}
			
			else {
				strr.append(str.charAt(i));
				strr.append(countt);
				countt=1;
				
			}
		}
		return strr.toString();
	}

}
