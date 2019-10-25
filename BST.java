
public class BST<T> {
	Node rootNode;//create root node
	public Comparable<T> Comp(Node node) {//comparable helper class
		if (node.leftNode.leftNode != null) {
			return Comp(node.leftNode);
		}
		Comparable leftData = node.leftNode.data;
		node.leftNode = node.leftNode.rightNode;
		return leftData;
	}
	public boolean find(Comparable item) {//overload
		return find(rootNode, item);
	}
	public boolean find(Node node, Comparable item) {//recursive
		if (node == null) 
			return false;
		if (node.data.compareTo(item) == 0) 
			return true;
		else if (node.data.compareTo(item) < 0) 
			return find(node.rightNode, item);
		else 
			return find(node.leftNode, item);
	}
	public void insert(Comparable item) {
		rootNode = insert(rootNode, item);//use overload to the the function insert(Node node, Comparable item)
	}	
	public Node insert(Node node, Comparable item) {//check the insert item to see which side the item need to be inserted
		if (node == null) 
			return new Node(item);
		if (node.data.compareTo(item) > 0) 
			node.leftNode = insert(node.leftNode, item);
		else if (node.data.compareTo(item) < 0) 
			node.rightNode = insert(node.rightNode, item);			
		return node;
	}
	
	public void delete (Comparable item) {//use overload to call the function delete(Node node, Comparable item)
		rootNode = delete(rootNode, item);;
	}
	
	public Node delete(Node node, Comparable item) {//recursive
		if (node == null) 
			return node;
		if (node.data.compareTo(item) == 0) {
			if (node.rightNode.leftNode == null) {
				node.data = node.rightNode.data;
				node.rightNode = node.rightNode.rightNode;
				return node;
			} 
			else
				node.data = Comp(node.rightNode);
			if (node.leftNode == null) 
				return node.rightNode;
			if (node.rightNode == null) 
				return node.leftNode;

			
		}
		else if (node.data.compareTo(item) < 0) {
			node.rightNode = delete(node.rightNode, item);
		} 
		else {
			node.leftNode = delete(node.leftNode, item);
		}
		return node;
	}
	public void print() {//overload
		print(rootNode);
	}
	public void print(Node node) {//recursive
		if (node != null) {
			print(node.leftNode);
			System.out.println(node.data);
			print(node.rightNode);
		}
	}
}