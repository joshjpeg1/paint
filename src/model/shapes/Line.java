package model.shapes;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public class Line extends AShape {
  protected int endX;
  protected int endY;

  protected Line(StrokeWidth strokeWidth, ShapeColor shapeColor, int startX, int startY,
                 int endX, int endY) {
    super(strokeWidth, shapeColor, startX, startY);
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

  public static AShape getCopy(Line other) {
    return new Line(other.strokeWidth, other.shapeColor, other.startX, other.startY,
      other.endX, other.endY);
  }

  @Override
  public void paint(Graphics2D g) {
    g.setColor(this.shapeColor.getColor());
    g.fill(new BasicStroke(this.strokeWidth.getWidth(),
      BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)
      .createStrokedShape(new Line2D.Float(startX, startY, endX, endY)));
  }
}
