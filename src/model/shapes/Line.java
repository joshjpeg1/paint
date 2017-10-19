package model.shapes;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public class Line extends AShape {
  protected int endX;
  protected int endY;

  protected Line(LineThickness lineThickness, int startX, int startY, int endX, int endY) {
    super(lineThickness, startX, startY);
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
    return new Line(other.lineThickness, other.startX, other.startY, other.endX, other.endY);
  }

  @Override
  public void paint(Graphics2D g) {
    g.draw(new BasicStroke(this.lineThickness.getWidth(),
      BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)
      .createStrokedShape(new Line2D.Float(startX, startY, endX, endY)));
  }
}
