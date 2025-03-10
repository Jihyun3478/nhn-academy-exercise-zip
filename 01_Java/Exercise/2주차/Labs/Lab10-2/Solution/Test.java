public class Test {
    public static void main(String[] args) {
        /*
        List list = new ArrayList();

        list.add(1);
        list.add("Celine");
        list.add(1.0);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(((ArrayList)list).getElements()[i]);
        }

        list.remove(1);

        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(((ArrayList)list).getElements()[i]);
        }
        */

        List list = new LinkedList();

        list.add(1);
        list.add("Celine");
        list.add(1.0);

        LinkedList list2 = (LinkedList)list;

        Node node = list2.head;
        while(node != null) {
            System.out.println(node.data);
            node = node.nextNode;
        }
    }
}
