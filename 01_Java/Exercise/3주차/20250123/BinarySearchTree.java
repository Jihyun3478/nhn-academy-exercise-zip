import java.util.*;

public class BinarySearchTree<E> {
	
	private Node<E> root;
	private int size;
	
	private final Comparator<? super E> comparator;
	
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Comparator<? super E> comparator) {
		this.comparator = comparator;
		this.root = null;
		this.size = 0;
	}

	public Node<E> getNode() {
		return root;
	}
	
	/**
	 * Binary Search Tree에 삽입하는 메소드
	 * 
	 * @param value 삽입하고자 하는 데이터
	 * @return 정상적으로 삽입 되었을 경우 true, 중복 원소를 삽입할 경우 false를 반환
	 */
	public boolean add(E value) {
		/* 
		 * comparator(사용자 지정 비교기)가 없을 경우(=null)에는 Comparable,
		 * 있을 경우에는 Comparator를 사용하는 메소드로 보낸다.
		 * 그리고, 각 메소드는 정상적으로 삽입이 완료되었다면 null을 반환할 것이고,
		 * 중복 원소를 삽입 할 경우 해당 value를 반환할 것이기 때문에
		 * 비교 연산으로 null인지 아닌지 여부를 반환한다.
		 */
		if(comparator == null) {
			return addUsingComparable(value) == null;
		}
		return addUsingComparator(value, comparator) == null;
	}
	
	// Comparable을 이용한 add메소드
	private E addUsingComparable(E value) {
		Node<E> current = root; // 탐색할 노드를 가리키는 current node
		
		// 만약 current가 null, 즉 root가 null이면 root에 새 노드를 만들고 null반환
		if(current == null) {
			root = new Node<E>(value);
			size++;
			return null;
		}
		
		Node<E> currentParent;	// current의 직전 탐색 노드를 가리키는 노드
		
		// 삽입 할 노드가 비교 될 수 있도록 한 변수를 만든다. 
		@SuppressWarnings("unchecked")
		Comparable<? super E> compValue = (Comparable<? super E>) value;
		
		int compResult;	// 비교 결과(양수, 0, 음수)를 담고 있을 변수
		
		do {
			// 다음 순회에서 current의 부모노드를 가리킬 수 있도록 현재 current를 저장
			currentParent = current;
			
			compResult = compValue.compareTo(current.value);
			
			/*
			 * 비교 결과 value 보다 current.value 보다 작으면
			 * current를 current의 왼쪽 자식으로 갱신하고,
			 * value보다 current.value가 크다면 current를 오른쪽
			 * 자식으로 갱신하며, 같을 경우 순회를 중단하고 value를 반환한다.
			 */
			if(compResult < 0) {
				current = current.left;
			} else if(compResult > 0) {
				current = current.right;
			}
			else {
				return value;
			}
			
		} while(current != null);
		
		
		// 순회가 완료되어 삽입해야 할 위치를 찾았다면 삽입 할 value를 노드로 만든다.
		Node<E> newNode = new Node<E>(value, currentParent);
		
		// 직전 비교 결과에 따라 currentParent의 오른쪽 혹은 왼쪽 노드에 새 노드를 연결해준다.
		if(compResult < 0) {
			currentParent.left = newNode;
		}
		else {
			currentParent.right = newNode;
		}
		
		size++;
		return null;
	}
	
	// Comparator을 이용한 add
	private E addUsingComparator(E value, Comparator<? super E> comp) {
		Node<E> current = root;

		if(current == null) {
			root = new Node<E>(value, null);
			size++;
			return null;
		}
		
		Node<E> currentParent;
		int compResult;
		do {
			currentParent = current;
			compResult = comp.compare(value, current.value);
			if(compResult < 0) {
				current = current.left;
			}
			else if(compResult > 0) {
				current = current.right;
			}
			else {
				return value;
			}
		} while(current != null);
		
		Node<E> newNode = new Node<E>(value, currentParent);
		if(compResult < 0) {
			currentParent.left = newNode;
		}
		else {
			currentParent.right = newNode;
		}
		size++;
		return null;
	}

    // TODO
    // 1. PreOrder로 순회 출력
    public void preorder() {
        preorder(this.root);
    }

    public void preorder(Node<E> node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // 2. InOrder 순회 출력
    public void inorder() {
        inorder(this.root);
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }

    // 3. PostOrder 순회 출력
    public void postorder() {
        postorder(this.root);
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }
}

class Iterator {
	List<Integer> list = new ArrayList<>();

	public Iterator(Node root) {
		inorder(root);
	}

	public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
			this.list.add((int) node.value);
            inorder(node.right);
        }
    }

	public boolean hasNext() {
		if (this.list.isEmpty()) {
			return false;
		}
		return true;
	}

	public int next() {
		int nextValue = this.list.get(0);
		list.remove(0);

		return nextValue;
	}
}