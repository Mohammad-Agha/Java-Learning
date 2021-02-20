package customlib;

public class MList<T> {
  private Node<T> head;
  private Node<T> tail;

  public MList() {
    this.head = null;
    this.tail = null;
  }

  public void add(T data) {
    Node<T> newNode = new Node<>(data);
    if (this.tail == null) {
      this.head = newNode;
      this.tail = newNode;
      return;
    }
    this.tail.next = newNode;
    this.tail = newNode;
  }

  public void print() {
    Node<T> current = this.head;
    String out = "[";
    while (current != null) {
      out += current.data + ", ";
      current = current.next;
    }
    if (out != "[") {
      out = out.substring(0, out.length() - 2);
    }
    out += "]";
    System.out.println(out);
  }

  private class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
      this.data = data;
      this.next = null;
    }
  }
}
