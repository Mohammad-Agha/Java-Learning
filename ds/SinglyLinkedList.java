package ds;

public class SinglyLinkedList implements List {

  private Node head;
  private int size;

  public SinglyLinkedList() {
    this.head = null;
    this.size = 0;
  }

  public int getSize() {
    return this.size;
  }

  public void addAll(int... values) {
    for (Integer i : values) {
      this.add(i);
    }
  }

  public void add(int value) {
    if (this.head == null) {
      this.head = new Node(value);
      this.size++;
      return;
    }
    Node current = this.head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = new Node(value);
    this.size++;
  }

  public void add(int index, int value) {
    if (index < 0 || index > this.size) {
      throw new IndexOutOfBoundsException();
    }
    Node newNode = new Node(value);
    if (index == 0) {
      newNode.next = this.head;
      this.head = newNode;
      return;
    }
    Node current = this.head;
    for (int i = 0; i + 1 < index; i++) {
      current = current.next;
    }
    newNode.next = current.next;
    current.next = newNode;
    this.size++;
  }

  public int getValueAt(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException();
    }
    Node current = this.head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current.data;
  }

  public int getIndexOf(int value) {
    Node current = this.head;
    for (int i = 0; current != null; i++, current = current.next) {
      if (current.data == value) {
        return i;
      }
    }
    return -1;
  }

  public void update(int index, int value) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException();
    }
    Node current = this.head;
    for (int i = 0; i < index; i++, current = current.next)
      ;
    current.data = value;
  }

  public void removeIndex(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) {
      this.head = this.head.next;
      this.size--;
      return;
    }
    Node current = this.head;
    for (int i = 0; i + 1 < index; i++) {
      current = current.next;
    }
    current.next = current.next.next;
    this.size--;
  }

  public boolean removeValue(int value) {
    if (this.head == null) {
      return false;
    }
    if (this.head.data == value) {
      this.head = this.head.next;
      this.size--;
      return true;
    }
    Node current = this.head;
    while (current.next != null && current.next.data != value) {
      current = current.next;
    }
    if (current.next == null) {
      return false;
    }
    current.next = current.next.next;
    this.size--;
    return true;
  }

  public void reverse() {
    if (this.head == null) {
      return;
    }
    Node prev = null;
    Node current = this.head;
    Node next = current.next;
    while (current != null) {
      current.next = prev;
      prev = current;
      current = next;
      if (next != null) {
        next = next.next;
      }
    }
    this.head = prev;
  }

  public String toString() {
    String s = "[";
    Node current = this.head;
    while (current != null) {
      s += current.data + ", ";
      current = current.next;
    }
    if (s != "[") {
      s = s.substring(0, s.length() - 2);
    }
    s += "]";
    return s;
  }

  private class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

}
