package App;

// Custom packages to import NumberGen java file

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * App
 */
public class App {

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(App::buildGUI);
  }

  static void buildGUI() {
    var appWindow = new JFrame("BINGO Game!");
    var appPanel = new JPanel(new GridLayout(2, 1));
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
    appWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    var titlePanel = new JPanel(new GridLayout(5, 1));
    JLabel[] bingoLabels = { new JLabel("B"), new JLabel("I"), new JLabel("N"), new JLabel("G"), new JLabel("O"), };

    for (var bingoLabel : bingoLabels) {
      titlePanel.add(bingoLabel);
    }

    // Dimension titlePanelSize = new Dimension(550, 50);  // Set the width and height you want for the titlePanel
    // titlePanel.setPreferredSize(titlePanelSize);

    appPanel.add(titlePanel);

    bingoBoard.add(buildBingoLane(b_randNumbers));
    bingoBoard.add(buildBingoLane(i_randNumbers));
    bingoBoard.add(buildBingoLane(n_randNumbers));
    bingoBoard.add(buildBingoLane(g_randNumbers));
    bingoBoard.add(buildBingoLane(o_randNumbers));

    appPanel.add(bingoBoard);

    appWindow.add(appPanel);

    appWindow.setVisible(true);
  }

  static JPanel buildBingoLane(int[] rand_Num) {
    var bingoLane = new JPanel(new GridLayout(5, 1));
    var components = new Components();

    for (int bingo_Num : rand_Num) {
      var bingoButton = components.new BingoNumber(bingo_Num);
      bingoLane.add(bingoButton);
    }

    return bingoLane;
  }
}
