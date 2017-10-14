package view;

import javax.swing.JPanel;
import java.awt.*;

/**
 * Created by josh_jpeg on 10/14/17.
 */
public class Canvas extends JPanel {
  public Canvas() {
    this.setMinimumSize(new Dimension(PaintView.WIDTH, PaintView.HEIGHT));
    this.setVisible(true);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.black);
    g.fillRect(0, 0, PaintView.WIDTH, PaintView.HEIGHT);
  }
}
