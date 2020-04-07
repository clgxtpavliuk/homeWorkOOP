package hometask3.linkedListTask;

public class Test {
    public static void main (String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("dog");
        linkedList.add("cat");
        linkedList.add("rebit");
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.size());
        linkedList.remove(0);

        System.out.println(linkedList);
        System.out.println(linkedList.size());
    }
}
