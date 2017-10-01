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
                "Координаты зависших точек",".", dataset,
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

    /**
     * Creates a sample dataset (hard-coded for the purpose of keeping the
     * demo self-contained - in practice you would normally read your data
     * from a file, database or other source).
     *
     * @return A sample dataset.
     */
    public static CategoryDataset3D createDataset(int x, int y, int[][] xy) {
        StandardCategoryDataset3D dataset = new StandardCategoryDataset3D();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                dataset.setValue(xy[i][j],"serial",i+1,j+1);
            }
        }

        /*  for (int i = 0; i < x; i++) {

            //DefaultKeyedValues<String, Integer> s = new DefaultKeyedValues<>();
            //System.out.print(arr1[i] + ";   ");
            for (int j = 0; j < y; j++) {
                if (arr2[j]!=0){
                    dataset.addValue(arr1[i],"series"+ i ,j+"строка (i)",j+"столбик(j)");
                }else {
                    dataset.addValue(0,"series"+ i ,i+"строка (i)",j+"столбик(j)");
                }

                //s.put(String.valueOf(i), arr1[i]);
                //s.put(String.valueOf(arr2[j],j);
                //dataset.addSeriesAsRow(j, s);
            }
        }*/




        /*DefaultKeyedValues<String, Integer> s3 = new DefaultKeyedValues<>();


        s3.put("Jan", 77);
        s3.put("Feb", 7);
        s3.put("Mar", 10);
        s3.put("Apr", 13);
        s3.put("May", 17);
        s3.put("Jun", 20);
        s3.put("Jul", 22);
        s3.put("Aug", 21);
        s3.put("Sep", 19);
        s3.put("Oct", 15);
        s3.put("Nov", 10);
        s3.put("Dec", 8);
        dataset.addSeriesAsRow("London", s3);


        DefaultKeyedValues<String, Integer> s1 = new DefaultKeyedValues<>();
        s1.put("Jan", 3);
        s1.put("Feb", 5);
        s1.put("Mar", 9);
        s1.put("Apr", 14);
        s1.put("May", 18);
        s1.put("Jun", 22);
        s1.put("Jul", 25);
        s1.put("Aug", 24);
        s1.put("Sep", 20);
        s1.put("Oct", 14);
        s1.put("Nov", 8);
        s1.put("Dec", 4);
        dataset.addSeriesAsRow("Geneva", s1);


        DefaultKeyedValues<String, Integer> s2 = new DefaultKeyedValues<>();
        s2.put("Jan", 9);
        s2.put("Feb", 11);
        s2.put("Mar", 13);
        s2.put("Apr", 16);
        s2.put("May", 20);
        s2.put("Jun", 23);
        s2.put("Jul", 26);
        s2.put("Aug", 26);
        s2.put("Sep", 24);
        s2.put("Oct", 19);
        s2.put("Nov", 13);
        s2.put("Dec", 9);
        dataset.addSeriesAsRow("Bergerac", s2);

        DefaultKeyedValues<String, Integer> s4 = new DefaultKeyedValues<>();
        s4.put("Jan", 22);
        s4.put("Feb", 22);
        s4.put("Mar", 20);
        s4.put("Apr", 17);
        s4.put("May", 14);
        s4.put("Jun", 11);
        s4.put("Jul", 11);
        s4.put("Aug", 12);
        s4.put("Sep", 14);
        s4.put("Oct", 17);
        s4.put("Nov", 19);
        s4.put("Dec", 21);
        dataset.addSeriesAsRow("Christchurch", s4);

        DefaultKeyedValues<String, Integer> s5 = new DefaultKeyedValues<>();
        s5.put("Jan", 20);
        s5.put("Feb", 20);
        s5.put("Mar", 19);
        s5.put("Apr", 17);
        s5.put("May", 14);
        s5.put("Jun", 12);
        s5.put("Jul", 11);
        s5.put("Aug", 12);
        s5.put("Sep", 13);
        s5.put("Oct", 15);
        s5.put("Nov", 17);
        s5.put("Dec", 19);
        dataset.addSeriesAsRow("Wellington", s5);*/

        return dataset;
    }

}