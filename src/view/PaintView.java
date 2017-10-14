package view;

import model.PaintModel;

import javax.swing.JFrame;
import java.awt.*;

/**
 * Created by josh_jpeg on 10/14/17.
 */
public class PaintView extends JFrame {
  protected static final int WIDTH = 500;
  protected static final int HEIGHT = 500;
  private static PaintModel model;
  private static Toolbar toolbar;
  private static Canvas canvas;

  public PaintView(PaintModel model) throws IllegalArgumentException {
    super("Paint");
    if (model == null) {
      throw new IllegalArgumentException("Given model is uninitialized.");
    }
    this.model = model;
    this.toolbar = new Toolbar();
    this.canvas = new Canvas();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container frame = getContentPane();
    frame.setLayout(new BorderLayout());
    frame.add(this.toolbar, BorderLayout.WEST);
    frame.add(this.canvas, BorderLayout.CENTER);
    this.pack();
    this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.setFocusable(true);
    this.requestFocus();
    this.setVisible(true);
  }
}
