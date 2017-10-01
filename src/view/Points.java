package view;
import javax.swing.*;
import java.awt.*;

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
    private JPanel panelInfo;
    private JButton pauseButton;
    private JButton stopButton;
    private JLabel upLabel;
    private JLabel downLabel;
    private JLabel leftLabel;
    private JLabel rightLabel;
    private JLabel stopLabel;

    public JLabel getStopLabel() {
        return stopLabel;
    }

    private Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();

    public JLabel getUpLabel() {
        return upLabel;
    }

    public JLabel getDownLabel() {
        return downLabel;
    }

    public JLabel getLeftLabel() {
        return leftLabel;
    }

    public JLabel getRightLabel() {
        return rightLabel;
    }

    public JButton getPauseButton() {
        return pauseButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    public JPanel getPanelInfo() {
        return panelInfo;
    }


    public JPanel getCentralPanel() {
        return centralPanel;
    }

    //Constructor
    public Points() {
        setTitle("Points");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(sSize.width, sSize.height);
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
