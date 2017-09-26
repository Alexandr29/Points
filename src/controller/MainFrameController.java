package controller;

import view.Points;

import javax.swing.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Random;

public class MainFrameController {
    private Points points;
    private JFormattedTextField chanceUp;
    private JFormattedTextField chanceDown;
    private JFormattedTextField chanceLeft;
    private JFormattedTextField chanceRight;
    private JFormattedTextField chanceStop;
    private JProgressBar progressBar1;
    private JFormattedTextField counter;
    private JPanel topPanel;
    private JPanel downPanel;
    private JFormattedTextField widthField;
    private JFormattedTextField heightField;
    private JFormattedTextField startXField;
    private JFormattedTextField startYField;

    private JButton startButton;

    //Constructor
    public MainFrameController() {
        points = new Points();
        initComponents();
        initListeners();
    }

    private void initListeners() {
        chanceUp.addMouseListener(new ChanceAdapter());
        chanceUp.addKeyListener(new MyKeyAdapter());

        chanceDown.addMouseListener(new ChanceAdapter());
        chanceDown.addKeyListener(new MyKeyAdapter());

        chanceLeft.addMouseListener(new ChanceAdapter());
        chanceLeft.addKeyListener(new MyKeyAdapter());

        chanceRight.addMouseListener(new ChanceAdapter());
        chanceRight.addKeyListener(new MyKeyAdapter());

        chanceStop.addMouseListener(new ChanceAdapter());
        chanceStop.addKeyListener(new MyKeyAdapter());

        counter.addMouseListener(new ChanceAdapter());
        counter.addKeyListener(new MyKeyAdapter());

        //leftPanel
        widthField.addKeyListener(new LeftPanelFieldsAdapters());
        heightField.addKeyListener(new LeftPanelFieldsAdapters());
        startXField.addKeyListener(new LeftPanelFieldsAdapters());
        startYField.addKeyListener(new LeftPanelFieldsAdapters());


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
        topPanel = points.getTopPanel();
        downPanel = points.getDownPanel();
        //leftPanel
        widthField = points.getWidthField();
        heightField = points.getHeightField();
        startXField = points.getStartXField();
        startYField = points.getStartYField();
    }

