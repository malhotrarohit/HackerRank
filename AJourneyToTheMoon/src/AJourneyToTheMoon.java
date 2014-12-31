import java.io.*;
import java.util.*;

/*The member states of the UN are planning to send 2 people to the Moon. But there is a problem. In line with their principles of global unity, they want to pair astronauts of 2 different countries.

There are N trained astronauts numbered from 0 to N-1. But those in charge of the mission did not receive information about the citizenship of each astronaut. The only information they have is that some particular pairs of astronauts belong to the same country.

Your task is to compute in how many ways they can pick a pair of astronauts belonging to different countries. Assume that you are provided enough pairs to let you identify the groups of astronauts even though you might not know their country directly. For instance, if 1,2,3 are astronauts from the same country; it is sufficient to mention that (1,2) and (2,3) are pairs of astronauts from the same country without providing information about a third pair (1,3).
*/
public class AJourneyToTheMoon {
	static class Edge {
		public int id;
		public Edge next;
	};
	
   public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        try{
        String[] temp = bfr.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);
        Edge[] edges = new Edge[N];
        int[] states = new int[N];

        for(int i = 0; i < I; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            
            Edge e = new AJourneyToTheMoon.Edge();
            e.id = b;
            e.next = edges[a];
            edges[a] = e;
            
            Edge e2 = new Edge();
            e2.id = a;
            e2.next = edges[b];
            edges[b] = e2;
        }
        
        long combinations = findNumCombinations(edges, states);

        // Compute the final answer - the number of combinations
       
        System.out.println(combinations);
        }catch(IOException io)
        {
        	
        }
    }
   
   public static int findNumCombinations(Edge[] edges, int[] states)
   {
	   int[] lens = new int[edges.length];
	   LinkedList<Integer> l = new LinkedList<Integer>();
	   
	   for(int i=0; i<edges.length; i++)
	   {
		   if(edges[i] != null && states[i] == 0)
		   {
			   LinkedList<Integer> ll = new LinkedList<Integer>();
			   dfsInternal(edges, i, states, ll);
			   lens[i] = ll.size();
			   l.add(i);
		   }
	   }
	   int sum = 0;
	   for(int k = 0 ; k < l.size(); k++)
	   {
		   for(int m = k+1; m < l.size(); m++)
		   {
			   sum += lens[l.get(k)] * lens[l.get(m)];
		   }
	   }
	   
	   return sum;
   }
   
   public static void dfsInternal(Edge[] edges, int node, int[] states, LinkedList<Integer> ll)
   {
	   states[node] = 1;
	   Edge e = edges[node];
	   ll.add(node);
	   
	   while(e != null){
		   if(states[e.id] == 0){
			   dfsInternal(edges, e.id, states, ll);
		   }
		   e = e.next;
	   }
   }
}
