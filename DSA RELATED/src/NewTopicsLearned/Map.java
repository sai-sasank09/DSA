package NewTopicsLearned;
import java.util.*;
import java.io.*;

class Map{
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
      HashMap<String, Integer> mpp= new HashMap<>();
		int n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			in.nextLine();
          mpp.put(name,phone);
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
          
          if (mpp.containsKey(s)) {
              System.out.println(s+"="+mpp.get(s));
      }
      else{
          System.out.println("Not found");
      }
          
          
		}
      // System.out.print(mpp);
      
      
      
      
      
	}
}



