package BinaryTree;
import java.util.Random;

    class Node {
	public int item;
	public Node left;
	public Node right;
}

public class SimpleBinaryTree {
	
	Node root;
	Random r;
	
	public SimpleBinaryTree(int item){
		Node n = new Node();
		n.item = item;
		root = n;
	}
	
	public void Add(int item){
		if(root != null){
			Node n = root;
			while(n.left != null && n.right != null){
				boolean b = r.nextBoolean();
				if(b)
				{
					n = n.left;
				}
				else{
					n = n.right;
				}
			}
			if(n.left == null){
				n.left = new Node();
				n.left.item = item;
			}
			else{
				n.right = new Node();
				n.right.item = item;
			}
		}
	}
}
