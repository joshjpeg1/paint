package shapes;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public class Rectangle extends AShape {
  public Rectangle(int startX, int startY) {
    super(startX, startY);
    this.type = ShapeType.RECT;
  }
}
