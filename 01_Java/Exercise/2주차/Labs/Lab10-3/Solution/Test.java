public class Test {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
        System.out.println(list1.get(2));

        System.out.println(list1.remove(1));

        Iterator iterator1 = list1.iterator();
        while(iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }

        System.out.println();

        List list2 = new LinkedList();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        System.out.println(list2.remove(0));

        Iterator iterator2 = list2.iterator();
        while(iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }
    }
}
