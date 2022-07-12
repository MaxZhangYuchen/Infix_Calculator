public class Node <T>{
    private T val;
    Node<T> next;
    Node<T> prev;

    public Node(){
        this(null, null, null);
    }

    public Node(T val, Node<T> prev, Node<T> next){
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
    public void setElem(T val) {
        this.val = val;
    }
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public T getElem() {
        return this.val;
    }
    public Node<T> getPrev() {
        return this.prev;
    }
    public Node<T> getNext() {
        return this.next;
    }
}
