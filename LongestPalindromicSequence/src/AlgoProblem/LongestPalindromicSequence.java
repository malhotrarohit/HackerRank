package AlgoProblem;

public class LongestPalindromicSequence {

	static int[][] M;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABBAAC";
		char[] c = new char[s.length()];
		c = s.toCharArray();
		M = new int[s.length()][s.length()];
		int l = s.length();
		for(int i=0; i<l; i++){
			for(int j=0; j<l; j++){
				if(j<i){
					M[i][j] = -1;
				}
				else{
					M[i][j] = 0;
				}
			}
		}
		System.out.println(LongestPalindromic(c, 0, c.length-1));
	}
	
	public static int LongestPalindromic(char[] c, int low, int high){
		if(high == low) return 1;
		if (high-low == 1 && c[low] == c[high]) return 2;
		if(M[low][high] != 0 && M[low][high] != -1){
			return M[low][high];
		}
		else if(c[low] == c[high]){
			return (M[low][high] = LongestPalindromic(c, low+1, high-1) + 2);
		}
		else{
			M[low+1][high] = LongestPalindromic(c, low+1, high);
			M[low][high-1] = LongestPalindromic(c, low, high-1);
			return Math.max(M[low+1][high], M[low][high-1]);
		}
	}
	
}
