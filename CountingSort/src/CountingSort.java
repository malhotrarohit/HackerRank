import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*Given a list of integers, can you count and output the number of times each value appears?

Hint: There is no need to sort the data, you just need to count it.*/
public class CountingSort {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
	        int n = Integer.parseInt(br.readLine());
	        int[] a = new int[n];
	        String[] s = br.readLine().split(" ");
	        int[] count = new int[100];
	        for(int i=0; i<s.length; i++)
	        {
	            a[i] = Integer.parseInt(s[i]);
	            count[a[i]]++;
	        }
	        
	        for(int j=1 ; j < 100; j++){
	            count[j] += count[j-1];
	        }
	        int[] output = new int[a.length];
	        StringBuilder sb = new StringBuilder();
	        for(int k=0; k < a.length; k++)
	        {
	            output[count[a[k]] - 1] = a[k];
	            count[a[k]]--;
	        }
	        for(int m=0; m<output.length; m++)
	        {
	            sb.append(Integer.toString(output[m]) + " ");    
	        }
	        sb.deleteCharAt(sb.length()-1);
	        System.out.println(sb.toString());
        }catch(IOException io){
            
        }
    }
}