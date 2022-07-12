
import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStack<E> {
    private DoubleLinkedList<E> li=new DoubleLinkedList<E>();

    //1构造方法
    public MyStack(){

    }

    //2出栈
    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return li.removeFirst();
    }

    //3进栈
    public void push(E obj){ //注意o不要0的区别，不要写成0了
        li.addFirst(obj);
    }

    //4清空
    public void clear() {
        li.clear();
    }
    //5判断是否为空
    public boolean isEmpty(){
        return li.isEmpty();
    }

    //6 将对象转换成字符串
    public String toString(){
        return li.toString();
    }

    //7返回栈口元素
    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return li.getFirst();

    }

    public static void main(String[] args) {
        MyStack<String> stack=new MyStack<>();
        //进栈
        stack.push("a");
        stack.push("b");

        //出栈
        System.out.println(stack.pop());

        //返回栈口元素
        System.out.println(stack.peek());

    }

}

