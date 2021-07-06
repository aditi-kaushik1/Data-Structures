//Node class

public class Node {
    int key;
    String value;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

//**************************************************************************************

//MinHeap class

public class MinHeap {
    public Node[] arr = new Node[10];
    public int size = 0;

    public void insert(int key, String value) {
        if(isFull())
            throw new IllegalStateException();

        arr[size] = new Node(key, value);

        bubbleUp(size);
        size++;
    }

    public void bubbleUp(int index) {
        while(index > 0 && arr[index].key > arr[(index - 1)/2].key) {
            swap(index, (index - 1)/2);
            index = (index - 1)/2;
        }
    }

    public void printHeap() {
        for(int i = 0; i < size; i++) {
            System.out.println(arr[i].key + " - " + arr[i].value);
        }
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public void swap(int i, int j) {
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int remove() {
        Node root = arr[size - 1];
        arr[0] = arr[size - 1];
        size--;
        int index = 0;
        while(true) {
            if(!hasLeftChild(index) || arr[index].key > arr[largerIndex(index)].key)
                break;
            swap(index, largerIndex(index));
            index = largerIndex(index);
        }
        return root.key;
    }

    public int largerIndex(int index) {
        if(!hasLeftChild(index))
            return index;
        else if(!hasRightChild(index))
            return 2*index + 1;
        else
            return (arr[index*2 + 1].key > arr[2*index + 2].key) ? 2*index + 1 : 2*index + 2;

    }

    public boolean hasLeftChild(int index) {
        return 2 * index + 1 < size;
    }

    public boolean hasRightChild(int index) {
        return 2 * index + 2 < size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

//***********************************************************************************************************

//PriorityQueueMinHeap class

public class PriorityQueueMinHeap {
    public MinHeap heap = new MinHeap();
    public void insert(int priority, String value) {
        heap.insert(priority, value);
    }

    public int remove() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void print() {
        heap.printHeap();
    }
}

//**********************************************************************************************************

//Main class

import java .util.*;
public class Main
{
    public static void main(String[] args) {
//        MinHeap heap = new MinHeap();
//        heap.insert(1,"A");
//        heap.insert(2,"B");
//        heap.insert(4,"C");
//        heap.insert(22,"F");
//        heap.printHeap();
//        System.out.println("***********");
//        heap.remove();
//        System.out.println("***********");
//        heap.printHeap();
//        heap.remove();
//        System.out.println("***********");
//        heap.printHeap();
//        heap.remove();
//        System.out.println("***********");
//        heap.printHeap();

        PriorityQueueMinHeap pq = new PriorityQueueMinHeap();
        pq.insert(1, "a");
        pq.insert(2,"u");
        pq.insert(0,"a");
        pq.insert(9,"p");
        pq.print();
        pq.remove();
        System.out.println("*");
        pq.print();
        pq.remove();
        System.out.println("*");
        pq.print();
        pq.remove();
        System.out.println("*");
        pq.print();
        pq.remove();
        System.out.println(pq.isEmpty());
    }
}
