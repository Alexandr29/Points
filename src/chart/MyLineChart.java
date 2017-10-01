package chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class MyLineChart extends JPanel {
    public MyLineChart() {
        setLayout(new BorderLayout());
    }

    public void createChart(String chartTitle, int a[], int b[], int c[], int d[]){
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Ось Х","кол-во вышедших",
                createDataset(a,b),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        add(chartPanel,BorderLayout.CENTER);
        setVisible(true);

        JFreeChart lineChart2 = ChartFactory.createLineChart(
                chartTitle,
                "Ось Y","кол-во вышедших",
                createDataset2(c,d),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel2 = new ChartPanel( lineChart2 );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        add(chartPanel2,BorderLayout.SOUTH);
        setVisible(true);
    }
    private DefaultCategoryDataset createDataset(int a[], int b[] ) {
        String[] arr2 = new String[]{"Вышло вверх","Вышло вниз"};
        String[] textString = new String[a.length];
        for (int i = 0; i < textString.length; i++) {
            textString[i] = String.valueOf(i);
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        String s1 = arr2[0];
        String s2 = arr2[1];
        for (int i = 0; i <a.length ; i++) {
            //System.out.println(array1[i]);
            dataset.addValue(a[i],s1,textString[i]);
            dataset.addValue(b[i],s2,textString[i]);
        }


        return dataset;
    }
    private DefaultCategoryDataset createDataset2(int c[], int d[] ) {
        String[] arr2 = new String[]{"Вышло влево","Вышло вправо"};
        String[] textString = new String[c.length];
        for (int i = 0; i < textString.length; i++) {
            textString[i] = String.valueOf(i);
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        String s1 = arr2[0];
        String s2 = arr2[1];
        for (int i = 0; i <c.length ; i++) {
            //System.out.println(c[i]);
            dataset.addValue(c[i],s1,textString[i]);
            dataset.addValue(d[i],s2,textString[i]);
        }


        return dataset;
    }
}
