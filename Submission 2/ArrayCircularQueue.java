public class ArrayCircularQueue {

    int[] queue;
    int front;
    int rear;
    int size;
    int capacity;

    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            return -1;
        }

        int value = queue[front];
        front = (front + 1) % capacity;
        size--;

        return value;
    }

    public void display() {
        int currentIndex = front;

        for (int count = 0; count < size; count++) {
            System.out.print(queue[currentIndex] + " ");
            currentIndex = (currentIndex + 1) % capacity;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ArrayCircularQueue circularQueue = new ArrayCircularQueue(5);

        circularQueue.enqueue(10);
        circularQueue.enqueue(20);
        circularQueue.enqueue(30);

        circularQueue.display();

        circularQueue.dequeue();

        circularQueue.display();
    }
}