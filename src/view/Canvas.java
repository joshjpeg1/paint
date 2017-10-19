package view;

import model.PaintModel;
import model.shapes.AShape;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * Created by josh_jpeg on 10/14/17.
 */
public class Canvas extends JPanel {
  private Random random = new Random();
  private static PaintModel model;
  public Canvas(PaintModel model, MouseAdapter controller) {
    this.setMinimumSize(new Dimension(PaintView.WIDTH, PaintView.HEIGHT));
    this.setVisible(true);
    this.addMouseListener(controller);
    this.addMouseMotionListener(controller);
    this.model = model;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.white);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    Stack<AShape> shapes = model.getCanvas();
    ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.red, Color.orange,
      Color.yellow, Color.green, Color.blue, Color.magenta));
    for (AShape s : shapes) {
      g.setColor(colors.get(random.nextInt(colors.size())));
      //g.setColor(Color.black);
      s.paint(g);
    }
  }
}
