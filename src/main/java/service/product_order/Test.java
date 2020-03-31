/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.product_order;

import dao.bill.BillDao;
import dao.bill.BillDaoImpl;
import entities.BillToPrint;
import entities.ProductOrder;
import entities.Table;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import service.table.TableService;
import service.table.TableServiceImpl;

/**
 *
 * @author PC
 */
public class Test {

    public static void main(String[] args) {
//        Calendar c = Calendar.getInstance();
//        for (int i = 0; i < 7; i++) {
//            c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + i);
//            int day = c.get(Calendar.DAY_OF_MONTH);
//            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
//            int month = c.get(Calendar.MONTH) + 1;
//            int year = c.get(Calendar.YEAR);
//
//            System.out.println(day + "/" + (month) + "/" + year +"---"+dayOfWeek);
//        }
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    public static JFreeChart createChart() {
        Map<String, Float> mmapp = mmap();
        JFreeChart barChart;
        barChart = ChartFactory.createBarChart(
                "",
                "Ngày", "Tổng thu",
                createDataset(mmapp), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private static Map<String, Float> mmap() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Float> map = new LinkedHashMap<>();
        BillDao billDao = new BillDaoImpl();
        Calendar c1 = Calendar.getInstance();
        String dayy = "";
        for (int i = 0; i < c1.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            c1.set(Calendar.DAY_OF_MONTH, i + 1);
            dayy = format.format(c1.getTime());
            map.put(dayy, billDao.getSumOfDay(dayy));
        }

        for (Map.Entry<String, Float> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        return map;
    }

    private static CategoryDataset createDataset(Map<String, Float> mmap) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.addValue(68000000, "Số người", "1990");
//        dataset.addValue(80000000, "Số người", "2000");
//        dataset.addValue(88000000, "Số người", "2010");
//        dataset.addValue(95000000, "Số người", "2020");

        for (Map.Entry<String, Float> entry : mmap.entrySet()) {
            dataset.addValue(entry.getValue(), "Tổng thu", entry.getKey());
        }
        return dataset;
    }

}
