package Arrays;
import java.util.*;
public class RevverseList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer>al=new ArrayList<>();
		al.add(3);
		al.add(2);
		al.add(1);
		System.out.println(al);
		int l=0;
	
		int r=al.size()-1;
		while(l<r) {
			int temp= al.get(l);
			al.set(l,al.get(r));
			al.set(r,temp);
			l++;
			r--;
		}
		System.out.println(al);

	}

}
