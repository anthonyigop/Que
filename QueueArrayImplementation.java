/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package queuearrayimplementation;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class QueueArrayImplementation {

    int front, rear, capacity;
    int queue[];
    
    /**
     * @param args the command line arguments
     */
    
    
    public QueueArrayImplementation(int size) {
        front = 0;
        rear = -1;
        capacity = size;
        queue = new int[capacity];
    }

    
    public boolean isFull() {
        return rear == capacity - 1;
    }

    
    public boolean isEmpty() {
        return front > rear;
    }

    
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full " + element);
            return;
        }
        queue[++rear] = element;
        System.out.println("Enqueued: " + element);
    }

    
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }
        System.out.println("Dequeued: " + queue[front++]);
    }

    
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[front];
    }

    
     public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }   
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[front];
    }
    
    public static void main(String[] args) {
        
         Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the queue: ");
        int capacity = scanner.nextInt();
        
        // Initialize the queue with the user-defined capacity
        QueueArrayImplementation queue = new QueueArrayImplementation(capacity);

        boolean exit = false;

        // User operations loop
        while (!exit) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Check if Queue is Empty");
            System.out.println("5. Check if Queue is Full");
            System.out.println("6. Display the Queue");
            System.out.println("7. Exit");
            System.out.print("Choose an operation: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Enqueue operation
                    System.out.print("Enter the element to enqueue: ");
                    int element = scanner.nextInt();
                    queue.enqueue(element);
                    break;
                case 2:
                    // Dequeue operation
                    queue.dequeue();
                    break;
                case 3:
                    // Peek operation
                    int frontElement = queue.peek();
                    if (frontElement != -1) {
                        System.out.println("Front element: " + frontElement);
                    }
                    break;
                case 4:
                    // Check if queue is empty
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is not empty.");
                    }
                    break;
                case 5:
                    // Check if queue is full
                    if (queue.isFull()) {
                        System.out.println("Queue is full.");
                    } else {
                        System.out.println("Queue is not full.");
                    }
                    break;
                case 6:
                    // Display the queue
                    queue.display();
                    break;
                case 7:
                    // Exit
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Program terminated.");
    }
    
}
