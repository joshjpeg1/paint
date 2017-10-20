package model.shapes;

import java.awt.*;

/**
 * Created by josh_jpeg on 10/19/17.
 */
public enum ShapeColor {
  RED(Color.red), ORANGE(Color.orange), YELLOW(Color.yellow), GREEN(Color.green),
  BLUE(Color.blue), PURPLE(Color.magenta);

  private Color color;

  ShapeColor(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return this.color;
  }
}
