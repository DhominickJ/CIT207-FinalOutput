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
    String[] bButtons = intArrToStringArr(NumberGen.getRandomNumberInRange(1, 15, 5));
    String[] iButtons = intArrToStringArr(NumberGen.getRandomNumberInRange(16, 30, 5));
    String[] nButtons = intArrToStringArr(NumberGen.getRandomNumberInRange(31, 45, 5));
    String[] gButtons = intArrToStringArr(NumberGen.getRandomNumberInRange(46, 60, 5));
    String[] oButtons = intArrToStringArr(NumberGen.getRandomNumberInRange(61, 75, 5));

    appWindow.setSize(dims);
    appWindow.setResizable(false);
    appWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    var titlePanel = new JPanel(new GridLayout(1, 5));
    JLabel[] bingoLabels = { new JLabel("B"), new JLabel("I"), new JLabel("N"), new JLabel("G"), new JLabel("O"), };

    for (var bingoLabel : bingoLabels) {
      titlePanel.add(bingoLabel);
    }

    appPanel.add(titlePanel);

    bingoBoard.add(buildBingoLane(bButtons));
    bingoBoard.add(buildBingoLane(bButtons));
    bingoBoard.add(buildBingoLane(bButtons));
    bingoBoard.add(buildBingoLane(bButtons));
    bingoBoard.add(buildBingoLane(bButtons));

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
    int counter = 0;
    int font_size = 0;
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
      if(letter == "N" && counter == 2){
        numString = "FREE";
        font_size = 20;
      }
      else{
        numString = Integer.toString(bingo_Num);
        font_size = 50;
      }
      // numString = Integer.toString(bingo_Num);
      var bingoButton = components.new BingoNumber(numString, colored_circle);
      bingoButton.changeFont("Arial", Font.BOLD, font_size);
      bingoButton.changeTextColor(Color.GRAY);
      bingoButton.coloredBorder(5);
      bingoLane.add(bingoButton);
      counter += 1;
    }

    return bingoLane;
  }

  static String[] intArrToStringArr(int[] intArr) {
    return Arrays.stream(intArr).mapToObj(String::valueOf).toArray(String[]::new);
  }
}
