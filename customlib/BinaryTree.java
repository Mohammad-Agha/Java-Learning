package customlib;

public class BinaryTree {
  private Node root;

  public BinaryTree() {
    this.root = null;
  }

  public void insert(int data) {
    this.root = this.insert(this.root, data);
  }

  private Node insert(Node root, int data) {
    if (root == null) {
      root = new Node(data);
      return root;
    }
    if (data < root.data) {
      root.left = insert(root.left, data);
    } else {
      root.right = insert(root.right, data);
    }
    return root;
  }

  public void delete(int data) {
    this.root = delete(this.root, data);
  }

  private Node delete(Node root, int data) {
    if (root == null)
      return root;
    if (data < root.data) {
      root.left = delete(root.left, data);
    } else if (data > root.data) {
      root.right = delete(root.right, data);
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }
      root.data = min(root.right);
      root.right = delete(root.right, root.data);
    }
    return root;
  }

  private int min(Node root) {
    int minVal = root.data;
    while (root.left != null) {
      minVal = root.data;
      root = root.left;
    }
    return minVal;
  }

  public void printPreOrder() {
    this.printPreOrder(this.root);
    System.out.println();
  }

  private void printPreOrder(Node root) {
    if (root == null)
      return;
    System.out.print(root.data + " ");
    printPreOrder(root.left);
    printPreOrder(root.right);
  }

  public void printInOrder() {
    this.printInOrder(this.root);
    System.out.println();
  }

  private void printInOrder(Node root) {
    if (root == null)
      return;
    printInOrder(root.left);
    System.out.print(root.data + " ");
    printInOrder(root.right);
  }

  public void printPostOrder() {
    this.printPostOrder(this.root);
    System.out.println();
  }

  private void printPostOrder(Node root) {
    if (root == null)
      return;
    printPostOrder(root.left);
    printPostOrder(root.right);
    System.out.print(root.data + " ");
  }

  class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
}