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

    String[] sampleButtonLabels = { "1", "3", "7", "9", "15" };
    // NumberGen genNum = new NumberGen();
    int[] b_randNumbers = NumberGen.getRandomNumberInRange(1, 15, 5);
    int[] i_randNumbers = NumberGen.getRandomNumberInRange(16, 30, 5);
    int[] n_randNumbers = NumberGen.getRandomNumberInRange(31, 45, 5);
    int[] g_randNumbers = NumberGen.getRandomNumberInRange(46, 60, 5);
    int[] o_randNumbers = NumberGen.getRandomNumberInRange(61, 75, 5);

    appWindow.setSize(dims);
    appWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // var titlePanel = new JPanel(new GridLayout(1, 5));
    // JLabel[] bingoLabels = { new JLabel("B"), new JLabel("I"), new JLabel("N"), new JLabel("G"), new JLabel("O"), };

    // for (var bingoLabel : bingoLabels) {
    //   titlePanel.add(bingoLabel);
    // }

    // appPanel.add(titlePanel);

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

    JLabel label = new JLabel(letter, SwingConstants.CENTER);
    label.setFont(new Font("Sergoe UI", Font.BOLD, 30));
    bingoLane.add(label);

    for (int bingo_Num : rand_Num) {
      var bingoButton = components.new BingoNumber(bingo_Num);
      bingoLane.add(bingoButton);
    }

    return bingoLane;
  }
}
