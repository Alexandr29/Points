package chart3D;

import java.awt.BasicStroke;
import java.awt.Color;

import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.axis.NumberAxis3D;
import com.orsoncharts.axis.StandardCategoryAxis3D;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.label.StandardCategoryItemLabelGenerator;
import com.orsoncharts.legend.LegendAnchor;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.util.Orientation;
import com.orsonpdf.PDFHints;
import controller.MainFrameController;

/**
 * 3D bar chart configuration for demo applications.
 */
public class MyChart3D{


    /**
     * Creates a bar chart with the supplied dataset.
     *
     * @param dataset  the dataset.
     *
     * @return A bar chart.
     */
    public static com.orsoncharts.Chart3D createChart(CategoryDataset3D dataset) {
        com.orsoncharts.Chart3D chart = Chart3DFactory.createBarChart(
                "",".", dataset,
                null, null, "кол-во");

        // we use the following hint to render text as vector graphics
        // rather than text when exporting to PDF...otherwise the degree
        // symbol on the axis title does not display correctly.
        chart.getRenderingHints().put(PDFHints.KEY_DRAW_STRING_TYPE,
                PDFHints.VALUE_DRAW_STRING_TYPE_VECTOR);
        chart.setLegendPosition(LegendAnchor.BOTTOM_RIGHT,
                Orientation.VERTICAL);
        chart.getViewPoint().panLeftRight(-Math.PI / 60);
        CategoryPlot3D plot = (CategoryPlot3D) chart.getPlot();
        StandardCategoryAxis3D xAxis = (StandardCategoryAxis3D)
                plot.getColumnAxis();
        NumberAxis3D yAxis = (NumberAxis3D) plot.getValueAxis();
        StandardCategoryAxis3D zAxis = (StandardCategoryAxis3D)
                plot.getRowAxis();
        plot.setGridlineStrokeForValues(new BasicStroke(0.0f));
        xAxis.setLineColor(new Color(0, 0, 0, 0));
        yAxis.setLineColor(new Color(0, 0, 0, 0));
        zAxis.setLineColor(new Color(0, 0, 0, 0));
        plot.getRenderer().setColors(Colors.createPastelColors());
        plot.setToolTipGenerator(new StandardCategoryItemLabelGenerator(
                "%2$s (%3$s) = %4$s degrees"));
        return chart;
    }

    public static CategoryDataset3D createDataset(int x, int y, int[][] xy) {
        StandardCategoryDataset3D dataset = new StandardCategoryDataset3D();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                dataset.setValue(xy[i][j],"точки",i+1,j+1);
            }
        }

        return dataset;
    }

}
