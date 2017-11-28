import java.util.*;

class HashTable {
  class HNode {
    String key;
    int value;
    HNode next;
  
    HNode(String key, int value) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }
  
  int max; 
  int size; 
  HNode[] hash_table; 

  
  HashTable() {
    max = 100;
    hash_table = new HNode[max];
    
    
    for (int i = 0; i < max; i++)
      hash_table[i] = null;
  }

   public List values() {
    List valueS = new ArrayList();
    for (int i = 0; i < max; i++) {
      HNode new_node = hash_table[i];
      while (new_node != null) {
        valueS.add(new_node.value);
        new_node = new_node.next;
      } 
    }
    return valueS;
  }

   public List keys() {
    List keY = new ArrayList();
    for (int i = 0; i < max; i++) {
      HNode new_node = hash_table[i];
      while (new_node != null) {
        keY.add(new_node.key);
        new_node = new_node.next;
      } 
    }
    return keY;
  }

  public boolean contains(String key) {
    int hash = (getHash(key) % max);
    
    if(hash_table[hash] == null) {
      return false;
    }
    HNode new_node = hash_table[hash];
    while(new_node.next != null && new_node.key != key) {
      new_node.next = new_node;
    }
    if(new_node.key == null) {
      return false;
    }
    return true;
  }
  
  
  public void put(String key, int value) {
    int hash = (getHash(key) % max);
    
    if(hash_table[hash] == null) {
      hash_table[hash] = new HNode(key, value);
    }
    else {
      HNode new_node = hash_table[hash];
      while(new_node.next != null && new_node.key != key) {
        new_node = new_node.next;
      }
      if(new_node.key == key) {
        new_node.value = value;
      }
      else {
        new_node.next = new HNode(key, value);
      }
    }
    size++;
  }
  
  
  public int get(String key) {
    int hash = (getHash(key) % max);
    
    if(hash_table[hash] == null) {
      return -1;
    }
    
    HNode new_node = hash_table[hash];
    while(new_node.next != null && new_node.key != key) {
      new_node = new_node.next;
    }
    if(new_node.key == null) {
      return -1;
    }
    return new_node.value;
  }
  
  
  public int remove(String key) {
    int hash = (getHash(key) % max);
    
    if(hash_table[hash] == null) {
      return -1;
    }
    
    HNode prev = null;
    HNode new_node = hash_table[hash];
      
    while(new_node.next != null && new_node.key != key) {
      prev = new_node;
      new_node.next = new_node;
    }
    if(new_node.key == null) {
      return -1;
    }
    
    if(prev == null)
      hash_table[hash] = new_node.next;
    else
      prev.next = new_node.next;
    
    size--;
    return new_node.value;
  }
  
  
  
  
  
 
  
  
 


   public void display() {
    for (int i = 0; i < max; i++) {
      System.out.println("\nhash index"+ (i + 1) +" : ");
      HNode new_node = hash_table[i];
      while (new_node != null) {
        System.out.print(new_node.value +" ");
        new_node = new_node.next;
      } 
    }
  }
  
  
  public int getHash(String key) {
    int hash_Code = key.hash_Code();
    int hash_Value = hash_Code % max;
    return hash_Value;
  }
  
 
}