package controller;

import chart.MyLineChart;
import chart3D.Chart3D;
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
    private Chart3D chart3D;
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
    private JPanel centralPanel;
    private JPanel panel3D;
    private JPanel panelInfo;
    private JButton pauseButton;
    private JButton stopButton;
    private SwingWorker<Void, Void> swingWorker;
    int pausePlay = 3;
    private volatile boolean isPaused;
    private JLabel upLabel;
    private JLabel downLabel;
    private JLabel leftLabel;
    private JLabel rightLabel;
    private JLabel stopLabel;
    private int upOut = 0;
    private int downOut = 0;
    private int leftOut = 0;
    private int rightOut = 0;
    private int stopOut = 0;

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
        pauseButton.addActionListener(new PauseListener());
        stopButton.addActionListener(new StopListener());
    }

    private void initComponents() {
        isPaused = false;
        chart3D = new Chart3D();
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
        centralPanel = points.getCentralPanel();
        panelInfo = points.getPanelInfo();
        pauseButton = points.getPauseButton();
        pauseButton.setEnabled(false);
        stopButton = points.getStopButton();
        stopButton.setEnabled(false);
        upLabel = points.getUpLabel();
        downLabel = points.getDownLabel();
        leftLabel = points.getLeftLabel();
        rightLabel = points.getRightLabel();
        stopLabel = points.getStopLabel();




    }

    public boolean isPaused() {
        return isPaused;
    }

    public void testing(){
        chanceUp.setText(String.valueOf(0.24));
        chanceDown.setText(String.valueOf(0.24));
        chanceLeft.setText(String.valueOf(0.24));
        chanceRight.setText(String.valueOf(0.24));
        chanceStop.setText(String.valueOf(0.04));
        widthField.setText(String.valueOf(11));
        heightField.setText(String.valueOf(11));
        startXField.setText(String.valueOf(5));
        startYField.setText(String.valueOf(5));
        counter.setText(String.valueOf(10_000_000));
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
            testing();
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
                   /*if (newDouble == 1){
                       startButton.setEnabled(true);
                   }*/
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


            double res = (doubleChanceUp + doubleChanceDown + doubleChanceLeft + doubleChanceRight + doubleChanceStop);
            double newDouble = new BigDecimal(res).setScale(3, RoundingMode.HALF_UP).doubleValue();
            System.out.println(newDouble);
            if ((newDouble)==1){
                startButton.setEnabled(false);
                pauseButton.setEnabled(true);
                stopButton.setEnabled(true);
                swingWorker = new SwingWorker<Void, Void>(){

                    @Override
                    protected Void doInBackground() throws Exception {
                        isPaused = false;

                         int width = Integer.parseInt(widthField.getText());
                         int height = Integer.parseInt(heightField.getText());

                         int xPoint = Integer.parseInt(startXField.getText());
                         int yPoint = Integer.parseInt(startYField.getText());


                         float toStop =  0 + doubleChanceStop;
                         float toUp =  toStop + doubleChanceUp;
                         float toDown = toUp + doubleChanceDown;
                         float toLeft = toDown + doubleChanceLeft;
                         float toRight = toLeft + doubleChanceRight;



                         int max = Integer.parseInt(counter.getText());
                         progressBar1.setMinimum(0);
                         progressBar1.setMaximum(max);

                         int arrTopOut[] = new int[width];
                         int arrDownOut[] = new int[width];
                         int arrLeftOut[] = new int[height];
                         int arrRightOut[] = new int[height];

                         int stopX[] = new int[width];
                         int stopY[] = new int[height];

                         int xy[][] = new int[width][height];

                         for (int i = 0; i < max; i++) {

                             metka = true;
                             Point point = new Point(width,height,xPoint,yPoint);


                             if(!isPaused){
                                 while (metka == true){

                                     double random = Math.random();

                                     if (random >=0 && random<toStop){
                                         stopOut++;
                                         stopX[point.toStopX]++;
                                         stopY[point.toStopY]++;
                                         xy[point.toStopX][point.toStopY]++;
                                         break;
                                     }else if (random<toUp){
                                         point.moveUp();
                                     }else if(random<toDown){
                                         point.moveDown();
                                     }else if(random<toLeft){
                                         point.moveLeft();
                                     }else if (random<toRight)
                                         point.moveRight();
                                     progressBar1.setValue(i+1);


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
                                 }
                             }else {
                            metka = false;
                            showall("title",arrTopOut,arrDownOut,arrLeftOut,arrRightOut,width,height,xy);
                            while (isPaused()){
                                Thread.sleep(100);
                            }

                        }
                         }showall("title",arrTopOut,arrDownOut,arrLeftOut,arrRightOut,width,height,xy);
                        pauseButton.setEnabled(false);
                        return null;
                    }
                };
                swingWorker.execute();
            }else{
               JOptionPane.showMessageDialog(points,"Сумма вероятностей должна ровняться единице!","Warning",JOptionPane.ERROR_MESSAGE);
               startButton.setEnabled(true);
               pauseButton.setEnabled(false);
            }

        }
        public void showall(String s, int a[], int b[], int c[], int d[],int width, int height, int[][]xy){
            if (buttonPressed>0){
                myLineChart.removeAll();
                chart3D.removeAll();
            }
            //System.out.println("Вверх: " + upOut+ "; Вниз: " + downOut + "; Влево: " + leftOut + "; Вправо: " + rightOut + ";");

            myLineChart.createChart(s,a,b,c,d);
            centralPanel.add(panelInfo,BorderLayout.SOUTH);

            //centralPanel.revalidate();
            centralPanel.repaint();
            int centralPanelWidth = centralPanel.getWidth();
            int centralPanelHeight = centralPanel.getHeight();

            chart3D.startChart3D(width,height,xy,centralPanelWidth,centralPanelHeight);
            centralPanel.add(chart3D,BorderLayout.CENTER);

            centralPanel.add(myLineChart,BorderLayout.WEST);
            centralPanel.setBackground(Color.green);
            mainPanel.add(centralPanel,BorderLayout.CENTER);
            mainPanel.revalidate();
            buttonPressed++;

            upLabel.setText(String.valueOf(upOut) + " Вышло вверз;  ");
            downLabel.setText(String.valueOf(downOut)+ " Вышло вниз;    ");
            leftLabel.setText(String.valueOf(leftOut)+ " Вышло влево;   ");
            rightLabel.setText(String.valueOf(rightOut)+ " Вышло вправо;    ");
            stopLabel.setText(String.valueOf(stopOut)+" Остановилось;    ");
        }
    }

    private class Point{

        private int width;
        private int height;

        private int xPoint;
        private int yPoint;

        private int toStopX;
        private int toStopY;

        private int upBorderCoord;
        private int downBorderCoord;
        private int leftBorderCoord;
        private int rightBorderCoord;

        public Point(int width, int height, int xPoint, int yPoint) {
            this.width = width;
            this.height = height;
            this.xPoint = xPoint;
            this.yPoint = yPoint;
            toStopX = xPoint;
            toStopY = yPoint;
        }

        public void moveUp(){
           yPoint++;
           toStopY=yPoint;

           //System.out.println("Up");
           if (yPoint == height){
               upBorderCoord = 1;
               //System.out.println("Вышло вверх");
               //System.out.println("x:  " + xPoint + ".  y:  " + yPoint);
               metka = false;
           }
       }
        public void moveDown(){
           yPoint--;
           toStopY=yPoint;
           //System.out.println("Down");
           if (yPoint < 0){
               downBorderCoord = 1;
               //System.out.println("Вышло вниз");
               //System.out.println("x:  " + xPoint + ".  y:  " + yPoint);
               metka = false;
           }
       }
        public void moveLeft(){
            xPoint--;
            toStopX = xPoint;
            //System.out.println("Left");
            if (xPoint < 0){
                leftBorderCoord = 1;
                //System.out.println("Вышло влево");
                //System.out.println("x:  " + xPoint + ".  y:  " + yPoint);
                metka = false;
            }
        }
        public void moveRight() {
            xPoint++;
            toStopX = xPoint;
            //System.out.println("Right");
            if (xPoint == width) {
                rightBorderCoord = 1;
               // System.out.println("Вышло вправо");
                //System.out.println("x:  " + xPoint + ".  y:  " + yPoint);
                metka = false;
            }
        }


    }


    private class PauseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (pausePlay != 3 & pausePlay%2 == 0){
                pauseButton.setText("Пауза");

                System.out.println(pausePlay);

            }else {
                pauseButton.setText("Продолжить");
            }
            pausePlay++;
            System.out.println(pausePlay);

            if (pauseButton.getText().equals("Пауза")){
                isPaused = false;
            }else {
                isPaused = true;
            }

        }
    }

    private class StopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            stopButton.setEnabled(false);


            chanceUp.setText(String.valueOf(0));
            chanceDown.setText(String.valueOf(0));
            chanceLeft.setText(String.valueOf(0));
            chanceRight.setText(String.valueOf(0));
            chanceStop.setText(String.valueOf(0));
            widthField.setText(String.valueOf(0));
            heightField.setText(String.valueOf(0));
            startXField.setText(String.valueOf(0));
            startYField.setText(String.valueOf(0));
            counter.setText(String.valueOf(0));
            progressBar1.setValue(0);
            upLabel.setText("");
            downLabel.setText("");
            leftLabel.setText("");
            rightLabel.setText("");
            stopLabel.setText("");

            myLineChart.removeAll();
            chart3D.removeAll();
            mainPanel.revalidate();
            pausePlay++;

            startButton.setEnabled(true);
            pauseButton.setEnabled(false);
            pauseButton.setText("Пауза");
        }
    }
}
