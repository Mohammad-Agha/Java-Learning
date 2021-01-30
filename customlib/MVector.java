package customlib;

public class MVector {
  private int size;
  private int capacity;
  private int arr[];

  public MVector() {
    this.size = 0;
    this.capacity = 16;
    this.arr = new int[this.capacity];
  }

  public int getSize() {
    return this.size;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public void print() {
    for (int i = 0; i < this.size; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public void add(int value) {
    this.arr[this.size] = value;
    this.size++;
  }
}