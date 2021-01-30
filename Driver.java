import customlib.MVector;

public class Driver {
  static int i;

  static int f() {
    i = 2;
    return i + 1;
  }

  static int g() {
    i = 4;
    f();
    int j = i;
    return j + f();
  }

  public static void main(String[] args) {
    System.out.println(g());
    // MVector array = new MVector();
    // for (int i = 0; i < 8; i++) {
    // array.add(i);
    // }
    // array.print();
  }
}
