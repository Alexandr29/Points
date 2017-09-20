package controller;

import view.Points;

import javax.swing.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class MainFrameController {
    private Points points;
    private JFormattedTextField chanceUp;
    private JFormattedTextField chanceDown;
    private JFormattedTextField chanceLeft;
    private JFormattedTextField chanceRight;
    private JFormattedTextField chanceStop;
    private JButton startButton;
    private JProgressBar progressBar1;
    private JFormattedTextField counter;

    public MainFrameController() {
        points = new Points();
        initComponents();
        initListeners();
    }

    private void initListeners() {
        chanceUp.addMouseListener(new chanceAdapter());
        chanceUp.addKeyListener(new MyKeyAdapter());

        chanceDown.addMouseListener(new chanceAdapter());

        chanceLeft.addMouseListener(new chanceAdapter());
        chanceRight.addMouseListener(new chanceAdapter());
        chanceStop.addMouseListener(new chanceAdapter());

        startButton.addActionListener(new StartProgressBarListener());
    }

    private void initComponents() {
        chanceUp = points.getChanceUp();
        chanceDown = points.getChanceDown();
        chanceLeft = points.getChanceLeft();
        chanceRight = points.getChanceRight();
        chanceStop = points.getChanceStop();
        startButton = points.getStartButton();
        progressBar1 = points.getProgressBar1();
        counter = points.getCounter();
    }

    //Adapters
    private class chanceAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Mouse clicked");
            if (chanceStop.getText().equals("")) {
                if ((!Objects.equals(chanceUp.getText(), "")) & (!Objects.equals(chanceDown.getText(), "")) & (!Objects.equals(chanceLeft.getText(), "")) & (!Objects.equals(chanceRight.getText(), ""))) {
                    double d = Double.parseDouble(chanceUp.getText());
                    double a = Double.parseDouble(chanceDown.getText());
                    double b = Double.parseDouble(chanceLeft.getText());
                    double c = Double.parseDouble(chanceRight.getText());

                    double res = (1 - (a + b + c + d));
                    double newDouble = new BigDecimal(res).setScale(3, RoundingMode.HALF_UP).doubleValue();

                                                                                                                        //System.out.println(newDouble);

                    JTextField jTextField = (JTextField) e.getSource();
                    jTextField.setText(String.valueOf(newDouble));
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            JTextField jTextField = (JTextField) e.getSource();
            if (jTextField.getText().equals("Up") | jTextField.getText().equals("Down") | jTextField.getText().equals("Left") | jTextField.getText().equals("Right") | jTextField.getText().equals("Stop")) {
                jTextField.setText("");
            }
        }
    }


    public void showMainFrame() {
        points.setLocationRelativeTo(null);
        points.setVisible(true);
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (chanceUp.getText().equals("Up")){
                chanceUp.setText("");
            }
        }
    }

    private class StartProgressBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>(){

                @Override
                protected Void doInBackground() throws Exception {
                    int max = Integer.parseInt(counter.getText());
                    System.out.println(max);
                    progressBar1.setMinimum(0);
                    progressBar1.setMaximum(max);
                    for (int i = 0; i < max; i++) {
                        progressBar1.setValue(i+1);
                    }
                    return null;
                }
            };
            swingWorker.execute();
        }
    }
}
