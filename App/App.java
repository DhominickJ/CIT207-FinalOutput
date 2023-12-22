package App;

// Custom packages to import NumberGen java file

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import App.Components.BingoNumber;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import java.awt.event.*;

/**
 * App
 */
public class App {

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(App::buildGUI);
  }

  /**
   * Builds and displays the GUI for the BINGO game where it generates numbers and add the numbers generated
   * into a button that will be sent to the helper function to build a lane named buildBingoLane;
   */
  static void buildGUI() {
    
    var appWindow = new JFrame("BINGO Game!");
    var bingoBoard = new JPanel(new GridLayout(1, 5));
    var dims = new Dimension(550, 650);

    int[] b_randNumbers = NumberGen.getRandomNumberInRange(1, 15, 5);
    int[] i_randNumbers = NumberGen.getRandomNumberInRange(16, 30, 5);
    int[] n_randNumbers = NumberGen.getRandomNumberInRange(31, 45, 5);
    int[] g_randNumbers = NumberGen.getRandomNumberInRange(46, 60, 5);
    int[] o_randNumbers = NumberGen.getRandomNumberInRange(61, 75, 5);

    appWindow.setSize(dims);
    appWindow.setResizable(false);
    appWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    bingoBoard.add(buildBingoLane(b_randNumbers, "B"));
    bingoBoard.add(buildBingoLane(i_randNumbers, "I"));
    bingoBoard.add(buildBingoLane(n_randNumbers, "N"));
    bingoBoard.add(buildBingoLane(g_randNumbers, "G"));
    bingoBoard.add(buildBingoLane(o_randNumbers, "O"));

    appWindow.add(bingoBoard);

    appWindow.setVisible(true);
  }

  /**
   * Creates a JPanel for displaying a bingo lane where the letters are a major contribution towards making the 
   * layout of the the lane structure. Depending on the letter it will return a specialized color and a lighter 
   * color will be generated.
   * 
   * @param rand_Num an array of random numbers for the bingo lane
   * @param letter the letter associated with the bingo lane
   * @return the created JPanel
   */
  static JPanel buildBingoLane(int[] rand_Num, String letter) {
    var bingoLane = new JPanel(new GridLayout(6, 1)); // Generate a new Jpanel with a layout management where
                                                                // each component is in one row and stacked horizontally including the letter
    var components = new Components();
    String letter_color = "black";
    String colored_circle;
    int counter = 0;
    switch (letter) { // Decide the color of the borders, font, etc. based on the letter
      case "B":
        letter_color = "cyan";
        break;
      case "I":
        letter_color = "blue";
        break;
      case "N":
        letter_color = "red";
        break;
      case "G":
        letter_color = "yellow";
        break;
      case "O":
        letter_color = "light_green";
        break;
    }
    colored_circle = "light_" + letter_color; // Intially designed for fade in style consistency
    var bingoLabel = components.new BingoNumber(letter, ""); // Empty color to be checked to avoid rendering
                                                                  // borders for the letters.
    bingoLabel.changeFont("Berlin Sans FB", Font.BOLD, 64);
    bingoLabel.changeTextColor("gray");
    bingoLane.add(bingoLabel);

    for (int bingo_Num : rand_Num) { 
      // A number checker used to check for where the FREE will be inserted and add the colors based on the case
      // above
      BingoNumber bingoButton;
      if (letter == "N" && counter == 2) {
        bingoButton = components.new BingoNumber("FREE", "gold");
      } else {
        bingoButton = components.new BingoNumber(Integer.toString(bingo_Num), colored_circle);
      }

      bingoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // Handle the button click here
          BingoNumber btn;
          btn = components.new BingoNumber(Integer.toString(bingo_Num), colored_circle);
          btn.borderStatus(false); // Initially designed for further features for now as a checker.
          JButton button = (JButton) e.getSource();
          // // Change text color to black background color for gray when selected.
          button.setForeground(Color.lightGray);
          button.setBackground(Color.GRAY);

        }
      });

      bingoLane.add(bingoButton); // Add the buttons to the JPanel in a laneStyling
      counter += 1; // Counter used for FREE checker
    }

    return bingoLane; 
  }
}
