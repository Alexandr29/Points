package chart3D;


import java.awt.*;
import javax.swing.JPanel;

import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.demo.swing.DemoPanel;

import com.orsoncharts.graphics3d.swing.DisplayPanel3D;

/**
 * A demo of a 3D bar chart.
 */
@SuppressWarnings("serial")
    public class Chart3D extends JPanel {

    public Chart3D() {

    }
    public void startChart3D(int x, int y, int[][] xy, int centralPanelWidth, int centralPanelHeight){
        add(createDemoPanel(x,y,xy,centralPanelWidth,centralPanelHeight));
    }

    public static JPanel createDemoPanel(int x, int y, int[][] xy, int centralPanelWidth, int centralPanelHeight) {
        DemoPanel content = new DemoPanel(new BorderLayout());
        content.setPreferredSize(new Dimension(centralPanelWidth-700,centralPanelHeight ));
        CategoryDataset3D dataset = MyChart3D.createDataset(x,y,xy);
        com.orsoncharts.Chart3D chart = MyChart3D.createChart(dataset);
        Chart3DPanel chartPanel = new Chart3DPanel(chart);
        content.setChartPanel(chartPanel);
        content.add(new DisplayPanel3D(chartPanel));
        chartPanel.zoomToFit(new Dimension(centralPanelWidth ,centralPanelHeight ));
        return content;
    }

}