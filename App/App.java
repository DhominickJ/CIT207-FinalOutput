package App;

// Custom packages to import NumberGen java file

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.BorderFactory;

import App.Components.BingoNumber;

import javax.swing.JButton;

import javax.swing.SwingConstants;
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

  static JPanel buildBingoLane(int[] rand_Num, String letter) {
    var bingoLane = new JPanel(new GridLayout(6, 1));
    var components = new Components();
    String letter_color = "black";
    String colored_circle;
    int counter = 0;
    switch (letter){
      case "B": letter_color = "cyan"; break;
      case "I": letter_color = "blue"; break;
      case "N": letter_color = "red"; break;
      case "G": letter_color = "yellow"; break;
      case "O": letter_color = "light_green"; break;
    }
    colored_circle = "light_" + letter_color;
    var bingoLabel = components.new BingoNumber(letter, "");
    bingoLabel.changeFont("Berlin Sans FB", Font.BOLD, 64);
    bingoLabel.changeTextColor("gray");
    bingoLane.add(bingoLabel);

    for (int bingo_Num : rand_Num) {
      BingoNumber bingoButton;
      if(letter == "N" && counter == 2){
        bingoButton = components.new BingoNumber("FREE", "gold");
      }
      else{
        bingoButton = components.new BingoNumber(Integer.toString(bingo_Num), colored_circle);
      }
      
      // int b_count = 0;
      // int i_count = 0;
      // int n_count = 0;
      // int g_count = 0;
      // int o_count = 0;

      bingoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // Handle the button click here
          System.out.println("Button clicked!");
          BingoNumber btn;
          btn = components.new BingoNumber(Integer.toString(bingo_Num), colored_circle);
          btn.borderStatus(false);
          JButton button = (JButton)e.getSource();
          // // Change text color to black and border color to gray when selected
          button.setForeground(Color.lightGray);
          button.setBackground(Color.GRAY);
          // switch(letter){
          //   case "B" : b_count =+ 1; break;
          //   case "I" : i_count =+ 1; break;
          //   case "N" : n_count =+ 1; break;
          //   case "G" : g_count =+ 1; break;
          //   case "O" : g_count =+ 1; break;
          // }
          
          // // ((CustomButton)btn).borderStatus(false);
          // btn.borderStatus(false);

        }
      });

      bingoLane.add(bingoButton);
      counter += 1;
    }


    return bingoLane;
  }
}
//   public boolean checkBingo(boolean[][] card) {
//         int size = card.length;

//         // Check rows and columns
//         for (int i = 0; i < size; i++) {
//           boolean rowBingo = true;
//           boolean colBingo = true;
//           for (int j = 0; j < size; j++) {
//             if (!card[i][j]) {
//               rowBingo = false;
//             }
//             if (!card[j][i]) {
//               colBingo = false;
//             }
//           }
//           if (rowBingo || colBingo) {
//             return true;
//           }
//         }

//         // Check diagonals
//         boolean diagBingo1 = true;
//         boolean diagBingo2 = true;
//         for (int i = 0; i < size; i++) {
//           if (!card[i][i]) {
//             diagBingo1 = false;
//           }
//           if (!card[i][size - i - 1]) {
//             diagBingo2 = false;
//           }
//         }

//         return diagBingo1 || diagBingo2;
//       }
// }

