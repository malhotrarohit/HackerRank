
public class EvenSubstringEqualSum {
	
	public static int[][] S;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1538023";
		int len = s.length();
		int n = Integer.parseInt(s);
		int[] nList = new int[len];
		int temp = n,i=0;
		while(temp!=0){
			nList[nList.length - 1 - i] = temp%10;
			temp = temp/10;
			i++;
		}
		S = new int[len][len];
		for(int i1=0;i1<len;i1++){
			for(int j=0; j<len; j++){
				if(i==j){
					S[i][j] = nList[i];
				}
			}
		}
		
		System.out.print(Integer.toString(maxLen(nList)));
	}
	
	public static int maxLen(int[] nList)
	{
		int maxLen = 0;
		for(int i=0; i<nList.length; i++)
		{
			for(int j=i+1; j<nList.length; j++){
				int len = j-i+1;
				int k = len/2;
				S[i][j] = S[i][k] + S[k+1][j];
				if(len%2 == 0 && S[i][k] == S[k+1][j] && len > maxLen)
					maxLen = len;
			}
		}
		return maxLen;
	}
	
	/*public static void Fib(int n)
	{
		int preprev = 0;
		int prev = 1;
		int curr = 1;
		while(curr != n)
		{
			System.out.println(Integer.toString(curr));
			preprev = prev;
			prev = curr;
			curr = preprev + prev;
			if(curr > n)break;
		}
	}*/

}
