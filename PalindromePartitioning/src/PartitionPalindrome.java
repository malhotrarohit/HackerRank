
public class PartitionPalindrome {
	
	static int[][] P;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababbbabbababa";
		char[] c = s.toCharArray();
		P = new int[c.length][c.length];
		
		for(int i=0; i<P.length; i++){
			for(int j=0; j<P.length; j++){
				P[i][j] = -1;
			}
		}
		int ans = MinPartitionPalindrome(c, 0, c.length-1);
		System.out.println(Integer.toString(ans));
	}
	
	public static int MinPartitionPalindrome(char[] c, int low, int high){
		if(low==high){
			return 1;
		}
		else if (high - low == 1 && c[low] == c[high]){
			return 2;
		}
		else if(P[low][high] != -1){
			return P[low][high];
		}
		
		if(isPalindrome(c, low, high)){
			return 1;
		}
		for(int i=low; i<=high; i++){
			for(int j=i+1; j<=high; j++){
				P[i][j] = MinPartitionPalindrome(c, i, j-1) + MinPartitionPalindrome(c, j, high) + 1;
			}
		}
		return P[low][high];
	}
	
   public static boolean isPalindrome(char[] c, int low, int high)
   {
	   if(c.length == 1) return true;
	   else{
		   int i = low, j = high;
		   while(i < j){
			   if(c[i] != c[j]){
				   return false;
			   }
		   }
		   return true;
	   }
   }

}
