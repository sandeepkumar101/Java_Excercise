package twopointer;

public class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return data + ", " + next;
    } 
}
