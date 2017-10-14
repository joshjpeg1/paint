package model.shapes;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public class Line extends AShape {
  protected int endX;
  protected int endY;

  protected Line(int startX, int startY, int endX, int endY) {
    super(startX, startY);
    this.type = ShapeType.LINE;
    this.endX = endX;
    this.endY = endY;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (!(o instanceof Line)) {
      return false;
    }
    Line other = (Line) o;
    return this.startX == other.startX
      && this.startY == other.startY
      && this.endX == other.endX
      && this.endY == other.endY;
  }

  @Override
  public String toString() {
    return "[LINE, (" + this.startX + ", " + this.startY + "), (" + this.endX + ", " + this.endY
      + ")]";
  }

  public static AShape getCopy(Line other) {
    return new Line(other.startX, other.startY, other.endX, other.endY);
  }
}