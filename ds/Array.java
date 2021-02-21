package ds;

public class Array implements List {
  private int size;
  private int capacity;
  private int[] arr;

  /**
   * Initializes an empty array with capacity 16
   */
  public Array() {
    this.size = 0;
    this.capacity = 16;
    this.arr = new int[this.capacity];
  }

  /**
   * Returns the size of the array
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Returns the capacity of the array
   */
  public int getCapacity() {
    return this.capacity;
  }

  /**
   * Adds an element to the array
   */
  public void add(int value) {
    System.out.println("jere");
    this.grow();
    this.arr[this.size] = value;
    this.size++;
  }

  /**
   * Adds the elements to the array
   */
  public void addAll(int... values) {
    for (Integer i : values) {
      this.add(i);
    }
  }

  /**
   * Adds an element at a certain index to the array
   */
  public void add(int index, int value) {
    if (index < 0 || index > this.size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    this.grow();
    for (int i = this.size; i > index; i--) {
      this.arr[i] = this.arr[i - 1];
    }
    this.arr[index] = value;
    this.size++;
  }

  /**
   * Returns the value at a certain index
   */
  public int getValueAt(int index) {
    if (index < 0 || index >= this.size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return this.arr[index];
  }

  /**
   * Returns the index at a certain value
   */
  public int getIndexOf(int value) {
    for (int i = 0; i < this.size; i++) {
      if (this.arr[i] == value) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Updated the value at a certain index
   */
  public void update(int index, int value) {
    if (index < 0 || index >= this.size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    this.arr[index] = value;
  }

  /**
   * Removes the value at a certain index
   */
  public void removeIndex(int index) {
    if (index < 0 || index >= this.size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    this.shrink();
    for (int i = index; i < this.size - 1; i++) {
      this.arr[i] = this.arr[i + 1];
    }
    this.size--;
  }

  /**
   * Removes the first occurrence of a value
   */
  public boolean removeValue(int value) {
    for (int i = 0; i < this.size; i++) {
      if (this.arr[i] == value) {
        this.removeIndex(i);
        return true;
      }
    }
    return false;
  }

  /**
   * Reverses the array
   */
  public void reverse() {
    int i = 0;
    int j = this.size - 1;
    while (i < j) {
      int temp = this.arr[i];
      this.arr[i] = this.arr[j];
      this.arr[j] = temp;
      i++;
      j--;
    }
  }

  public String toString() {
    String s = "[";
    for (int i = 0; i < this.size; i++) {
      s += this.arr[i] + ", ";
    }
    if (s != "[") {
      s = s.substring(0, s.length() - 2);
    }
    s += "]";
    return s;
  }

  private void grow() {
    if (this.size == this.capacity) {
      this.capacity *= 2;
      int[] newArray = new int[this.capacity];
      for (int i = 0; i < this.size; i++) {
        newArray[i] = this.arr[i];
      }
      this.arr = newArray;
    }
  }

  private void shrink() {
    if (this.size == this.capacity / 4) {
      this.capacity /= 2;
      int[] newArray = new int[this.capacity];
      for (int i = 0; i < this.size; i++) {
        newArray[i] = this.arr[i];
      }
      this.arr = newArray;
    }
  }
}
