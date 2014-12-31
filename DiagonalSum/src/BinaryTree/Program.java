package BinaryTree;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Program {
	public static void main(){
		SimpleBinaryTree st = new SimpleBinaryTree(0);
		for(int i=1; i<100; i++)
		{
			st.Add(i);
		}
		diagonalPrint(st);
	}
	
	public static void diagonalPrint(SimpleBinaryTree st)
	{
		LinkedList<Node> q = new LinkedList<Node>();
		LinkedList<Node> temp = new LinkedList<Node>();
        int sum = 0;
        q.add(st.root);
        
        while(!(q.isEmpty() && temp.isEmpty())){
        	Node n = q.removeFirst();
        	while(n!=null){
        		sum += n.item;
        		if(n.left != null){
        			temp.add(n.left);}
        		n=n.right;
        	}
        	if(q.isEmpty()){
        		q.addAll(temp);
        		temp.clear();
        		System.out.print(Integer.toString(sum));
        		sum=0;
        	}
        }
	}
}
