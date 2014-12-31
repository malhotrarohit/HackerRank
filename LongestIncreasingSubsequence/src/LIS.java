
import java.io.*;
/*
 The task is to find the length of the longest subsequence in a given array of integers such that all elements of the subsequence are sorted in ascending order. For example, the length of the LIS for { 15, 27, 14, 38, 26, 55, 46, 65, 85 } is 6 and the longest increasing subsequence is {15, 27, 38, 55, 65, 85}. 
 */
public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			String s = br.readLine();
			int[] a = new int[Integer.parseInt(s)];
			for(int i=0; i<Integer.parseInt(s); i++)
			{
				a[i] = Integer.parseInt(br.readLine());
			}
			System.out.println(LongestIncreasingSubsequence(a));
			
		}catch(IOException io){
			io.printStackTrace();
		}
	}
	
	public static int LongestIncreasingSubsequence(int[] a){
		int[] L = new int[a.length];
		int[] prev = new int[a.length];
		int maxLen=0, bestEnd = -1;
		
		for(int i=0; i<L.length;i++){
			L[i]=1;
		}
		for(int m=0; m<prev.length;m++){
			prev[m] = -1;
		}
		
		for(int j=1; j<L.length; j++)
		{
			for(int k=j-1; k>=0; k--){
				if(L[k] >= L[j] && a[j] > a[k]){
					L[j] = L[k]+1;
					prev[j] = k;
				}
			}
			if(maxLen < L[j]){
				maxLen = L[j];
				bestEnd=j;
			}
		}
		return maxLen;
	}

}
