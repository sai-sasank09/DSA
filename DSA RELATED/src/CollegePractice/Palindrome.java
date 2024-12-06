package CollegePractice;
import java.util.*;

import org.w3c.dom.html.HTMLMetaElement;
public class Palindrome {

	public static void main(String[] args) {
		int[] arr1= {1,2,2,2,2,3,4,5};
		HashMap<Integer,Integer> hm=new HashMap<>();
		for(int i=0;i<arr1.length;i++) {
			int key=arr1[i];
			hm.put(key,hm.getOrDefault(key, 0)+1);
		}
		System.out.println(hm);
	}
}
		