package model.shapes;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public class Rectangle extends AShape {
  private int width;
  private int height;

  protected Rectangle(int startX, int startY, int endX, int endY) {
    super(Math.min(startX, endX), Math.min(startY, endY));
    this.type = ShapeType.RECT;
    this.width = Math.abs(startX - endX);
    this.height = Math.abs(startY - endY);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (!(o instanceof Rectangle)) {
      return false;
    }
    Rectangle other = (Rectangle) o;
    return this.startX == other.startX
      && this.startY == other.startY
      && this.width == other.width
      && this.height == other.height;
  }

  @Override
  public String toString() {
    return "[RECT, (" + this.startX + ", " + this.startY + "), w: " + this.width + ", h: "
      + this.height + "]";
  }

  public static AShape getCopy(Rectangle other) {
    return new Rectangle(other.startX, other.startY,
      other.startX + other.width, other.startY + other.height);
  }
}
