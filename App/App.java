package App;

// Custom packages to import NumberGen java file

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
/**
 * App
 */
public class App {

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(App::buildGUI);
  }

  static void buildGUI() {
    var appWindow = new JFrame("BINGO Game!");
    // var appPanel = new JPanel(new GridLayout(1, 1));s
    var bingoBoard = new JPanel(new GridLayout(1, 5));
    var dims = new Dimension(550, 650);

    // String[] sampleButtonLabels = { "1", "3", "7", "9", "15" };
    // NumberGen genNum = new NumberGen();
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

    // appPanel.add(bingoBoard);

    appWindow.add(bingoBoard);

    appWindow.setVisible(true);
  }

  static JPanel buildBingoLane(int[] rand_Num, String letter) {
    var bingoLane = new JPanel(new GridLayout(6, 1));
    var components = new Components();
    // String letter = "Hello World!";
    String letter_color = "black";
    JLabel label = new JLabel(letter, SwingConstants.CENTER);
    String numString;
    String colored_circle;
    switch (letter.toLowerCase()){
      case "b": letter_color = "cyan"; break;
      case "i": letter_color = "blue"; break;
      case "n": letter_color = "red"; break;
      case "g": letter_color = "yellow"; break;
      case "o": letter_color = "light_green"; break;
    }
    colored_circle = "light_" + letter_color;
    var bingoLabel = components.new BingoNumber(letter, letter_color);
    bingoLabel.changeFont("Arial", Font.BOLD, 64);
    bingoLabel.changeTextColor(Color.GRAY);
    bingoLane.add(bingoLabel);
    

    for (int bingo_Num : rand_Num) {
      numString = Integer.toString(bingo_Num);
      var bingoButton = components.new BingoNumber(numString, colored_circle);
      bingoButton.changeFont("Arial", Font.BOLD, 50);
      bingoButton.changeTextColor(Color.GRAY);
      bingoButton.coloredBorder(5);
      bingoLane.add(bingoButton);
    }

    return bingoLane;
  }
}
