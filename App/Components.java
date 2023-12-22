package App;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;
import java.awt.*;

public class Components {
  /**
   * Represents a custom JButton for a Bingo number.
   */
  public class BingoNumber extends JButton {
    // private int number;
    private String color;
    private boolean statusBorder = true;

    // Override ctor to add additional behavior.
    /**
     * Represents a Bingo number component.
     * Inherits from the superclass and sets the font, color, background, border, and size of the component.
     * 
     * @param text The text to be displayed on the component.
     * @param color The color of the component.
     */
    public BingoNumber(String text, String color) {
      super(text);
      int counter = 0;
      // Checks the text if it is a FREE so that it adjusts the font accordingly.
      this.setFont(new Font("Impact", Font.PLAIN, text.equals("FREE") ? 20 : 50)); 
      this.setForeground(stringToColor(color));

      Dimension size = getPreferredSize();
      size.width = size.height = Math.max(size.width, size.height); // Returns the width and height of the button
      setPreferredSize(size);
      setContentAreaFilled(false); // Implemented for additional features unused but returns error when removed.
      this.color = color;
    }

    /**
     * Changes the font of the component.
     * 
     * @param fontName the name of the font
     * @param style the style of the font (e.g., Font.PLAIN, Font.BOLD, Font.ITALIC)
     * @param size the size of the font
     */
    // Add convenience functions.
    public void changeFont(String fontName, int style, int size) {
      this.setFont(new Font(fontName, style, size));
    }

    /**
     * Changes the font size of the component.
     * 
     * @param size the new font size to be set
     */
    public void changeFontSize(int size) {
      this.changeFont("Impact", Font.BOLD, size);
    }

    /**
     * Changes the color of the component based on the text provided referenced by a function below.
     * 
     * @param color to return a color component based on the string; 
     * referred to the function below for more context
     */
    public void changeTextColor(String color) {
      this.setForeground(stringToColor(color));
    }

    /**
     * Sets the colored border of the component for additional feature, however unused at the moment for 
     * a feature to check if bingo but unimplemented due to time constraints
     * 
     * @param size the size of the border
     */
    public void coloredBorder(int size) {
      this.setBorder(BorderFactory.createLineBorder(stringToColor(color), size));
    }

    /**
     * Sets the status of the border for this component for additional feature but unused at the moment
     * for checking if the function is toggled
     * 
     * @param statusBorder the status of the border
     */
    public void borderStatus(boolean statusBorder) {
      this.statusBorder = statusBorder;
    }

    // Overriding the paintComponent function to fit our design goals.
    @Override
    protected void paintComponent(Graphics g) {
      float thickness = 3f;
      // If statusBorder is false, remove the border
      if (!statusBorder) {
        setBorder(null);
      } else {
        // If statusBorder is true, set the border to your custom border
        setBorder(BorderFactory.createStrokeBorder(new BasicStroke(thickness)));
      }
      super.paintComponent(g);

      // Everything below will be used in order to 
      int rect_size = Math.min(getSize().width, getSize().height) - 20;
      int x_rect = (getSize().width - rect_size) / 2;
      int y_rect = (getSize().height - rect_size) / 2;

      Graphics2D g2d = (Graphics2D) g;

      // Enable anti-aliasing
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      // Draw a rectangle with rounded corners
      float roundness = 35f; // Adjust this value to change the roundness of the corners
      g2d.setColor(stringToColor(color));
      g2d.setStroke(new BasicStroke(thickness));

      if (getModel().isArmed()) {
        g2d.setColor(Color.lightGray);
      } else {
        g2d.setColor(getBackground());
      }
      g2d.fill(new RoundRectangle2D.Float(x_rect, y_rect, rect_size, rect_size, roundness, roundness));
    }

    // Overriding the paintBorder function to fit our design goals.
    @Override
    protected void paintBorder(Graphics g) {
      super.paintComponent(g);
      int diameter = Math.min(getSize().width, getSize().height) - 20;
      // Functions used to center the text and buttons to the grid.
      int x = (getSize().width - diameter) / 2;
      int y = (getSize().height - diameter) / 2;

      Graphics2D g2d = (Graphics2D) g;
      g2d.setColor(stringToColor(color));
      float thickness = 3f; // Set the thickness of the border here
      g2d.setStroke(new BasicStroke(thickness));
      // g2d.drawRect(x, y, diameter, diameter);

      // Enable anti-aliasing
      // Make the text and borders edges less noticeable

      // Code referenced from: https://stackoverflow.com/questions/779198/how-can-i-set-renderinghints-globally
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      // Draw a rectangle with rounded corners
      float roundness = 35f; // Adjust this value to change the roundness of the corners

      if (getModel().isArmed()) {
        g2d.setColor(Color.lightGray);
      } else {
        g2d.setColor(stringToColor(color));
      }

      g2d.draw(new RoundRectangle2D.Float(x, y, diameter, diameter, roundness, roundness));
    }

    // Convenience functions
    public void paintLabel(Graphics g, String color) {
      g.setColor(stringToColor(color));
    }

    /**
     * Converts a string representation of a color to a Color object.
     * 
     * @param color the string representation of the color
     * @return the Color object corresponding to the given string, or null if no matching color is found
     */
    private Color stringToColor(String color) {
      switch (color.toLowerCase()) {
        case "black":
          return Color.BLACK;
        case "blue":
          return new Color(52, 204, 255);
        case "light_blue":
          return new Color(52, 204, 255);
        case "cyan":
          return Color.CYAN;
        case "light_cyan":
          return new Color(110, 225, 255);
        case "dark_gray":
          return Color.DARK_GRAY;
        case "gray":
          return Color.GRAY;
        case "green":
          return Color.GREEN;
        case "light_gray":
          return Color.LIGHT_GRAY;
        case "magenta":
          return Color.MAGENTA;
        case "orange":
          return Color.ORANGE;
        case "pink":
          return Color.PINK;
        case "red":
          return Color.RED;
        case "light_red":
          return new Color(204, 77, 77);
        case "white":
          return Color.WHITE;
        case "yellow":
          return Color.YELLOW;
        case "light_yellow":
          return new Color(255, 255, 113);
        case "light_green":
          return new Color(0, 250, 154);
        case "light_light_green":
          return new Color(0, 255, 153);
        case "gold":
          return new Color(229, 184, 11);
        default:
          return null;
      }
    }

    /**
     * Represents the dimensions of a component or object.
     * The dimensions are specified as width and height values.
     */
    @Override
    public Dimension getPreferredSize() {
      return new Dimension(50, 50);
    }
  }
}
