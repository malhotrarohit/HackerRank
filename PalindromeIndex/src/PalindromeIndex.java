import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* Find the index of the element that when deleted will turn a given string into a palindrome*/

public class PalindromeIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int t = Integer.parseInt(br.readLine());
			while(t!=0)
			{
				char[] c = br.readLine().toCharArray();
				System.out.println(palindrome(c));
				t--;
			}
		}catch(IOException io)
		{
		}
	}
	
	public static int palindrome(char[] c)
	{
		for(int i=0, j=c.length-1; i < j; i++, j--)
		{
			if(c[i] == c[j])
			{
				continue;
			}
			else{
				if(c[i+1] == c[j]){
					if(isPalindrome(c, i+1, j)) return i;
				}
				else if(c[j-1] == c[i])
				{
					if(isPalindrome(c, i, j-1)) return j;
				}
				else{
					return -1;
				}
			}
		}
		return -1;
	}
	
	public static boolean isPalindrome(char[] c, int low, int high)
	{
		while(low < high && c[low] == c[high])
		{
			low++;
			high--;
		}
		
		if(low < high){
			return false;
		}
		return true;
	}
}
