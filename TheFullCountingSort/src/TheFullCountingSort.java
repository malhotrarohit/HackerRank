import java.io.*;
/*
 In this challenge you need to print the data that accompanies each integer in a list. In addition, if two strings have the same integers, you need to print the strings in their original order. Hence, your sorting algorithm should be stable, i.e. the original order should be maintained for equal elements.

Insertion Sort and the simple version of QuickSort were stable, but the faster in-place version of Quicksort was not (since it scrambled around elements while sorting).

In cases where you care about the original order, it is important to use a stable sorting algorithm. In this challenge, you will use counting sort to sort a list while keeping the order of the strings (with same accompanying integer) preserved.
 */
public class TheFullCountingSort {
	
	static class Node {
		public int originalIndex;
		public int givenIndex;
		public String s;
		public Node next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node[] nodes = new Node[100];
		Node[] helper = new Node[100];
		
		try{
			int t = Integer.parseInt(br.readLine());
			for(int i=0; i<t; i++){
				String[] in = br.readLine().split(" ");
				Node n = new TheFullCountingSort.Node();
				n.originalIndex = Integer.parseInt(in[0]);
				n.givenIndex = i;
				n.s = in[1];
				if(nodes[n.originalIndex] == null)
				{
					nodes[n.originalIndex] = n; 
					helper[n.originalIndex] = nodes[n.originalIndex];
				}
				else
				{
					helper[n.originalIndex].next = n;
					helper[n.originalIndex] = n;
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<100; j++)
			{
				if(nodes[j] != null){
					Node temp = nodes[j];
					while(temp != null){
						if(temp.givenIndex < t/2)
						{
							sb.append("- ");
						}
						if(temp.givenIndex >= t/2){
							sb.append(temp.s + " ");
						}
						temp = temp.next;
					}
				}
			}
			
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.toString());
		}catch(IOException io){
			
		}
		
	}

}
