import java.lang.IllegalArgumentException;

class Queue {
   int front;
   int rear;
   int limit;
   int size;
   String [] cQueue;


   class Queue{
   		this.size = 0
   		this.front = 0; //-1
   		this.rear = 0; //-1
   		this.limit = limit;
   		cQueue = new String[this.limit];


   }

   public void enqueue(String item) {
    if(isFull()) {
      expand();
    }
      array[rear] = item;
      rear = (rear + 1) % limit;
      size++;
  }

  public String dequeue() {
    String item;
    if(isEmpty()) {
      throw new IllegalArgumentException("Empty!");
    }
    item = array[front];
    array[front] = null;
    front = (front + 1) % this.limit;
    size--;
    
    return item;
  }

  public void expand() {
    this.limit = this.limit*2;
    String[] newCQueue = new String[this.limit];
    for(int a = 0; a < this.size; a++){
      newCQueue[a] = cQueue[front];
      front = (front + 1) % this.limit;
    }
    front = 0;
    rear = this.size;
    cQueue = newCQueue;
  }

   public boolean isFull() {
    return (size == limit);
  }
  
  public boolean isEmpty() {
    return (size == 0);
  }

  public String peek() {
    if(isEmpty()) {
      throw new IllegalArgumentException("Nothing to peek!");
    }
    return cQueue[front];
  }

  public int size() {
    return this.limit;
  }

  public void display() {
    int i = 0;
    while(i != rear) {
      System.out.println(array[i]);
      i = (i + 1) % this.limit;
    }
  }




}