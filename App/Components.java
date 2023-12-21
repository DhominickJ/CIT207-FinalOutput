package App;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class Components {
  public class BingoNumber extends JButton {
    // private int number;
    private String color;
    private String num_letter;
    private ActionListener actionListener;

    public BingoNumber(String text, String color) {
      super(text);
      this.setFont(new Font("Arial", color.equals("FREE") ? Font.BOLD : Font.PLAIN, color.equals("FREE") ? 20 : 50));
      this.setForeground(Color.GRAY);
      this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
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
      int diameter = Math.min(getSize().width, getSize().height) - 20;
      int rect_size = Math.min(getSize().width, getSize().height);
      int x_rect = (getSize().width - rect_size) / 2;
      int y_rect = (getSize().height - rect_size) / 2;
      int x = (getSize().width - diameter) / 2;
      int y = (getSize().height - diameter) / 2;

      Graphics2D g2 = (Graphics2D) g;
      g2.setStroke(new BasicStroke(4));

      // // Draw rectangle
      // g.setColor(getBackground());
      // g.fillRect(x, y, rect_size, rect_size);

      // Draw border
      g.setColor(stringToColor(color));
      g.drawRect(x_rect, y_rect, rect_size, rect_size);
      
      g.setColor(stringToColor(color));
      g.fillOval(x, y, diameter, diameter);

      super.paintComponent(g);
    }

    public void paintLabel(Graphics g, String color){
      g.setColor(stringToColor(color));
    }

    private Color stringToColor(String color) {
      switch (color.toLowerCase()) {
        case "black": return Color.BLACK;
        case "blue": return Color.BLUE;
        case "light_blue": return new Color(52, 204, 255);
        case "cyan": return Color.CYAN;
        case "light_cyan": return new Color(110, 255, 255);
        case "dark_gray": return Color.DARK_GRAY;
        case "gray": return Color.GRAY;
        case "green": return Color.GREEN;
        case "light_gray": return Color.LIGHT_GRAY;
        case "magenta": return Color.MAGENTA;
        case "orange": return Color.ORANGE;
        case "pink": return Color.PINK;
        case "red": return Color.RED;
        case "light_red": return new Color(204, 77, 77);
        case "white": return Color.WHITE;
        case "yellow": return Color.YELLOW;
        case "light_yellow": return new Color(255, 255, 113);
        case "light_green": return new Color(0, 250, 154);
        case "light_light_green": return new Color(0, 255, 153);
        default: return Color.BLACK;
      }
    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(50, 50);
    }
    public void addActionListener(ActionListener l) {
      actionListener = l;
    }
    // Call this method when you want to trigger the action
    private void triggerAction() {
      if (actionListener != null) {
        actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "button clicked"));
      }
      }
    }
  }
