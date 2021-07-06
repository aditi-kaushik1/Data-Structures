public class Heap {
    private int[] items = new int[10];
    private int size = 0;

    public void insert(int value) {
        if(isFull())
            throw new IllegalStateException();
        items[size++] = value;

        bubbleUp();
    }

    public int remove() {
        if(isEmpty())
            throw new IllegalStateException();
        int root = items[0];
        items[0] = items[--size];
        bubbleDown();
        return root;
    }
    
    private void bubbleDown() {
        var index = 0;
        while(index <= size && !isValidParent(index)) {
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int largerChildIndex(int index) {
        //Heap is filled from left to right, so if there's no left child, then the right child is null too.
        if(!hasLeftChild(index))
            return index;
        if(!hasRightChild(index))
            return leftChildIndex(index);
        return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        if(!hasLeftChild(index))
            return true;

        boolean isValid = items[index] >= items[leftChild(index)];
        if(hasRightChild(index))
            isValid &= items[index] >= rightChild(index);

        return isValid;
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }
    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    private boolean isFull() {
        return size == items.length;
    }

    private void bubbleUp() {
        var index = size - 1;
        while(index > 0 && items[index] > items[parent(index)]) {
            swap(items[index], items[parent(index)]);
            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1)/2;
    }
    private void swap(int first, int second) {
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }
}

//Main class --

import java .util.*;
public class Main
{
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
        heap.remove();
    }
}