    //setVisibleTrue
    public void showMainFrame() {
        points.setLocationRelativeTo(null);
        points.setVisible(true);
    }
    //Adapters
    private class ChanceAdapter extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent e) {
            if (chanceStop.getText().equals("")) {
                if ((!Objects.equals(chanceUp.getText(), "")) & (!Objects.equals(chanceDown.getText(), "")) & (!Objects.equals(chanceLeft.getText(), "")) & (!Objects.equals(chanceRight.getText(), ""))) {
                    double d = Double.parseDouble(chanceUp.getText());
                    double a = Double.parseDouble(chanceDown.getText());
                    double b = Double.parseDouble(chanceLeft.getText());
                    double c = Double.parseDouble(chanceRight.getText());

                    if ((d+a+b+c)<1 ){
                        double res = (1 - (a + b + c + d));
                        double newDouble = new BigDecimal(res).setScale(3, RoundingMode.HALF_UP).doubleValue();

                        JFormattedTextField jTextField = (JFormattedTextField) e.getSource();
                        jTextField.setText(String.valueOf(newDouble));
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            JFormattedTextField jFormattedTextField = (JFormattedTextField) e.getSource();
            if (jFormattedTextField.getText().equals("Up") | jFormattedTextField.getText().equals("Down") | jFormattedTextField.getText().equals("Left") | jFormattedTextField.getText().equals("Right") | jFormattedTextField.getText().equals("Stop") | jFormattedTextField.getText().equals("Counter")) {
                jFormattedTextField.setText("");
            }
        }
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {

            char input = e.getKeyChar();
            if ((input<'0' || input > '9') && input !='\b' &&input !='.'){
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

            char input = e.getKeyChar();
            if ((input<'0' || input > '9') && input !='\b' &&input !='.'){
                e.consume();
            }

           String a = chanceUp.getText();
           String b = chanceDown.getText();
           String c = chanceLeft.getText();
           String d = chanceRight.getText();
           String f = chanceStop.getText();
           String g = counter.getText();

           if (!Objects.equals(a, "") & !Objects.equals(b, "")& !Objects.equals(c, "") & !Objects.equals(d, "")& !Objects.equals(f, "") & !Objects.equals(g, "") ){
               double q = Double.parseDouble(a);
               double w = Double.parseDouble(b);
               double r = Double.parseDouble(c);
               double t = Double.parseDouble(d);
               double y = Double.parseDouble(f);


               if (y>=0 & y<=1){
                   double res = (q + w + r + t + y);
                   double newDouble = new BigDecimal(res).setScale(3, RoundingMode.HALF_UP).doubleValue();
                   if (newDouble == 1){
                       startButton.setEnabled(true);
                   }
               }





           }
        }

       // @Override
       // public void keyPressed(KeyEvent e) {
       //   if (chanceUp.getText().equals("Up")){
      //          chanceUp.setText("");
      //      }
       //}
    }
    //Listeners
    private class StartProgressBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String stringChanceUp = chanceUp.getText();
            String stringChanceDown = chanceDown.getText();
            String stringChanceLeft = chanceLeft.getText();
            String stringChanceRight = chanceRight.getText();
            String stringChanceStop = chanceStop.getText();
            String stringCounter = counter.getText();

                float doubleChanceUp = Float.parseFloat(stringChanceUp);
                float doubleChanceDown = Float.parseFloat(stringChanceDown);
                float doubleChanceLeft = Float.parseFloat(stringChanceLeft);
                float doubleChanceRight = Float.parseFloat(stringChanceRight);
                float doubleChanceStop = Float.parseFloat(stringChanceStop);


               // double doubleChanceUp = Double.parseDouble(stringChanceUp);
               // double doubleChanceDown = Double.parseDouble(stringChanceDown);
                //double doubleChanceLeft = Double.parseDouble(stringChanceLeft);
                //double doubleChanceRight = Double.parseDouble(stringChanceRight);
               // double doubleChanceStop = Double.parseDouble(stringChanceStop);
            double res = (doubleChanceUp + doubleChanceDown + doubleChanceLeft + doubleChanceRight + doubleChanceStop);
            double newDouble = new BigDecimal(res).setScale(3, RoundingMode.HALF_UP).doubleValue();
            System.out.println(newDouble);
            if ((newDouble)==1){
                SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>(){

                    public int stop = 0;
                    public int up = 0;
                    public int down = 0;
                    public int left = 0;
                    public int right = 0;

                    @Override
                    protected Void doInBackground() throws Exception {

                        float toStop =  0 + doubleChanceStop;
                        float toUp =  toStop + doubleChanceUp;
                        float toDown = toUp + doubleChanceDown;
                        float toLeft = toDown + doubleChanceLeft;
                        float toRight = toLeft + doubleChanceRight;

                        //System.out.println("toStop: " +"[0] "+ toStop);
                        //System.out.println("toUp: " + "["+toStop +"] " + "[" + toUp +"]");
                        //System.out.println("toDown: " + "["+toUp +"] " + "[" + toDown +"]");
                        //System.out.println("toLeft: " + "["+toDown +"] " + "[" + toLeft +"]");
                        //System.out.println("toRight: " + "["+toLeft +"] " + "[" + toRight +"]");


                        int max = Integer.parseInt(counter.getText());
                        progressBar1.setMinimum(0);
                        progressBar1.setMaximum(max);
                       // for (int i = 0; i < max; i++) {
                        //    progressBar1.setValue(i+1);
                        //}

                        for (int i = 0; i < max; i++) {
                            double random = Math.random();
                            System.out.println(random);

                            if (random >=0 && random<toStop){
                                stop++;
                            }else if (random<toUp){
                                up++;
                            }else if(random<toDown){
                                down++;
                            }else if(random<toLeft){
                                left++;
                            }else if (random<toRight)
                                right++;
                            progressBar1.setValue(i+1);
                        }

                        System.out.println("stop: "+ stop +
                                            ";  up: " + up +
                                            ";  down: " + down +
                                            ";  left: " + left +
                                            ";  right: " + right);


                        return null;
                    }
                };
                swingWorker.execute();
            }else{
               JOptionPane.showMessageDialog(points,"Сумма вероятностей должна ровняться единице!","Warning",JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private class LeftPanelFieldsAdapters extends KeyAdapter {

    }
}
