package view;

import javax.swing.*;

public class Points extends JFrame {
    private JPanel mainPanel;
    //private JPanel topPanel;
    //private JPanel downPanel;
    private JFormattedTextField chanceUp;
    private JFormattedTextField chanceDown;
    private JFormattedTextField chanceLeft;
    private JFormattedTextField chanceRight;
    private JFormattedTextField chanceStop;
    private JButton startButton;
    private JProgressBar progressBar1;
    private JFormattedTextField counter;

    //Constructor
        public Points(){
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(600,500);
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
}
