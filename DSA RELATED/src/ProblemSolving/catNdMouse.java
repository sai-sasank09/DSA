package ProblemSolving;

public class catNdMouse {

	public static void main(String[] args) {
		System.out.println(catAndMouse(1,2,3));
		// TODO Auto-generated method stub

	}
	static String catAndMouse(int x, int y, int z) {
        String ab="";
        int catAD=Math.abs(z-x);
        int catBD= Math.abs(z-y);
        if (catAD < catBD){
//             System.out.println("Cat A");
             return "Cat A";
        }
        
        else if (catAD > catBD){
//             System.out.println("Cat B");
             return "Cat B";
             
        }
        else{
//            System.out.println("Mouse C");
            return "Mouse C";
        }
    
//         return "-1";

    }
}
