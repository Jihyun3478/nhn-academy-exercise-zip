public class Node<E> {
	E value;
	
	/*
	 *  부모 노드는 BinarySearchTree에서는 당장 쓰이진 않으나 
	 *  추후 용이하게 쓰이니 미리 부모노드를 가리키는 변수도 같이
	 *  구현하면서 익숙해지는 것이 좋다. 	
	 */
	Node<E> left;
	Node<E> right;
	Node<E> parent;
	
	Node(E value) {
		this(value, null);
	}
	
	Node(E value, Node<E> parent) {
		this.value = value;
		this.parent = parent;
		this.right = null;
		this.left = null;
	}
}