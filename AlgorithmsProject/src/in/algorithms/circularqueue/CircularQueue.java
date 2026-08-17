package in.algorithms.circularqueue;

public class CircularQueue {
    private int[] queue;
    private int head = -1;
    private int rear = -1;
    private int size;

    public CircularQueue(int size) {
        this.size = size;
        this.queue = new int[size];
    }

    public void enqueue(int element) {
        if ((head == 0 && rear == size - 1) || (rear == head - 1)) {
            System.out.println(" Cannot insert " + element + ".Queue is full");
        } else {
            if (rear == size - 1) {
                rear = 0;
            } else {
                rear = rear + 1;
            }
            queue[rear] = element;
            if (head == -1) {
                head = 0;
            }
            System.out.println(element + " inserted");
        }
    }

    public Integer dequeue() {
        if (head == -1) {
            System.out.println("Queue is empty");
            return null;
        } else {
            int deleted = queue[head];
            System.out.println(deleted + " is deleted");
            if (head == rear) {
                head = -1;
                rear = -1;
            } else if (head == size - 1) {
                head = 0;
            } else {
                head = head + 1;
            }
            return deleted;
        }
    }

    public void display() {
        if (rear == -1) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("The elements are");
            if (head <= rear) {
                for (int i = head; i <= rear; i++) {
                    System.out.print(queue[i] + "->");
                }
            } else {
                for (int i = head; i < size; i++) {
                    System.out.print(queue[i] + "->");
                }
                for (int i = 0; i <= rear; i++) {
                    System.out.print(queue[i] + "->");
                }
            }
            System.out.println();
        }
    }
}
