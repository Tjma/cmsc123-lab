import junit.framework.TestCase;

public class StackTest extends TestCase {
  
  
  public void testPush() {
    Stack stacked = new Stack();
    stacked.push("tim");
    stacked.push("aya");
    stacked.push("john");
    stacked.push("alva");
    stacked.push("rez");
    stacked.push("malic");
  }
}