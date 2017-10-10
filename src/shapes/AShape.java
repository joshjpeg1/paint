package shapes;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public abstract class AShape {
  protected ShapeType type;
  protected int startX;
  protected int startY;

  protected AShape(int startX, int startY) {
    this.startX = startX;
    this.startY = startY;
  }
}
