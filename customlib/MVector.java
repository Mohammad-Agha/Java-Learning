package customlib;

public class MVector
{
  private int size;
  private int capacity;
  private int arr[];

  // Default Constructor
  public MVector()
  {
    this.size = 0;
    this.capacity = 16;
    this.arr = new int[this.capacity];
  }

  // Get the size of the array
  public int getSize()
  {
    return this.size;
  }

  // Get the capacity of the array
  public int getCapacity()
  {
    return this.capacity;
  }

  // Prints the array elements
  public void print()
  {
    for(int i = 0; i < this.size; i++)
    {
      System.out.print(this.arr[i] + " ");
    }
    System.out.println();
  }

  // Adds an element at the end of the array
  public void add(int value)
  {
    if(this.size == this.capacity)
    {
      this.grow();
    }
    this.arr[this.size] = value;
    this.size++;
  }

  // Remove and return the last value in the array
  public int remove()
  {
    if(this.size == 0)
    {
      throw new ArrayIndexOutOfBoundsException("The array is already empty");
    }
    if(this.capacity / 4 == this.size)
    {
      this.shrink();
    }
    this.size--;
    return this.arr[this.size];
  }

  // Increases the capacity of the array when needed
  private void grow()
  {
    this.capacity *= 2;
    this.moveArrayContent();
  }

  // Decrease the capacity of the array when needed
  private void shrink()
  {
    this.capacity /= 2;
    this.moveArrayContent();
  }

  // Moves the old array elements to the new array with new capacity
  private void moveArrayContent()
  {
    int newArray[] = new int[this.capacity];
    for(int i = 0; i < this.size; i++)
    {
      newArray[i] = this.arr[i];
    }
    this.arr = newArray;
  }
}
