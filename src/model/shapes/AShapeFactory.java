package model.shapes;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public class AShapeFactory {
  public AShape getShape(ShapeType type, StrokeWidth lineThickness, ShapeColor shapeColor,
                         int startX, int startY, int endX, int endY)
                         throws IllegalArgumentException {
    if (type == null) {
      throw new IllegalArgumentException("Cannot have uninitialized shape type.");
    }
    switch (type) {
      case RECT:
        return new Rectangle(lineThickness, shapeColor, startX, startY, endX, endY);
      case ELLIPSE:
        return new Ellipse(lineThickness, shapeColor, startX, startY, endX, endY);
      case LINE:
        return new Line(lineThickness, shapeColor, startX, startY, endX, endY);
      case CURVE:
        return new Curve(lineThickness, shapeColor, startX, startY, endX, endY);
      default:
        throw new IllegalArgumentException("Invalid ShapeType");
    }
  }
}
