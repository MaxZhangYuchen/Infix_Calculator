public class DLNode<E> {
    private E elem;
    private DLNode<E> prev;
    private DLNode<E> next;
    public DLNode(E elem, DLNode<E> prev, DLNode<E> next) {
        this.elem = elem;
        this.prev = prev;
        this.next = next;
    }
    public DLNode() {
        this(null, null, null);
    }
    public void setElem(E elem) {
        this.elem = elem;
    }
    public void setPrev(DLNode<E> prev) {
        this.prev = prev;
    }
    public void setNext(DLNode<E> next) {
        this.next = next;
    }
    public E getElem() {
        return this.elem;
    }
    public DLNode<E> getPrev() {
        return this.prev;
    }
    public DLNode<E> getNext() {
        return this.next;
    }
}
