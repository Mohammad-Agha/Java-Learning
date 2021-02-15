import java.util.ArrayList;

import customlib.BinaryTree;

public class Driver {
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.insert(11);
    tree.insert(5);
    tree.insert(12);
    tree.insert(4);
    tree.insert(6);
    tree.insert(10);

    tree.printPostOrder();
  }
}