package Stack;

public class CelebrityProblem {

	public static void main(String[] args) {

        int n = 4;
        int[][] matrix = { { 0, 0, 1, 0 },
                           { 0, 0, 1, 0 },
                           { 0, 0, 0, 0 },
                           { 0, 0, 1, 0 } };
        int id = WhoIsCelbrity(n, matrix);
        if (id == -1) {
            System.out.println("No celebrity");
        }
        else {
            System.out.println("Celebrity ID " + id);
        }

	}

	private static int findCelebrity(int n, int[][] mat) {
		int[] knowMe=new int[mat.length];
		int[] iKnow=new int[mat[0].length];
		
		for (int i=0;i<mat.length;i++) {
			for (int j=0;j<mat.length;j++) {
				if(mat[i][j] == 1) {
					knowMe[j]++;
					iKnow[i]++;
				}
			}
		}
		for (int i=0;i<mat.length;i++) {
			if(knowMe[i]== mat.length-1 && iKnow[i] == 0) {
				return i;
			}
		}
		return -1;
	}
	public static int WhoIsCelbrity(int n,int[][] mat) {
		int top=0;
		int down=mat.length-1;
		while (top<down) {
			if(mat[top][down] == 1) {
				top++;
			}
			else if (mat[down][top]== 1) {
				down--;
			}
			else {
				top++;
				down--;
			}
		}
		if (top>down) {
			return -1;
		}
		for (int i=0;i<mat.length;i++) {
			if (i == top) continue;
		if(mat[top][i] == 0 && mat[i][top] ==1) {
				
				return top;
			}
		else {
			return -1;
		}
		}
		return -1;
	}

}
