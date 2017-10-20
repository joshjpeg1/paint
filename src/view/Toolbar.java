package view;

import model.shapes.ShapeColor;
import model.shapes.StrokeWidth;
import model.shapes.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by josh_jpeg on 10/14/17.
 */
public class Toolbar extends JPanel {
  private JComboBox<ShapeType> shapeChooser;
  private JComboBox<StrokeWidth> lineThicknessChooser;
  private JButton undoButton;
  private JButton redoButton;
  private JButton clearButton;
  private ButtonGroup colors;

  protected Toolbar(ActionListener controller) {
    this.setLayout(new GridLayout(0, 1));
    this.setVisible(true);

    shapeChooser = new JComboBox<>(ShapeType.values());
    shapeChooser.setName("ShapeType");
    shapeChooser.addActionListener(controller);
    this.add(shapeChooser);

    lineThicknessChooser = new JComboBox<>(StrokeWidth.values());
    lineThicknessChooser.setName("StrokeWidth");
    lineThicknessChooser.addActionListener(controller);
    this.add(lineThicknessChooser);

    undoButton = new JButton("UNDO");
    undoButton.addActionListener(controller);
    this.add(undoButton);

    redoButton = new JButton("REDO");
    redoButton.addActionListener(controller);
    this.add(redoButton);

    clearButton = new JButton("CLEAR");
    clearButton.addActionListener(controller);
    this.add(clearButton);

    colors = new ButtonGroup();
    boolean selected = false;
    for (ShapeColor c : ShapeColor.values()) {
      AbstractButton colorBtn = new JRadioButton(c.name());
      if (!selected) {
        colorBtn.setSelected(true);
        selected = true;
      }
      colorBtn.addActionListener(controller);
      colors.add(colorBtn);
      this.add(colorBtn);
    }
  }
}
