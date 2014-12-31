import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Watson gives an array A1,A2...AN to Sherlock. Then he asks him to find if there exists an element in the array, such that, the sum of elements on its left is equal to the sum of elements on its right. If there are no elements to left/right, then sum is considered to be zero.
Formally, find an i, such that, A1+A2...Ai-1 = Ai+1+Ai+2...AN
 */

public class SherlockArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int t = Integer.parseInt(br.readLine());
			
			while(t!=0){
				int n = Integer.parseInt(br.readLine());
				String[] s = br.readLine().split(" ");
				int[] a = new int[n];
				for(int i=0; i<n; i++){
					a[i] = Integer.parseInt(s[i]);
				}
				if(isElementThere(a)){
					System.out.println("YES");
				}
				else{
					System.out.println("NO");
				}
				t--;
			}
		}
		catch(IOException io)
		{
		}
}
	public static boolean isElementThere(int[] a){
		int sum = 0;
		for(int i=0; i < a.length; i++)
		{
			sum+=a[i];
		}
		int left = 0, right = sum;
		for(int j = 0; j < a.length; j++){
			right -= a[j];
			if(left == right)
			{
				return true;
			}
			left += a[j];
		}
		return false;
	}
}