package model.shapes;

import java.awt.*;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public class Curve extends AShape {
  private int width;
  private int height;
  private int degree;

  protected Curve(int startX, int startY, int endX, int endY) {
    super(Math.min(startX, endX), Math.min(startY, endY));
    this.type = ShapeType.CURVE;
    this.width = Math.abs(startX - endX);
    this.height = Math.abs(startY - endY);
    this.degree = 0;
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
      && this.width == other.width
      && this.height == other.height
      && this.degree == other.degree;
  }

  @Override
  public String toString() {
    return "[CURVE, (" + this.startX + ", " + this.startY + "), " + this.width + ", " + this.height
      + ", d: " + this.degree + "°]";
  }

  public static AShape getCopy(Curve other) {
    return new Curve(other.startX, other.startY, other.startX + other.width,
      other.startY + other.height);
  }

  @Override
  public void paint(Graphics g) {
    g.drawArc(startX, startY, width, height, 20, 20);
  }
}
