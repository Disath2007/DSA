import java.util.LinkedList;
import java.util.Queue;

public class StackQueueDequeueFriendly {

    Queue<Integer> pushQueue = new LinkedList<>();
    Queue<Integer> popQueue = new LinkedList<>();

    public void push(int data) {
        pushQueue.add(data);
    }

    public int pop() {
        if (pushQueue.isEmpty()) {
            return -1;
        }

        while (pushQueue.size() > 1) {
            popQueue.add(pushQueue.remove());
        }

        int value = pushQueue.remove();

        Queue<Integer> tempQueue = pushQueue;
        pushQueue = popQueue;
        popQueue = tempQueue;

        return value;
    }

    public static void main(String[] args) {
        StackQueueDequeueFriendly stackQueue = new StackQueueDequeueFriendly();

        stackQueue.push(10);
        stackQueue.push(20);
        stackQueue.push(30);

        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
    }
}