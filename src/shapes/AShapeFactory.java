package shapes;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public class AShapeFactory {
  public AShape getShape(ShapeType type, int startX, int startY, int endX, int endY)
      throws IllegalArgumentException {
    if (type == null) {
      throw new IllegalArgumentException("Cannot have uninitialized shape type.");
    }
    switch (type) {
      case RECT:
        return new Rectangle();
      default:
        throw new IllegalArgumentException("Invalid ShapeType");
    }
  }
}
