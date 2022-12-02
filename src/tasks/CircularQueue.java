package tasks;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CircularQueue {
    private int front, rear;
    private int[] nums;
    public CircularQueue() {
        this.front = this.rear = -1;
        //read file
        ReadFile newReader = new ReadFile();
        newReader.readArray();
        this.nums = new int[newReader.numbersArrayInt.get(0).size()];
        // enqueue what is from the text file
        for (Object j: newReader.numbersArrayInt.get(0)) {
            this.enqueue((Integer) j);
            System.out.println("initial enqueue");
        }

        System.out.println(this.nums.length + "nums length");
    }

    public void enqueue(int data) {
        if (isFull()) {
            resize();
        }
        else if (isEmpty()) {
            front = rear = 0;
            nums[front] = data;
        }
        else {
            rear = (rear + 1) % nums.length;
            nums[rear] = data;

        }
    }
    public int dequeue() {
        // if empty then you have nothing to dequeue
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        // value of element to be dequeued
        int temp = nums[front];

        if (front == rear) {
            front = rear = -1;
        }
        // move front to 1 index forward
        else {
            front = (front+1) % nums.length;
        }
        return temp;
    }

    private boolean isFull() {
        // if rear is just to the left of the front index
        return (rear + 1) % nums.length == front;
    }

    private boolean isEmpty() {
        // both front and rear would be -1 if the circular queue is empty
        return front == -1;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return nums[rear];
    }

    public void resize() {
        // create new array with double size
        int[] tempArr = new int[nums.length * 2];
        int i = 0;
        int j = front;

        do {
            tempArr[i++] = nums[j];
            j = (j+1) % nums.length;
        } while (j != front);

        front = 0;
        rear = nums.length-1;
        nums = tempArr;
    }

    public void printArray() {
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front Index -> " + front);
            System.out.print("Circular Queue -> ");
            for (i = front; i != rear; i = (i + 1) % this.nums.length)
                System.out.print(this.nums[i] + " ");
            System.out.println(this.nums[i]);
            System.out.println("Rear Index -> " + rear);
        }

    }

    public static void main(String[] args) {
        CircularQueue circleQ = new CircularQueue();
        circleQ.peek();
        circleQ.dequeue();
        circleQ.enqueue(1111);
        circleQ.printArray();
    }
}
