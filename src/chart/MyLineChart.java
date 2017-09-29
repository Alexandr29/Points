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
        setLayout(new FlowLayout());
    }

    public void createChart(String applicationTitle , String chartTitle, int a[], int b[], int c[], int d[]){
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Years","Number of Schools",
                createDataset(a,b,c,d),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        add(chartPanel);
        setVisible(true);
    }
    private DefaultCategoryDataset createDataset(int a[], int b[],int c[], int d[] ) {
        int array1[] = a;
        int array2[] = b;
        String[] arr2 = new String[]{"Вышло вверх","Вышло вниз"};
        final String speed = "Вверх/вниз";
        String[] textString = new String[a.length];
        for (int i = 0; i < textString.length; i++) {
            textString[i] = String.valueOf(i);
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        Number number = array1[0];
        String s1 = arr2[0];
        String s2 = arr2[1];
        for (int i = 0; i <a.length ; i++) {
            System.out.println(array1[i]);
            dataset.addValue(array1[i],s1,textString[i]);
            dataset.addValue(array2[i],s2,textString[i]);
        }


        return dataset;
    }
}
