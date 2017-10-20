package view;

import model.shapes.ShapeColor;
import model.shapes.StrokeWidth;
import model.shapes.ShapeType;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

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
  private final int ICON_TEXT_GAP = 10;

  protected Toolbar(ActionListener controller) {
    this.setLayout(new BorderLayout());
    this.setVisible(true);

    this.addActionsPanel(controller);
    this.addDrawingPanel(controller);
    this.add(new JPanel(), BorderLayout.CENTER);
  }

  private void addActionsPanel(ActionListener controller) {
    JPanel actions = new JPanel(new GridLayout(0, 1));
    actions.setBorder(new TitledBorder("Actions"));
    this.add(actions, BorderLayout.SOUTH);

    clearButton = new JButton("CLEAR");
    clearButton.setIcon(new ImageIcon("img/clear.png"));
    clearButton.setIconTextGap(ICON_TEXT_GAP);
    clearButton.addActionListener(controller);
    actions.add(clearButton);

    undoButton = new JButton("UNDO");
    undoButton.setIcon(new ImageIcon("img/undo.png"));
    undoButton.setIconTextGap(ICON_TEXT_GAP);
    undoButton.addActionListener(controller);
    actions.add(undoButton);

    redoButton = new JButton("REDO");
    redoButton.setIcon(new ImageIcon("img/redo.png"));
    redoButton.setIconTextGap(ICON_TEXT_GAP);
    redoButton.addActionListener(controller);
    actions.add(redoButton);
  }

  private void addDrawingPanel(ActionListener controller) {
    JPanel drawing = new JPanel(new GridLayout(0, 1));
    drawing.setBorder(new TitledBorder("Drawing"));
    this.add(drawing, BorderLayout.NORTH);

    shapeChooser = new JComboBox<>(ShapeType.values());
    shapeChooser.setName("ShapeType");
    shapeChooser.addActionListener(controller);
    drawing.add(shapeChooser);

    lineThicknessChooser = new JComboBox<>(StrokeWidth.values());
    lineThicknessChooser.setName("StrokeWidth");
    lineThicknessChooser.addActionListener(controller);
    drawing.add(lineThicknessChooser);

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
      drawing.add(colorBtn);
    }
  }
}
