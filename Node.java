
class Node<T> {//create needed left and right nodes and create comparable item
	Node leftNode;
	Node rightNode;
	Comparable data;
	public Node(Comparable item){
		this.data = item;
		leftNode = null;//set both sides to be null at first
		rightNode = null;
	}
}
