package view;
import javax.swing.*;

public class Points extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel downPanel;
    private JFormattedTextField chanceUp;
    private JFormattedTextField chanceDown;
    private JFormattedTextField chanceLeft;
    private JFormattedTextField chanceRight;
    private JFormattedTextField chanceStop;
    private JButton startButton;
    private JProgressBar progressBar1;
    private JFormattedTextField counter;
    private JFormattedTextField widthField;
    private JFormattedTextField heightField;
    private JFormattedTextField startXField;
    private JFormattedTextField startYField;
    private JPanel leftPanel;
    private JPanel centralPanel;

    public JPanel getCentralPanel() {
        return centralPanel;
    }

    //Constructor
    public Points() {
        setTitle("Points");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setContentPane(mainPanel);
    }

    //Getters
    public JFormattedTextField getChanceUp() {
        return chanceUp;
    }

    public JFormattedTextField getChanceDown() {
        return chanceDown;
    }

    public JFormattedTextField getChanceLeft() {
        return chanceLeft;
    }

    public JFormattedTextField getChanceRight() {
        return chanceRight;
    }

    public JFormattedTextField getChanceStop() {
        return chanceStop;
    }

    public JButton getStartButton() {
        startButton.setEnabled(false);
        return startButton;
    }

    public JProgressBar getProgressBar1() {
        return progressBar1;
    }

    public JFormattedTextField getCounter() {

        return counter;
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public JPanel getDownPanel() {
        return downPanel;
    }

    //leftPanel


    public JFormattedTextField getWidthField() {
        return widthField;
    }

    public JFormattedTextField getHeightField() {
        return heightField;
    }

    public JFormattedTextField getStartXField() {
        return startXField;
    }

    public JFormattedTextField getStartYField() {
        return startYField;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
