import java.util.*;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(23);
		tree.add(12);
		tree.add(40);
		tree.add(7);
		tree.add(16);
		tree.add(1);
		tree.add(14);
		tree.add(17);
		tree.add(29);
		tree.add(55);
		tree.add(61);

        System.out.print("전위 순회 : ");
        tree.preorder();
        System.out.println();

        System.out.print("중위 순회 : ");
        tree.inorder();
        System.out.println();

        System.out.print("후위 순회 : ");
        tree.postorder();
        System.out.println();

        System.out.print("반복자 : ");
        Iterator iterator = new Iterator(tree.getNode());

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}