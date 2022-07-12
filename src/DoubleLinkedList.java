
import java.lang.IndexOutOfBoundsException;
import java.util.NoSuchElementException;


public class DoubleLinkedList<E> {
    /**
     * 链表头节点
     */
    private DLNode<E> head;
    /**
     * 链表尾节点
     */
    private DLNode<E> tail;
    /**
     * 构造方法：创建空链表
     */
    public DoubleLinkedList() {
        this.head = new DLNode<E>();
        this.tail = new DLNode<E>();
        head.setNext(tail);
        tail.setPrev(head);
    }
    public static void main(String[] args) {
        // ...
    }
    /**
     * 向双向链表指定索引位置插入一个新元素。
     * @param index
     * @param element
     * @return Previous element
     * @throws IndexOutOfBoundsException
     */
    public E insert(int index, E element)
            throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        DLNode<E> current = head;
        while (index >= 0) {
            current = current.getNext();
            --index;
        }
        DLNode<E> node = new DLNode<E>(element, null, null);
        node.setNext(current);
        node.setPrev(current.getPrev());
        current.getPrev().setNext(node);
        current.setPrev(node);;
        return current.getNext() == null ? null : current.getElem();
    }
    /**
     * 移除双向链表指定元素，
     * 操作成功返回{@code true}，不存在目标元素则返回{@code false}。
     * @param element
     * @return Boolean
     */
    public boolean remove(E element) {
        int index = indexOf(element);
        return index != -1 && element.equals(remove(index));
    }
    /**
     * 移除双向链表指定索引下标元素。
     * @param index
     * @return Removed element
     * @throws IndexOutOfBoundsException
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        /* Input: 1 */
        /* head <--> elem(1) <--> elem(2) <--> elem(3) <--> tail */
        DLNode<E> node = head.getNext();
        while (index > 0) {
            node = node.getNext();
            --index;
        }
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        node.setPrev(null);
        node.setNext(null);
        return node.getElem();
    }
    /**
     * 为双向链表指定索引位置的元素设新值。
     * @param index
     * @param element
     * @return Previous element in the index.
     * @throws IndexOutOfBoundsException
     */
    public E set(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        DLNode<E> node = head.getNext();
        while (index > 0) {
            node = node.getNext();
            --index;
        }
        E oldElem = node.getElem();
        node.setElem(element);
        return oldElem;
    }
    /**
     * 获取双向链表指定索引位置的元素。
     * @param index
     * @return element
     * @throws IndexOutOfBoundsException
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        DLNode<E> node = head.getNext();
        while (index > 0) {
            node = node.getNext();
            --index;
        }
        return node.getElem();
    }
    /**
     * 返回指定元素所在双向链表的索引位置。
     * @param element
     * @return The index of element in {@code DoubleLinkedList},
     * return {@code -1} if element does not found.
     */
    public int indexOf(E element) {
        int index = 0;
        for (DLNode<E> current = head.getNext();
             current.getNext() != null;
             current = current.getNext()) {
            if (element.equals(current.getElem())) {
                return index;
            }
            ++index;
        }
        return -1;
    }
    /**
     * 检查双向链表中是否包含目标元素，
     * 元素相等使用 {@code o.equals(obj)} 判断。
     * @param element
     * @return Boolean
     */
    public boolean contains(E element) {
        for (DLNode<E> current = head.getNext();
             current.getNext() != null;
             current = current.getNext()) {
            if (element.equals(current.getElem())) {
                return true;
            }
        }
        return false;
    }
    /**
     * 移除并返回双向链表尾部最后一个元素。
     * @return Last element of this {@code DoubleLinkedList}.
     * @throws NoSuchElementException
     */
    public E removeLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        DLNode<E> node = tail.getPrev();
        node.getPrev().setNext(tail);
        tail.setPrev(node.getPrev());
        node.setPrev(null);
        node.setNext(null);
        return node.getElem();
    }
    /**
     * 移除并返回双向链表头部第一个元素。
     * @return First element of this {@code DoubleLinkedList}.
     * @throws NoSuchElementException
     */
    public E removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        DLNode<E> node = head.getNext();
        node.getNext().setPrev(head);
        head.setNext(node.getNext());
        node.setPrev(null);
        node.setNext(null);
        return node.getElem();
    }
    /**
     * 向双向链表头部添加一个新元素。
     * @param element
     * @return void
     */
    public void addFirst(E element) {
        DLNode<E> node = new DLNode<E>(element, null, null);
        node.setPrev(head);
        node.setNext(
                head.getNext()
        );
        head.setNext(node);
        head.getNext().setPrev(node);
    }
    /**
     * 向双端链表尾部添加一个新元素。
     * @param element
     * @return void
     */
    public void addLast(E element) {
        DLNode<E> node = new DLNode<E>(element, null, null);
        node.setPrev(tail.getPrev());
        node.setNext(tail);
        tail.getPrev().setNext(node);
        tail.setPrev(node);
    }
    /**
     * 取得双向链表头部第一个元素，链表为空则抛出异常。
     * @return First element of {@code DoubleLinkedList}.
     * @throws NoSuchElementException
     */
    public E getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.getNext().getElem();
    }
    /**
     * 取得双向链表尾部最后一个元素，链表为空则抛出异常。
     * @return Last element of {@code DoubleLinkedList}.
     * @throws NoSuchElementException
     */
    public E getLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.getPrev().getElem();
    }
    /**
     * 计算双向链表存储元素数量。
     * @return Size of {@code DoubleLinkedList}.
     */
    public int size() {
        int cnt = 0;
        for (DLNode<E> n = head.getNext();
             n.getNext() != null;
             n = n.getNext()) {
            ++cnt;
        }
        return cnt;
    }
    /**
     * 检查双向链表是否为空。
     * @return Boolean {@code true} or {@code false}.
     */
    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }
    /**
     * 清空双向链表。
     * @return void
     */
    public void clear() {
        while (head.getNext() != null) {
            DLNode<E> current = head;
            head = head.getNext();
            current.setElem(null);
            current.setPrev(null);
            current.setNext(null);
        }
        head = new DLNode<E>();
        tail = new DLNode<E>();
        head.setNext(tail);
        tail.setPrev(head);
    }
    /**
     * 返回双向链表字符串形式。
     * @return void
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (DLNode<E> current = head.getNext();
             current.getNext() != null;
             current = current.getNext()) {
            sb.append(current.getElem().toString());
            sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }
}