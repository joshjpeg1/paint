import shapes.AShape;
import shapes.AShapeFactory;
import shapes.ShapeType;

import java.util.Stack;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public class PaintModel {
  private Stack<AShape> shapes;

  private PaintModel() {
    shapes = new Stack<>();
  }

  public void addShape(ShapeType type, int startX, int startY, int endX, int endY) {

  }

  public void addShape(AShape shape) {
    shapes.push(shape);
  }

  public void clearCanvas() {
    shapes.empty();
  }
}
