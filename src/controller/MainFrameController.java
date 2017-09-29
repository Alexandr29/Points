package controller;

import chart.MyLineChart;
import view.Points;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class MainFrameController {
    private MyLineChart myLineChart;
    private Points points;
    private JFormattedTextField chanceUp;
    private JFormattedTextField chanceDown;
    private JFormattedTextField chanceLeft;
    private JFormattedTextField chanceRight;
    private JFormattedTextField chanceStop;
    private JProgressBar progressBar1;
    private JFormattedTextField counter;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel downPanel;
    private JFormattedTextField widthField;
    private JFormattedTextField heightField;
    private JFormattedTextField startXField;
    private JFormattedTextField startYField;
    private JButton startButton;
    private boolean metka;
    private int buttonPressed = 0;

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
        myLineChart = new MyLineChart();
        mainPanel = points.getMainPanel();
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

    private class LeftPanelFieldsAdapters extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {

            char input = e.getKeyChar();
            if ((input < '0' || input > '9') && input != '\b' && input != '.') {
                e.consume();
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
                int intCounter = Integer.parseInt(stringCounter);

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
                        int width = Integer.parseInt(widthField.getText());
                        int height = Integer.parseInt(heightField.getText());

                        int xPoint = Integer.parseInt(startXField.getText());
                        int yPoint = Integer.parseInt(startYField.getText());


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

                        int upOut=0;
                        int downOut=0;
                        int leftOut=0;
                        int rightOut=0;

                        int arrTopOut[] = new int[width];
                        int arrDownOut[] = new int[width];
                        int arrLeftOut[] = new int[height];
                        int arrRightOut[] = new int[height];

                        for (int i = 0; i < max; i++) {

                            Point point = new Point(width,height,xPoint,yPoint);
                            metka = true;


                             while (metka == true){
                                 double random = Math.random();

                                 if (random >=0 && random<toStop){
                                     stop++;
                                 }else if (random<toUp){
                                     point.moveUp();
                                 }else if(random<toDown){
                                     point.moveDown();
                                 }else if(random<toLeft){
                                     point.moveLeft();
                                 }else if (random<toRight)
                                     point.moveRight();
                                 progressBar1.setValue(i+1);

                             }
                            if (point.upBorderCoord  == 1){
                                upOut++;
                                arrTopOut[point.xPoint]++;
                            }else if (point.downBorderCoord == 1){
                                downOut++;
                                arrDownOut[point.xPoint]++;
                            }else if (point.leftBorderCoord == 1){
                                leftOut++;
                                arrLeftOut[point.yPoint]++;
                            }else if(point.rightBorderCoord == 1){
                                rightOut++;
                                arrRightOut[point.yPoint]++;
                            }

                            for (int j = 0; j < width; j++) {
                                System.out.print("arrTopOut[" +j +"]" + " " + arrTopOut[j]+ "; ");
                            }
                            System.out.println();
                            for (int j = 0; j < width; j++) {
                                System.out.print("arrDownOut[" +j +"]" + " " + arrDownOut[j]+ "; ");
                            }
                            System.out.println();
                            for (int j = 0; j < height; j++) {
                                System.out.print("arrLeftOut[" +j +"]" + " " + arrLeftOut[j]+ "; ");
                            }
                            System.out.println();
                            for (int j = 0; j < height; j++) {
                                System.out.print("arrRightOut[" +j +"]" + " " + arrRightOut[j]+ "; ");
                            }
                            System.out.println();


                        }
                        if (buttonPressed>0){
                            myLineChart.removeAll();
                        }
                        System.out.println("Вверх: " + upOut+ "; Вниз: " + downOut + "; Влево: " + leftOut + "; Вправо: " + rightOut + ";");

                        myLineChart.createChart("new","title",arrTopOut,arrDownOut,arrLeftOut,arrRightOut);
                        mainPanel.add(myLineChart, BorderLayout.CENTER);
                        mainPanel.revalidate();
                        buttonPressed++;
                        return null;

                    }
                };
                swingWorker.execute();
            }else{
               JOptionPane.showMessageDialog(points,"Сумма вероятностей должна ровняться единице!","Warning",JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private class Point{

        private int width;
        private int height;

        private int xPoint;
        private int yPoint;

        private int upBorderCoord;
        private int downBorderCoord;
        private int leftBorderCoord;
        private int rightBorderCoord;

        public Point(int width, int height, int xPoint, int yPoint) {
            this.width = width;
            this.height = height;
            this.xPoint = xPoint;
            this.yPoint = yPoint;
        }

        public void moveUp(){
           yPoint++;
           System.out.println("Up");
           if (yPoint == height){
               upBorderCoord = 1;
               System.out.println("Вышло вверх");
               System.out.println("x:  " + xPoint + ".  y:  " + yPoint);
               metka = false;
           }
       }
        public void moveDown(){
           yPoint--;
           System.out.println("Down");
           if (yPoint < 0){
               downBorderCoord = 1;
               System.out.println("Вышло вниз");
               System.out.println("x:  " + xPoint + ".  y:  " + yPoint);
               metka = false;
           }
       }
        public void moveLeft(){
            xPoint--;
            System.out.println("Left");
            if (xPoint < 0){
                leftBorderCoord = 1;
                System.out.println("Вышло влево");
                System.out.println("x:  " + xPoint + ".  y:  " + yPoint);
                metka = false;
            }
        }
        public void moveRight() {
            xPoint++;
            System.out.println("Right");
            if (xPoint == width) {
                rightBorderCoord = 1;
                System.out.println("Вышло вправо");
                System.out.println("x:  " + xPoint + ".  y:  " + yPoint);
                metka = false;
            }
        }


    }


}
