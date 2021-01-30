import customlib.MVector;

public class Driver
{
  public static void main(String[] args)
  {
    MVector array = new MVector();
    for(int i = 0; i < 40; i++)
    {
      array.add(i + 1);
    }
    int value = array.remove();
    System.out.println(value);
    array.print();
  }
}