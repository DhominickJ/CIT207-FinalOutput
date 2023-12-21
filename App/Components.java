package App;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;

public class Components {
  class BingoNumber extends JButton {
    private Color circleColor = Color.BLUE;

    public BingoNumber(int label) {
      // super(label);
      super(Integer.toString(label));
    }

    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Dimension originalSize = super.getPreferredSize();
    int diameter = Math.min(originalSize.width, originalSize.height);

    g.setColor(circleColor);
    g.fillOval(0, 0, diameter, diameter);
    }

    @Override
    public Dimension getPreferredSize() {
      Dimension size = super.getPreferredSize();
      size.width = size.height = Math.min(size.width, size.height);
      return size;
    }
  }
}
