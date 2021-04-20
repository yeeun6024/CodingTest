import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int root = Integer.parseInt(br.readLine());
		Tree tree = new Tree(root);
		
		while(true) {
			String str = br.readLine();
			if(str==null) break;
			int node = Integer.parseInt(str);
			tree.add(tree.root, node);
		}
		
		tree.postorder(tree.root);
		

	}
	
	static class Node {
		int node;
		Node left, right;
		
		Node(int node) {
			this.node = node;
		}
				
	}
	
	static class Tree {
		Node root;
		
		Tree(int node) {
			root = new Node(node);
		}
		
		void add(Node root, int next) {
			if(next < root.node) {
				if(root.left==null) root.left = new Node(next);
				else add(root.left, next);
			}
			else {
				if(root.right==null) root.right = new Node(next);
				else add(root.right, next);
			}
		}
			
		void postorder(Node root) {
			if(root.left!=null) postorder(root.left);
			if(root.right!=null) postorder(root.right);
			System.out.println(root.node);
		}
		
	}

}
