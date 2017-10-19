package view;

import model.PaintModel;
import model.shapes.LineThickness;
import model.shapes.ShapeType;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by josh_jpeg on 10/14/17.
 */
public class Toolbar extends JPanel {
  private static PaintModel model;
  private static JComboBox<ShapeType> shapeChooser;
  private static JComboBox<LineThickness> lineThicknessChooser;
  private static JButton clearButton;

  public Toolbar(PaintModel model, ActionListener controller) {
    this.model = model;
    this.shapeChooser = new JComboBox<>(ShapeType.values());
    this.lineThicknessChooser = new JComboBox<>(LineThickness.values());
    this.clearButton = new JButton("CLEAR");
    this.clearButton.addActionListener(controller);

    this.setLayout(new GridLayout(0, 1));
    this.setVisible(true);
    this.add(this.shapeChooser);
    this.add(this.lineThicknessChooser);
    this.add(this.clearButton);
    //this.add(new JColorChooser());
  }
}
