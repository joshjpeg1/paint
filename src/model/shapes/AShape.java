package model.shapes;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (!(o instanceof AShape)) {
      return false;
    }
    AShape other = (AShape) o;
    return this.startX == other.startX
      && this.startY == other.startY;
  }

  public int getStartX() {
    return this.startX;
  }

  public int getStartY() {
    return this.startY;
  }

  public static AShape getCopy(AShape other) {
    if (other == null) {
      throw new IllegalArgumentException("Cannot copy a null shape.");
    }
    switch (other.type) {
      case RECT:
        Rectangle.getCopy((Rectangle) other);
      case ELLIPSE:
        Ellipse.getCopy((Ellipse) other);
      case LINE:
        Line.getCopy((Line) other);
      case CURVE:
        Curve.getCopy((Curve) other);
      default:
        throw new IllegalArgumentException("Shape type does not exist.");
    }
  }
}
