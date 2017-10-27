import junit.framework.TestCase;
import java.util.*;

public class LLTester extends TestCase {


  
   public void testRemove() {
    LL<String> list = new LL<String>();

    list.add("tim", 0);
    list.add("john", 1);
    list.add("tj", 2);
    list.add("aya", 3);
    list.add("jazz", 4);
    list.add("mae", 5);
    assertEquals(true, list.remove(1));
    assertEquals(true, list.remove(2));
    assertEquals(true, list.remove(3));
    assertEquals(true, list.remove(0));
  }
   
  public void testAdd() {
    LL<String> list = new LL<String>();
    assertEquals(true, list.add("tim", 0));
    assertEquals(true, list.add("john", 1));
    assertEquals(true, list.add("tj", 2));
    assertEquals(true, list.add("aya", 3));
    assertEquals(true, list.add("jazz", 4));
    assertEquals(true, list.add("mae", 5));
  }

  
  public void testNext() {
    LL<String> list = new LL<String>();

    list.add("tim", 0);
    list.add("john", 1);
    list.add("tj", 2);
    list.add("aya", 3);
    list.add("jazz", 4);
    list.add("mae", 5);
    Iterator iterate = list.iterator();

    while(iterate.hasNext())
      System.out.println(iterate.next() + " ");
  }

  public void testHasNext() {
    LL<String> list = new LL<String>();

    list.add("tim", 0);
    list.add("john", 1);
    list.add("tj", 2);
    list.add("aya", 3);
    list.add("jazz", 4);
    list.add("mae", 5);

    Iterator iterate = list.iterator();

    assertEquals(true, iterate.hasNext());
  }

  
}
