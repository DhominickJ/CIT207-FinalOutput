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

import App.Components.BingoNumber;

// import App.Components.BingoNumber;

import javax.swing.JButton;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BorderFactory;

import java.awt.event.*;
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
    int counter = 0;
    int font_size = 0;
    // System.out.println(letter);
    switch (letter){
      case "B": letter_color = "cyan"; break;
      case "I": letter_color = "blue"; break;
      case "N": letter_color = "red"; break;
      case "G": letter_color = "yellow"; break;
      case "O": letter_color = "light_green"; break;
    }
    System.out.println(letter_color);
    colored_circle = "light_" + letter_color;
    var bingoLabel = components.new BingoNumber(letter, "");
    bingoLabel.changeFont("Berlin Sans FB", Font.BOLD, 64);
    bingoLabel.changeTextColor("gray");
    bingoLane.add(bingoLabel);

    for (int bingo_Num : rand_Num) {
      BingoNumber bingoButton;
      if(letter.equals("N") && counter == 2){
        bingoButton = components.new BingoNumber("FREE", "gold");
      }
      else{
        bingoButton = components.new BingoNumber(Integer.toString(bingo_Num), colored_circle);
      }
      
      bingoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // Handle the button click here
          System.out.println("Button clicked!");
          JButton btn = (JButton)e.getSource();
          // Change text color to black and border color to gray when selected
          btn.setForeground(Color.lightGray);
          btn.setBackground(Color.GRAY);
        }
      });

      bingoLane.add(bingoButton);
      counter += 1;
    }

    return bingoLane;
  }
}

