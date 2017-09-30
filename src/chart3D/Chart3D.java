package chart3D;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.demo.swing.DemoPanel;
import com.orsoncharts.demo.swing.ExitOnClose;
import com.orsoncharts.demo.swing.OrsonChartsDemo;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;

/**
 * A demo of a 3D bar chart.
 */
@SuppressWarnings("serial")
    public class Chart3D extends JPanel {

    public Chart3D(int x, int y, int[][] xy) {
        add(createDemoPanel(x,y,xy));
    }

    /**
     * Returns a panel containing the content for the demo.  This method is
     * used across all the individual demo applications to allow aggregation
     * into a single "umbrella" demo (OrsonChartsDemo).
     *
     * @return A panel containing the content for the demo.
     */
    public static JPanel createDemoPanel(int x, int y, int[][] xy) {
        DemoPanel content = new DemoPanel(new BorderLayout());
        content.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        CategoryDataset3D dataset = MyChart3D.createDataset(x,y,xy);
        com.orsoncharts.Chart3D chart = MyChart3D.createChart(dataset);
        Chart3DPanel chartPanel = new Chart3DPanel(chart);
        content.setChartPanel(chartPanel);
        content.add(new DisplayPanel3D(chartPanel));
        chartPanel.zoomToFit(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        return content;
    }

    /**
     * Starting point for the app.
     *
     * @param args  command line arguments (ignored).
     */

}