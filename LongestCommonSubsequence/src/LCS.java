import java.util.*;
/*
 A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. Longest common subsequence (LCS) of 2 sequences is a subsequence, with maximal length, which is common to both the sequences. 

Given two sequence of integers, A=[a1,a2,…,an] and B=[b1,b2,…,bm], find any one longest common subsequence.

In case multiple solutions exist, print any of them. It is guaranteed that at least one non-empty common subsequence will exist.
 */
import java.io.*;
public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			String[] input = br.readLine().split(" ");
			int m = Integer.parseInt(input[0]);
			int n = Integer.parseInt(input[1]);
			char[] a = br.readLine().toCharArray();
			char[] b = br.readLine().toCharArray();
			LCS(a,b,m,n);
		}
		catch(IOException io){
			io.printStackTrace();
		}
		
	}
	
	public static void LCS(char[] a, char[] b, int m, int n)
	{
		int[][] L = new int[m+1][n+1];
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++){
				if(a[i] == b[j]){
					L[i+1][j+1]=L[i][j]+1;
				}
				else{
					L[i+1][j+1]=Math.max(L[i+1][j], L[i][j+1]);	
				}
			}
		}
		Backtrack(L, a, b, m, n);
	}
	
	public static void Backtrack(int[][] L, char[] a, char[] b, int i, int j)
	{
		if(i==0 || j==0)
		{
			return;
		}
		else if (a[i-1] == b[j-1])
		{
			Backtrack(L, a, b, i-1, j-1);
			System.out.print(a[i-1]);
		}
		else{
			if(L[i][j-1] > L[i-1][j]){
				Backtrack(L, a, b, i, j-1);
			}
			else{
				Backtrack(L, a, b, i-1, j);
			}
		}
	}
}
