package ds;

import java.util.ArrayList;

public class HashTable<K, V> {
  private ArrayList<HashNode<K, V>> arr;
  private int capacity;
  private int size;

  public HashTable() {
    this.arr = new ArrayList<>();
    this.capacity = 16;
    this.size = 0;
    for(int i = 0; i < this.capacity; i++) {
      this.arr.add(null);
    }
  }

  public int getSize() {
    return this.size;
  }
  public int getCapacity() {
    return this.capacity;
  }
  public boolean isEmpty() {
    return this.size == 0;
  }

  public void add(K key, V value) {
    int target = this.hash(key);
    HashNode<K, V> head = this.arr.get(target);
    while(head != null) {
      if(head.key.equals(key)) {
        head.value = value;
        return;
      }
      head = head.next;
    }
    HashNode<K, V> newNode = new HashNode<K, V>(key, value);
    newNode.next = this.arr.get(target);
    this.arr.set(target, newNode);
    this.size++;
    this.checkLoadFactor();
  }

  public boolean remove(K key) {
    int target = this.hash(key);
    HashNode<K, V> head = this.arr.get(target);
    HashNode<K, V> prev = null;
    while(head != null) {
      if(head.key.equals(key)) {
        break;
      }
      prev = head;
      head = head.next;
    }
    if(head == null) {
      return false;
    }
    this.size--;
    if(prev != null) {
      prev.next = head.next;
    }
    else {
      this.arr.set(target, head.next);
    }
    return true;
  }

  public V get(K key) {
    int target = this.hash(key);
    HashNode<K, V> head = this.arr.get(target);
    while(head != null) {
      if(head.key.equals(key)) {
        return head.value;
      }
      head = head.next;
    }
    return null;
  }

  public boolean exists(K key) {
    int target = this.hash(key);
    HashNode<K, V> head = this.arr.get(target);
    while(head != null) {
      if(head.key.equals(key)) {
        return true;
      }
      head = head.next;
    }
    return false;
  }

  public String toString() {
    if(this.arr.size() == 0) return "[]";
    String s = "";
    for(HashNode<K, V> node: this.arr) {
      if(node == null) continue;
      while(node != null) {
        s += "\'" + node.key + "\' : \'" + node.value + "\'";
        node = node.next;
        s += "\n";
      }
    }
    return s;
  }


  private int hash(K key) {
    return Math.abs(key.hashCode() % this.capacity);
  }

  private void checkLoadFactor() {
    if((this.size * 1.0) / this.capacity >= 0.7) {
      ArrayList<HashNode<K, V>> temp = this.arr;
      this.capacity *= 2;
      this.size = 0;
      this.arr = new ArrayList<>();
      for(int i = 0; i < this.capacity; i++) {
        this.arr.add(null);
      }
      for(HashNode<K, V> node: temp) {
        while(node != null) {
          this.add(node.key, node.value);
          node = node.next;
        }
      }
    }
  }

  private class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;
    public HashNode(K key, V value) {
      this.key = key;
      this.value = value;
      this.next = null;
    }
  }
}
