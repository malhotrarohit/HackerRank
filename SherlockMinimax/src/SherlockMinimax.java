import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
Watson gives Sherlock an array A1,A2...AN. 
He asks him to find an integer M between P and Q(both inclusive), such that, min {|Ai-M|, 1 ≤ i ≤ N} is maximised. If there are multiple solutions, print the smallest one.
*/

public class SherlockMinimax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			String[] str1 = br.readLine().split(" ");
			int[] a = new int[n];
			for(int i=0; i<n; i++){
				a[i] = Integer.parseInt(str1[i]);
			}
			String[] str2 = br.readLine().split(" ");
			int p = Integer.parseInt(str2[0]);
			int q = Integer.parseInt(str2[1]);
			System.out.println(findM(a, p, q));
			
		}catch(IOException io)
		{	}

}
	public static int findM(int[] a, int p, int q)
	{
		Arrays.sort(a);
		
		if(p < a[0] && q > a[a.length - 1]){
			int max = Integer.MIN_VALUE;
			int m = 0;
			for(int i=0; i<a.length-1; i++)
			{
				if(Math.abs(a[i] - a[i+1])>max){
					max = Math.abs(a[i] - a[i+1]);
					m = (a[i] + a[i+1])/2;
				}
			}
			return(MaxValue(Math.abs(p - a[0]), max/2, Math.abs(q - a[a.length-1]), p, m, q));
		}
		
		else if((p >= a[0] && p < a[a.length - 1]) && q <= a[a.length - 1]){
			int i,j,k, max = Integer.MIN_VALUE, m = 0;
			for(i=0; i<a.length; i++){
				if(a[i] >= p){
					break;
				}
			}
			for(j=0; j<a.length; i++){
				if(a[j] >= q){
					break;
				}
			}
			for(k = i; k<j; k++){
				if(Math.abs(a[k] - a[k+1])>max){
					max = Math.abs(a[k] - a[k+1]);
					m = (a[k] + a[k+1])/2;
				}
			}
			return(MaxValue(Math.min(Math.abs(p - a[i-1]),Math.abs(p - a[i])), max/2, Math.min(Math.abs(q - a[j-1]),Math.abs(q - a[j])), p, m, q));
		}
		
		else if((p > a[0] && p < a[a.length - 1]) && q > a[a.length - 1]){
			int i,k, max = Integer.MIN_VALUE, m = 0;
			for(i=0; i<a.length; i++){
				if(a[i] >= p){
					break;
				}
			}
			for(k = i; k<a.length-1; k++){
				if(Math.abs(a[k] - a[k+1])>max){
					max = Math.abs(a[k] - a[k+1]);
					m = (a[k] + a[k+1])/2;
				}
			}
			return (MaxValue(Math.min(Math.abs(p - a[i]),Math.abs(p - a[i-1])), max/2, Math.abs(q - a[a.length-1]), p, m, q));
		}
		
		else if(p < a[0] && (q > a[0] && q < a[a.length - 1])){
			int i,k, max = Integer.MIN_VALUE, m = 0;
			for(i=0; i<a.length; i++){
				if(a[i] >= q){
					break;
				}
			}
			for(k = i; k<a.length-1; k++){
				if(Math.abs(a[k] - a[k+1])>max){
					max = Math.abs(a[k] - a[k+1]);
					m = (a[k] + a[k+1])/2;
				}
			}
			return (MaxValue(Math.abs(p - a[0]), max/2, Math.min(Math.abs(a[i] - q), Math.abs(a[i-1] - q)), p, m, q));
		}
		
		else if(p > a[a.length - 1]){
			return q;
		}
		
		else if(q < a[0]){
			return p;
		}
		return 0;
	}
	
	public static int MaxValue(int a, int b, int c, int d, int e, int f)
	{
		int[] ar = new int[3];
		ar[0] = a;
		ar[1] = b;
		ar[2] = c;
		int max = Integer.MIN_VALUE;
		for(int i : ar)
		{
			if(i > max){
				max = i;
			}
		}
		if(max == a){
			return d;
		}
		else if (max == b){
			return e;
		}
		else{
			return f;
		}
	}
}
