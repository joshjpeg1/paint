package model;

import model.shapes.*;

import java.awt.*;
import java.util.Stack;

/**
 * Created by josh_jpeg on 10/10/17.
 */
public class PaintModel {
  private static PaintModel model;
  private ModelAction lastAction;

  private Stack<AShape> shapes;
  private Stack<AShape> removedShapes;
  private AShapeFactory factory;

  private Point tempStart;
  private Point tempEnd;
  private ShapeType shapeType;
  private StrokeWidth strokeWidth;
  private ShapeColor shapeColor;

  private PaintModel() {
    this.lastAction = null;
    this.shapes = new Stack<>();
    this.removedShapes = new Stack<>();
    this.factory = new AShapeFactory();

    this.tempStart = null;
    this.tempEnd = null;
    this.shapeType = ShapeType.LINE;
    this.strokeWidth = StrokeWidth.ONE;
    this.shapeColor = ShapeColor.RED;
  }

  /**
   * initializer for singleton pattern for model. Only one will ever be created.
   * @return this's model
   */
  public static PaintModel initialize() {
    if (model == null) {
      model = new PaintModel();
    }
    return model;
  }

  public void setShapeType(ShapeType shapeType) {
    this.shapeType = shapeType;
  }

  public void setStrokeWidth(StrokeWidth strokeWidth) {
    this.strokeWidth = strokeWidth;
    System.out.println(this.strokeWidth);
  }

  public void setShapeColor(ShapeColor shapeColor) {
    this.shapeColor = shapeColor;
    System.out.println(this.shapeColor);
  }

  public void startDraw(Point mouseStart) {
    this.tempStart = mouseStart;
    this.tempEnd = mouseStart;
    this.removedShapes.clear();
    this.lastAction = ModelAction.DRAW;
  }

  public void updateEndPoint(Point mouseEnd) {
    this.tempEnd = mouseEnd;
    this.lastAction = ModelAction.DRAW;
  }

  public void stopDraw(Point mouseEnd) {
    this.addShape(this.shapeType, this.strokeWidth, this.shapeColor, this.tempStart.x,
      this.tempStart.y, mouseEnd.x, mouseEnd.y);
    this.tempStart = null;
    this.tempEnd = null;
    this.lastAction = ModelAction.DRAW;
  }

  private void addShape(ShapeType type, StrokeWidth strokeWidth, ShapeColor shapeColor,
                        int startX, int startY, int endX, int endY) {
    this.shapes.push(this.factory.getShape(type, strokeWidth, shapeColor, startX, startY,
      endX, endY));
  }

  public Stack<AShape> getCanvas() {
    Stack<AShape> copy = new Stack<>();
    for (int i = 0; i < shapes.size(); i++) {
      copy.add(AShape.getCopy(shapes.get(i)));
    }
    if (this.tempStart != null && this.tempEnd != null) {
      copy.add(this.factory.getShape(this.shapeType, this.strokeWidth, this.shapeColor,
        this.tempStart.x, this.tempStart.y, this.tempEnd.x, this.tempEnd.y));
    }
    return copy;
  }

  public void clearCanvas() {
    this.removedShapes.clear();
    for (int i = 0; i < this.shapes.size(); i++) {
      this.removedShapes.push(this.shapes.get(i));
    }
    this.shapes.clear();
    this.lastAction = ModelAction.CLEAR;
  }

  public void undo() {
    if (this.shapes.size() > 0) {
      this.removedShapes.push(this.shapes.pop());
      this.lastAction = ModelAction.DRAW;
    } else if (this.removedShapes.size() > 0) {
      for (int i = 0; i < this.removedShapes.size(); i++) {
        this.shapes.push(this.removedShapes.get(i));
      }
      this.removedShapes.clear();
    }
  }

  public void redo() {
    if (this.lastAction == ModelAction.CLEAR) {
      clearCanvas();
    } else if (this.removedShapes.size() > 0) {
      this.shapes.push(this.removedShapes.pop());
    }
  }
}
