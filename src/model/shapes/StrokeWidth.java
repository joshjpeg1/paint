package model.shapes;

/**
 * Created by josh_jpeg on 10/19/17.
 */
public enum StrokeWidth {
  ONE(1), TWO(2), FIVE(5), TEN(10);

  private int width;

  StrokeWidth(int width) {
    this.width = width;
  }

  public int getWidth() {
    return this.width;
  }
}
