package model.shapes;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public class Curve extends Line {
  private int degree;

  protected Curve(int startX, int startY, int endX, int endY, int degree) {
    super(startX, startY, endX, endY);
    this.type = ShapeType.CURVE;
    this.degree = degree;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (!(o instanceof Curve)) {
      return false;
    }
    Curve other = (Curve) o;
    return this.startX == other.startX
      && this.startY == other.startY
      && this.endX == other.endX
      && this.endY == other.endY
      && this.degree == other.degree;
  }

  @Override
  public String toString() {
    return "[CURVE, (" + this.startX + ", " + this.startY + "), (" + this.endX + ", " + this.endY
      + "), d: " + this.degree + "°]";
  }

  public static AShape getCopy(Curve other) {
    return new Curve(other.startX, other.startY, other.endX, other.endY, other.degree);
  }
}
