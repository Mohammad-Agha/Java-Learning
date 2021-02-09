package design_patterns.factory;

public class ShapeFactory {
  public Shape getShape(String type) {
    if (type == null)
      return null;
    else if (type.equals("Circle"))
      return new Circle();
    else if (type.equals("Rectangle"))
      return new Rectangle();
    else if (type.equals("Square"))
      return new Square();
    return null;
  }
}
