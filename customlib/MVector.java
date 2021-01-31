package customlib;

public class MVector {
  private int size;
  private int capacity;
  private int arr[];

  /**
   * Default constructor Initializes the array with capacity of 16
   */
  public MVector() {
    this.size = 0;
    this.capacity = 16;
    this.arr = new int[this.capacity];
  }

  /**
   * Returns the size of the array
   * 
   * @return int: size of the array
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Returns the capacity of the array
   * 
   * @return int: capacity of the array
   */
  public int getCapacity() {
    return this.capacity;
  }

  /**
   * Prints the array elements. Outputs "Array is empty" in case the array is
   * empty
   * 
   * @return Nothing
   */
  public void print() {
    if (this.size == 0) {
      System.out.println("Array is empty");
      return;
    }
    for (int i = 0; i < this.size; i++) {
      System.out.print(this.arr[i] + " ");
    }
    System.out.println();
  }

  /**
   * Adds an element to the array
   * 
   * @param value int: The value that needs to be inserted
   * @return Nothing
   */
  public void add(int value) {
    if (this.size == this.capacity) {
      this.grow();
    }
    this.arr[this.size] = value;
    this.size++;
  }

  /**
   * Adds an element to the array at the specified index
   * 
   * @param value int: The value that needs to be inserted
   * @param index int: The index where the value will be inserted
   * @return Nothing
   * @exception ArrayIndexOutOfBoundsException if the index is out of array's
   *                                           range
   * @see ArrayIndexOutOfBoundsException
   */
  public void add(int value, int index) {
    if (index < 0 || index > this.size) {
      throw new ArrayIndexOutOfBoundsException("Index out of bounds");
    }
    if (this.size == this.capacity) {
      this.grow();
    }
    for (int i = this.size; i > index; i--) {
      this.arr[i] = this.arr[i - 1];
    }
    this.arr[index] = value;
    this.size++;
  }

  /**
   * Removes the last element in the array
   * 
   * @return int: The last element in the array
   * @exception ArrayIndexOutOfBoundsException If the array is empty
   * @see ArrayIndexOutOfBoundsException
   */
  public int remove() {
    if (this.size == 0) {
      throw new ArrayIndexOutOfBoundsException("The array is already empty");
    }
    if (this.capacity / 4 == this.size) {
      this.shrink();
    }
    this.size--;
    return this.arr[this.size];
  }

  /**
   * Removes an element as the specified index
   * 
   * @param index int: The index to be removed
   * @return int: The element at the specified index
   * @exception ArrayIndexOutOfBoundsException If the index is out of array's
   *                                           range
   * @see ArrayIndexOutOfBoundsException
   */
  public int remove(int index) {
    if (index < 0 || index >= this.size) {
      throw new ArrayIndexOutOfBoundsException("Index out of bounds");
    }
    if (this.capacity / 4 == this.size) {
      this.shrink();
    }
    int value = this.arr[index];
    for (int i = index; i < this.size - 1; i++) {
      this.arr[i] = this.arr[i + 1];
    }
    this.size--;
    return value;
  }

  /**
   * Reverses the array elements
   * 
   * @return Nothing
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

  // Increases the capacity of the array when needed
  private void grow() {
    this.capacity *= 2;
    this.moveArrayContent();
  }

  // Decrease the capacity of the array when needed
  private void shrink() {
    this.capacity /= 2;
    this.moveArrayContent();
  }

  // Moves the old array elements to the new array with new capacity
  private void moveArrayContent() {
    int newArray[] = new int[this.capacity];
    for (int i = 0; i < this.size; i++) {
      newArray[i] = this.arr[i];
    }
    this.arr = newArray;
  }
}
