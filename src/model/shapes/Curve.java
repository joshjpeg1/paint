package model.shapes;

import java.awt.*;
import java.awt.geom.Arc2D;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public class Curve extends AShape {
  private int width;
  private int height;
  private int startAngle;
  private int arcAngle;

  protected Curve(StrokeWidth strokeWidth, ShapeColor shapeColor, int startX, int startY,
                  int endX, int endY) {
    super(strokeWidth, shapeColor, Math.min(startX, endX), Math.min(startY, endY));
    this.type = ShapeType.CURVE;
    this.width = Math.abs(startX - endX);
    this.height = Math.abs(startY - endY);
    this.startAngle = (endX < startX) ? 180 : 90;
    System.out.println(endY + ", " + startY);
    this.arcAngle = ((endY < startY) ? -1 : 1) * 90;
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
      && this.startAngle == other.startAngle
      && this.arcAngle == other.arcAngle;
  }

  public static AShape getCopy(Curve other) {
    return new Curve(other.strokeWidth, other.shapeColor,
      other.startX + ((other.startAngle > 90) ? other.width : 0),
      other.startY + ((other.arcAngle < 0) ? other.height : 0),
      other.startX + ((other.startAngle > 90) ? 0 : other.width),
      other.startY + ((other.arcAngle < 0) ? 0 : other.height));
  }

  @Override
  public void paint(Graphics2D g) {
    g.setColor(this.shapeColor.getColor());
    g.fill(new BasicStroke(this.strokeWidth.getWidth())
      .createStrokedShape(new Arc2D.Float(startX, startY, width, height, startAngle, arcAngle, 0)));
  }
}
