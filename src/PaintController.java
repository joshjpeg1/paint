import model.PaintModel;
import model.shapes.ShapeType;
import view.PaintView;

/**
 * Created by josh_jpeg on 10/14/17.
 */
public class PaintController {
  private static PaintModel model;
  private static PaintView view;
  private static PaintController controller;

  /**
   * Constructor for controller, using the singleton pattern.
   */
  private PaintController() {
    this.model = PaintModel.initialize();
    this.view = new PaintView(this.model);
    this.controller = null;
  }

  /**
   * initializer for singleton pattern for controller. Only one will ever be created.
   * @return this's controller
   */
  public static PaintController initialize() {
    if (controller == null) {
      controller = new PaintController();
    }
    return controller;
  }

  public void start() {
    this.model.addShape(ShapeType.RECT, 5, 8, 15, 21);
    this.model.addShape(ShapeType.RECT, 15, 21, 5, 8);
    this.model.addShape(ShapeType.ELLIPSE, 5, 8, 15, 21);
    this.model.addShape(ShapeType.LINE, 5, 8, 15, 21);
    this.model.addShape(ShapeType.CURVE, 5, 8, 15, 21);
    this.model.printCanvas();
  }
}
