package Strings;

public class removeParantheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeOuterParentheses("(()())"));
	}
	public static String removeOuterParentheses(String s) {
        StringBuilder result= new StringBuilder();
        int depth=0;
        for (char c: s.toCharArray()){
            if (c== '('){
//                System.out.println(0>0);
                if (depth>0){
                    result.append(c);
                }
                depth++;
            }
            else if(c==')'){
//                
                depth--;
                if(depth>0){
                    result.append(c);
                }
               
            }
        }
        return result.toString();
    }

}
