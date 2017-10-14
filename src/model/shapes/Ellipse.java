package model.shapes;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public class Ellipse extends AShape {
  private int width;
  private int height;

  protected Ellipse(int startX, int startY, int endX, int endY) {
    super(Math.min(startX, endX), Math.min(startY, endY));
    this.type = ShapeType.ELLIPSE;
    this.width = Math.abs(startX - endX);
    this.height = Math.abs(startY - endY);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (!(o instanceof Ellipse)) {
      return false;
    }
    Ellipse other = (Ellipse) o;
    return this.startX == other.startX
      && this.startY == other.startY
      && this.width == other.width
      && this.height == other.height;
  }

  @Override
  public String toString() {
    return "[ELLIPSE, (" + this.startX + ", " + this.startY + "), w: " + this.width + ", h: "
      + this.height + "]";
  }

  public static AShape getCopy(Ellipse other) {
    return new Ellipse(other.startX, other.startY,
      other.startX + other.width, other.startY + other.height);
  }
}
