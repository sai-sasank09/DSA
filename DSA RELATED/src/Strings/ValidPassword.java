package Strings;

public class ValidPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pass= "aisasank@2003";
		System.out.println(validPass(pass));
	}

	private static boolean validPass(String pass) {
		if (pass.length() < 8) {
			return false;
		}
		boolean isUpp=false;
		boolean isSpec=false;
		boolean isNum=false;
		char[] arr= pass.toCharArray();
		for (int i=0;i<arr.length;i++) {
			if (Character.isUpperCase(arr[i])){
				isUpp=true;
			}
			else if (Character.isDigit(arr[i])) {
				isNum=true;
			}
			else if (arr[i]== '@'|| arr[i] == '#' || arr[i] == '%') {
				isSpec=true;
			}
		}
		return isUpp && isNum && isSpec;
		
	}
	

}
