public class Main
{
  int front;
  int rear;
  int size;
  int[] queue; 
  int capacity = 4;
  
  public static void main(String[] args)
  {
    Main q = new Main(4);
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    q.enqueue(40);
    System.out.println(q.isFull());
    System.out.println(q.peekFront());
    System.out.println(q.peekLast());
    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();
    System.out.println(q.isEmpty());
  }
  
  Main(int capacity) {
      queue = new int[capacity];
      front = -1;
      rear = -1;
      size = 0;
  }
  
  public void enqueue(int x)
  {
    if ((size== capacity) || ((rear + 1)%capacity == front)) {
      System.out.println("Queue is full");
      return;
    }
    if (size == 0)
      front = 0;
    rear = (rear + 1) % capacity;
    queue[rear] = x;
    size++;
    System.out.println(x + " has been enqueued");
  }

  public boolean isEmpty()
  {
    System.out.print("Queue is empty: ");
    return (size == 0 || (front == -1 && rear == -1));
  }

  public boolean isFull()
  {
    System.out.print("Queue is full: ");
    return (size == capacity || (rear + 1)%capacity == front);
  }

  public void dequeue()
  {
    if (size == 0 || (front == -1 && rear == -1))
      throw new IllegalStateException();
    else if (front == 0 && rear == 0) {
        front = -1;
        rear = -1;
        return;
    }
    front = (front + 1) % capacity;
    size--;
    System.out.println("Item has been dequeued");
  }

  public int peekFront()
  {
    if (front == -1)
      throw new IllegalArgumentException();
    else
        return queue[front];
  }

  public int peekLast()
  {
    if (size == 0 || rear == -1)
      throw new IllegalStateException();
    else
        return queue[rear];
  }
}
