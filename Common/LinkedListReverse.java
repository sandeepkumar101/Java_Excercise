package common;
import java.util.LinkedList;
import java.util.List;

public class LinkedListReverse {
    public static void main(String[] args) {
        LinkedList<Node> list = new LinkedList<Node>();
        list.add(new Node(1, null));
        list.add(new Node(2, list.peekLast()));
        list.add(new Node(3, list.peekLast()));
        list.add(new Node(4, list.peekLast()));
        list.add(new Node(5, list.peekLast()));

        System.out.println(list);
        System.out.println(reverceLinkedList(list));
    }

    public static LinkedList<Node> reverceLinkedList(LinkedList<Node> ll) {
        if (ll == null)
            return null;

        LinkedList<Node> reverseHead = new LinkedList<Node>();
        Node prevNode = null;
        while (ll.peek() != null) {
            Node currentNode = ll.poll();
            currentNode.next = prevNode;
            prevNode = currentNode;
            reverseHead.add(currentNode);
        }
        System.out.println("reverseHead:" + reverseHead);

        return null;

    }
}
