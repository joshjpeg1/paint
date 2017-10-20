package view;

import model.PaintModel;
import model.shapes.AShape;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.Stack;

/**
 * Created by josh_jpeg on 10/14/17.
 */
public class Canvas extends JPanel {
  private PaintModel model;

  protected Canvas(PaintModel model, MouseAdapter controller) {
    this.setMinimumSize(new Dimension(PaintView.WIDTH, PaintView.HEIGHT));
    this.setVisible(true);
    this.addMouseListener(controller);
    this.addMouseMotionListener(controller);
    this.model = model;
  }

  @Override
  protected void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    Graphics2D g = (Graphics2D) graphics;
    g.setColor(Color.white);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    Stack<AShape> shapes = model.getCanvas();
    for (AShape s : shapes) {
      s.paint(g);
    }
  }
}
