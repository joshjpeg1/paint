package model;

import model.shapes.AShape;
import model.shapes.AShapeFactory;
import model.shapes.LineThickness;
import model.shapes.ShapeType;

import java.awt.*;
import java.util.Stack;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public class PaintModel {
  private Stack<AShape> shapes;
  private AShapeFactory factory;
  private static PaintModel model;
  private Point tempStart = null;
  private Point tempEnd = null;
  private ShapeType shapeType = ShapeType.LINE;
  private LineThickness lineThickness = LineThickness.ONE;

  private PaintModel() {
    this.shapes = new Stack<>();
    this.factory = new AShapeFactory();
  }

  /**
   * initializer for singleton pattern for controller. Only one will ever be created.
   * @return this's controller
   */
  public static PaintModel initialize() {
    if (model == null) {
      model = new PaintModel();
    }
    return model;
  }

  public void addShape(ShapeType type, int startX, int startY, int endX, int endY) {
    this.shapes.push(this.factory.getShape(type, startX, startY, endX, endY));
  }

  public Stack<AShape> getCanvas() {
    Stack<AShape> copy = new Stack<>();
    for (int i = 0; i < shapes.size(); i++) {
      copy.add(AShape.getCopy(shapes.get(i)));
    }
    if (this.tempStart != null && this.tempEnd != null) {
      copy.add(this.factory.getShape(this.shapeType, this.tempStart.x, this.tempStart.y,
        this.tempEnd.x, this.tempEnd.y));
    }
    return copy;
  }

  public void printCanvas() {
    for (int i = 0; i < shapes.size(); i++) {
      System.out.println(shapes.get(i).toString());
    }
  }

  public void startDraw(Point mouseStart) {
    this.tempStart = mouseStart;
    this.tempEnd = mouseStart;
  }

  public void updateEndPoint(Point mouseEnd) {
    this.tempEnd = mouseEnd;
  }

  public void stopDraw(Point mouseEnd) {
    this.addShape(this.shapeType, this.tempStart.x, this.tempStart.y, mouseEnd.x, mouseEnd.y);
    this.tempStart = null;
    this.tempEnd = null;
  }

  public void clearCanvas() {
    this.shapes.clear();
  }
}
