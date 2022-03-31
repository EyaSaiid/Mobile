/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.compagny.gui;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.OffreTravail;
import com.mycompany.services.OffreTravailService;
import java.util.ArrayList;
/**
 *
 * @author SAID EYA
 */
public class Front_StatOffreTravail extends BaseForm {

    public Front_StatOffreTravail(Resources res, Form previous) {

        super.addSideMenu(res);
        setTitle("Statistique Entreprise");
        setLayout(BoxLayout.y());
        Label lretour = new Label(" ");
        lretour.setUIID("retour");
        Style modstyle = new Style(lretour.getUnselectedStyle());
        modstyle.setFgColor(0x008000);

        FontImage retourimage = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, modstyle);
        lretour.setIcon(retourimage);
        lretour.setTextPosition(RIGHT);

        add(lretour);
        lretour.addPointerPressedListener(l -> retour(res));

        // Generate the values
        double[] values = new double[]{12, 14, 11, 10, 19};
        ArrayList<OffreTravail> categories;
        categories = OffreTravailService.getInstance().getAllOffreTravails();

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.BLACK, ColorUtil.CYAN};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(20);
        renderer.setDisplayValues(true);
        renderer.setLabelsColor(ColorUtil.BLACK);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
        r.setGradientStart(0, ColorUtil.BLUE);
        r.setGradientStop(0, ColorUtil.GREEN);
        r.setHighlighted(true);

        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Entreprise budget", categories), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

        add(c);

    }

    private void retour(Resources res) {

        new HomeForm().show();
    }

    /**
     * Creates a renderer for the specified colors.
     */
    private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(50);
        renderer.setLegendTextSize(50);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    /**
     * Builds a category series using the provided values.
     *
     * @param titles the series titles
     * @param values the values
     * @return the category series
     */
    protected CategorySeries buildCategoryDataset(String title, ArrayList<OffreTravail> categories) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        for (OffreTravail obj : categories) {
            series.add(obj.getTitre() , obj.getId_OffreTravail());
        }

        return series;
    }
}