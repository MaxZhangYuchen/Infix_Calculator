
public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    private int count;

    /**
     * constructor
     */
    public LinkedList(){
        this.head = new Node<>();
        this.tail = new Node<>();
        head.setNext(tail);
        tail.setPrev(head);
    }

    public void addLast(Node<T> x){

    }






}
