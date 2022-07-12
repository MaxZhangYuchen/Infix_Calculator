
import java.util.EmptyStackException;
import java.util.LinkedList;

//借助LinkedList 类中的方法实现队列
public class MyQueue <E> {
    private LinkedList<E> li = new LinkedList<E>();

    // 1构造方法
    public MyQueue() {

    }

    // 2出列
    public E get() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return li.removeFirst();
    }

    // 3进列
    public void put(E obj) {
        li.addLast(obj);
    }

    // 4清空
    public void clear() {
        li.clear();
    }

    // 5 返回队列首元素(不删除)
    public E getTop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return li.getFirst();
    }

    // 6将对象转换成字符串
    public String toString() {
        return li.toString();
    }

    // 7判断队列是否为空
    public boolean isEmpty() {
        return li.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue<String> mq = new MyQueue<>();
        // 进列
        mq.put("a");
        mq.put("b");
        mq.put("c");

        // 出列
        System.out.println(mq.get());
        System.out.println(mq.get());

        // 返回对首元素
        System.out.println(mq.getTop());

    }
}
