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
  
  public boolean remove(int index) {

    if(this.size == 0)
      return false;
    
    

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
     prev.next = cur.next;
     cur.next = null;
     System.out.println(size+"-");
     this.size--;
     System.out.println(size);
     return true;
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

  
}
