import java.util.NoSuchElementException;

public class LL<E> implements Collection<E> {
  public class Node {
    E data;
    Node next;

    Node(E data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  Node head = null;
  int size = 0;

  LL() {}
  
  public Iterator<E> iterator() {
    return new LinkedListIterator();
  }

  class LinkedListIterator implements Iterator<E> {
    Node cur = head;

    public boolean hasNext() {
      return (cur != null);
    }

    public E next() {
      if(!(hasNext()))
        throw new NoSuchElementException();

      E item = cur.data;
      cur = cur.next;
      return item;
    }
  }
  
   public E remove(int index) {
    if(this.size == 0) {
      throw new NoSuchElementException("Error!");
    }
    
    Node cur = this.head;
    Node prev = null;
    
    if(index == 0){
      prev = cur;
      cur = cur.next;
      prev.next = null;
      }
    
    for(int i = 0; i < index; i++) {
      prev = cur;
      cur = cur.next;
      if(cur == null) {
        break;
      } 
    }
    E item = cur.data;
    prev.next = cur.next;
    cur.next = null;
    this.size--;
     
    return item;
  }
  
  public boolean add(E item, int index) {
    Node new_node = new Node(item, head);

    if (this.size == 0 || index == 0) {
      this.head = new_node;
      this.size++;
      return true;
    }

    Node cur = this.head;
    Node prev = null;

    for(int i = 0; i < index; i++) {
      prev = cur;
      cur = cur.next;
      if(cur == null) {
        break;
      }
    }

    new_node.next = cur;
    prev.next = new_node;
    size++;
    return true;
  }


  public int size() {
    return this.size;
  }
  
  public E getData(int index) {
    Node cur = this.head;
    for(int i = 0; i < index; i++) {
      cur = cur.next;
      if(cur == null) {
        break;
      } 
    }
    E item = cur.data;
    return item;
  }
  
  public void display() {
    Node cur = this.head;
    int ctr = 0;
    while(cur != null){
      System.out.println("stack" + ctr + ": " + cur.data);
      cur = cur.next;
      ctr++;
    }
  }

  
}
