package App;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

public class Components {
  class BingoNumber extends JButton {
    private Color color = Color.GRAY;
    // private Dimension defaultSize = new Dimension(50, 50);
    private boolean toggleFlag = false;

    public BingoNumber(String label) {
      super(label);

      this.setBorderPainted(false);
      this.setContentAreaFilled(false);
    }

    public BingoNumber(String label, Color color) {
      super(label);
      this.color = color;

      this.setBorderPainted(false);
      this.setContentAreaFilled(false);
    // private int number;
    private String color;
    private String num_letter;

    public BingoNumber(String num_letter, String color) {
      // this.number = number;
      this.setText(num_letter);
      this.setBorderPainted(false);
      this.setContentAreaFilled(false);
      this.color = color;
      this.num_letter = num_letter;
    }

    public void changeFont(String fontName, int style, int size) {
      this.setFont(new Font(fontName, style, size));
    }
    public void changeFontSize(int size){
      this.changeFont("Arial",Font.BOLD,size);
    }

    public void changeTextColor(Color newColor){
      this.setForeground(newColor);
    }

    public void coloredBorder(int size){
      this.setBorder(BorderFactory.createLineBorder(Color.BLACK, size));
    }

    @Override
    protected void paintComponent(Graphics g) {
      Dimension originalSize = super.getPreferredSize();
      int diameter = Math.min(originalSize.width, originalSize.height);

      g.setColor(color);
      g.fillOval(0, 0, diameter, diameter);
      super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
      Dimension size = super.getPreferredSize();
      size.width = size.height = Math.min(size.width, size.height);
      return size;
    }

    public boolean toggle() {
      toggleFlag = !toggleFlag;
      return toggleFlag;
    }
  }
}
