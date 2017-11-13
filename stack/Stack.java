import java.util.EmptyStackException;

class Stack<E> {
  LL<E> ll;
  
  public Stack() {
    ll = new LL<>();
  }
  
  public void push(E item) {
    int index = ll.size();
    ll.add(item, index);
  }
  
   public E peek() {
    if(isEmpty()) {
      throw new EmptyStackException();
    }
    int index = ll.size() - 1;
    return ll.getData(index);
  }
  
  public boolean isEmpty() {
    return (ll.size() == 0);
  }
  
  public int size() {
    return ll.size();
  }
  
  public void display() {
    ll.display();
  }
  
  public E pop() {
    int index = ll.size() - 1;
    return ll.remove(index);
  }
  
 
}