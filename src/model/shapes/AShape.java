package model.shapes;

import java.awt.*;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public abstract class AShape {
  protected ShapeType type;
  protected StrokeWidth strokeWidth;
  protected ShapeColor shapeColor;
  protected int startX;
  protected int startY;

  protected AShape(StrokeWidth strokeWidth, ShapeColor shapeColor, int startX, int startY) {
    this.strokeWidth = strokeWidth;
    this.shapeColor = shapeColor;
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

  public static AShape getCopy(AShape other) {
    if (other == null) {
      throw new IllegalArgumentException("Cannot copy a null shape.");
    }
    switch (other.type) {
      case RECT:
        return Rectangle.getCopy((Rectangle) other);
      case ELLIPSE:
        return Ellipse.getCopy((Ellipse) other);
      case LINE:
        return Line.getCopy((Line) other);
      case CURVE:
        return Curve.getCopy((Curve) other);
      default:
        throw new IllegalArgumentException("Shape type does not exist.");
    }
  }

  public void paint(Graphics2D g) {
    return;
  }
}
