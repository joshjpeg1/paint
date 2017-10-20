import model.PaintModel;
import model.shapes.ShapeColor;
import model.shapes.StrokeWidth;
import model.shapes.ShapeType;
import view.PaintView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by josh_jpeg on 10/14/17.
 */
public class PaintController extends MouseAdapter implements ActionListener {
  private static PaintModel model;
  private static PaintView view;

  protected PaintController() {
    this.model = PaintModel.initialize();
    this.view = new PaintView(this.model, this, this);
  }

  @Override
  public void mousePressed(MouseEvent me) {
    this.model.startDraw(me.getPoint());
    this.view.repaint();
  }

  @Override
  public void mouseDragged(MouseEvent me) {
    this.model.updateEndPoint(me.getPoint());
    this.view.repaint();
  }

  @Override
  public void mouseReleased(MouseEvent me) {
    this.model.stopDraw(me.getPoint());
    this.view.repaint();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equalsIgnoreCase("UNDO")) {
      this.model.undo();
      this.view.repaint();
    } else if (e.getActionCommand().equalsIgnoreCase("REDO")) {
      this.model.redo();
      this.view.repaint();
    } else if (e.getActionCommand().equalsIgnoreCase("CLEAR")) {
      this.model.clearCanvas();
      this.view.repaint();
    } else if (e.getActionCommand().equalsIgnoreCase("comboBoxChanged")) {
      JComboBox cb = (JComboBox) e.getSource();
      if (cb.getName().equalsIgnoreCase("ShapeType")) {
        this.model.setShapeType((ShapeType) cb.getSelectedItem());
      } else if (cb.getName().equalsIgnoreCase("StrokeWidth")) {
        this.model.setStrokeWidth((StrokeWidth) cb.getSelectedItem());
      }
    } else {
      for (ShapeColor c : ShapeColor.values()) {
        if (c.name().equalsIgnoreCase(e.getActionCommand())) {
          this.model.setShapeColor(c);
          return;
        }
      }
    }
  }
}
