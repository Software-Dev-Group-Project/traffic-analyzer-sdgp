/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcApi;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author bar77
 */
public class Panel4 extends javax.swing.JFrame {
    
    
    
    public Panel4() {
        initComponents();
        ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
        BarRenderer.setDefaultBarPainter(new StandardBarPainter());
        CategoryDataset dataset = openDataset();
        Font font = new Font("Dialog", Font.BOLD, 18);
        Font font2 = new Font("Dialog", Font.PLAIN, 12);
        Font font3 = new Font("Dialog", Font.BOLD, 14);
        
        JFreeChart panel4Chart = ChartFactory.createBarChart("Vehicles Count based on Direction", "Direction", "Number of Vehicles", dataset, PlotOrientation.VERTICAL, true, true, false);
        panel4Chart.setBackgroundPaint(new Color(141,128,111));
        panel4Chart.removeLegend();
        
        CategoryPlot plot = panel4Chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        plot.setBackgroundPaint(new Color(42,50,46));
        plot.getDomainAxis().setLabelFont(font);
        plot.getRangeAxis().setLabelFont(font);
        CategoryAxis xAxis = plot.getDomainAxis();  
        ValueAxis yAxis = plot.getRangeAxis();
        xAxis.setTickLabelFont(font3);
        yAxis.setTickLabelFont(font2);
        
        ChartPanel chartPanel = new ChartPanel(panel4Chart);
        chartPanel.setSize(800, 527);
        chartPanelWindow.removeAll();
        chartPanelWindow.add(chartPanel);
        chartPanelWindow.updateUI();
        
        BarRenderer bar = new BarRenderer();
        bar.setSeriesPaint(0,new Color(216,203,187));
        bar.setShadowVisible(false);
        plot.setRenderer(bar);
              
    }

    private CategoryDataset openDataset(){
    
        try {
            
            String sqlQuery = "SELECT direction_of_travel, SUM(pedal_cycles + all_motor_vehicles) FROM CountEntry GROUP BY direction_of_travel";
            
            JDBCCategoryDataset jdbc = new JDBCCategoryDataset(jdbcApi.trafficDataLogic.ConnectTrafficDB.getConnection(), sqlQuery);
            return jdbc;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        b1 = new javax.swing.JPanel();
        bl1 = new javax.swing.JLabel();
        b2 = new javax.swing.JPanel();
        bl2 = new javax.swing.JLabel();
        b3 = new javax.swing.JPanel();
        bl3 = new javax.swing.JLabel();
        b4 = new javax.swing.JPanel();
        bl4 = new javax.swing.JLabel();
        settings = new javax.swing.JPanel();
        bl5 = new javax.swing.JLabel();
        Main = new javax.swing.JPanel();
        pan1 = new javax.swing.JPanel();
        chartPanelWindow = new javax.swing.JPanel();
        p4Options = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(11, 58, 83));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Header.setBackground(new java.awt.Color(11, 58, 83));
        Header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        b1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b1.setToolTipText("Panel 1");
        b1.setAlignmentX(0.0F);
        b1.setAlignmentY(0.0F);
        b1.setPreferredSize(new java.awt.Dimension(223, 50));

        bl1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bl1.setText("PANEL 1");
        bl1.setToolTipText("Panel 1");
        bl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bl1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bl1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bl1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout b1Layout = new javax.swing.GroupLayout(b1);
        b1.setLayout(b1Layout);
        b1Layout.setHorizontalGroup(
            b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );
        b1Layout.setVerticalGroup(
            b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bl1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        b2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b2.setAlignmentX(0.0F);
        b2.setAlignmentY(0.0F);
        b2.setPreferredSize(new java.awt.Dimension(223, 50));

        bl2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bl2.setText("PANEL 2");
        bl2.setToolTipText("Panel 2");
        bl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bl2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bl2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bl2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout b2Layout = new javax.swing.GroupLayout(b2);
        b2.setLayout(b2Layout);
        b2Layout.setHorizontalGroup(
            b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bl2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );
        b2Layout.setVerticalGroup(
            b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bl2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        b3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b3.setAlignmentX(0.0F);
        b3.setAlignmentY(0.0F);
        b3.setPreferredSize(new java.awt.Dimension(223, 50));

        bl3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bl3.setText("PANEL 3");
        bl3.setToolTipText("Panel 3");
        bl3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bl3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bl3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bl3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout b3Layout = new javax.swing.GroupLayout(b3);
        b3.setLayout(b3Layout);
        b3Layout.setHorizontalGroup(
            b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bl3, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );
        b3Layout.setVerticalGroup(
            b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bl3, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        b4.setBackground(new java.awt.Color(102, 102, 102));
        b4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b4.setAlignmentX(0.0F);
        b4.setAlignmentY(0.0F);
        b4.setPreferredSize(new java.awt.Dimension(223, 50));

        bl4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bl4.setForeground(new java.awt.Color(240, 240, 240));
        bl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bl4.setText("PANEL 4");
        bl4.setToolTipText("Panel 4");

        javax.swing.GroupLayout b4Layout = new javax.swing.GroupLayout(b4);
        b4.setLayout(b4Layout);
        b4Layout.setHorizontalGroup(
            b4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bl4, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );
        b4Layout.setVerticalGroup(
            b4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bl4, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        settings.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        settings.setAlignmentX(0.0F);
        settings.setAlignmentY(0.0F);
        settings.setPreferredSize(new java.awt.Dimension(223, 50));

        bl5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bl5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bl5.setText("MAIN MENU");
        bl5.setToolTipText("Settings");
        bl5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bl5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bl5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bl5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout settingsLayout = new javax.swing.GroupLayout(settings);
        settings.setLayout(settingsLayout);
        settingsLayout.setHorizontalGroup(
            settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bl5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );
        settingsLayout.setVerticalGroup(
            settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bl5, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settings, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        Main.setBackground(new java.awt.Color(11, 58, 83));

        pan1.setBackground(new java.awt.Color(242, 235, 225));
        pan1.setAutoscrolls(true);

        javax.swing.GroupLayout chartPanelWindowLayout = new javax.swing.GroupLayout(chartPanelWindow);
        chartPanelWindow.setLayout(chartPanelWindowLayout);
        chartPanelWindowLayout.setHorizontalGroup(
            chartPanelWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        chartPanelWindowLayout.setVerticalGroup(
            chartPanelWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        p4Options.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        p4Options.setMaximumRowCount(7);
        p4Options.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Vehicles", "Pedal Cycles", "Motorcycles", "Cars and Taxis", "Buses and Coaches", "Large Goods Vehicles", "Heavy Goods Vehicles" }));
        p4Options.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p4Options.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                p4OptionsItemStateChanged(evt);
            }
        });

        jButton1.setText("Open in a New Window");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pan1Layout = new javax.swing.GroupLayout(pan1);
        pan1.setLayout(pan1Layout);
        pan1Layout.setHorizontalGroup(
            pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartPanelWindow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(p4Options, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(97, 97, 97))
        );
        pan1Layout.setVerticalGroup(
            pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(p4Options, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
            .addGroup(pan1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartPanelWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdbcApi/LATA_LOGO_XS.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(logo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logo)
                .addGap(13, 13, 13)
                .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl1MouseClicked
        new Panel1().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_bl1MouseClicked

    private void bl1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl1MouseEntered
        b1.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_bl1MouseEntered

    private void bl1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl1MouseExited
        b1.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_bl1MouseExited

    private void bl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl2MouseClicked
        new Panel2().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_bl2MouseClicked

    private void bl2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl2MouseEntered
        b2.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_bl2MouseEntered

    private void bl2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl2MouseExited
        b2.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_bl2MouseExited

    private void bl3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl3MouseClicked
        new Panel3().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_bl3MouseClicked

    private void bl3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl3MouseEntered
        b3.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_bl3MouseEntered

    private void bl3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl3MouseExited
        b3.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_bl3MouseExited

    private void bl5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl5MouseEntered
        settings.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_bl5MouseEntered

    private void bl5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl5MouseExited
        settings.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_bl5MouseExited

    private void bl5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl5MouseClicked
        new HomeScreen().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bl5MouseClicked

    private void p4OptionsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_p4OptionsItemStateChanged
        CategoryDataset dataset = createDataset();
        Font font = new Font("Dialog", Font.BOLD, 18);
        Font font2 = new Font("Dialog", Font.PLAIN, 12);
        Font font3 = new Font("Dialog", Font.BOLD, 14);
        JFreeChart panel4Chart = ChartFactory.createBarChart("Number of Cars based on direction", "Direction", "Number of Vehicles", dataset, PlotOrientation.VERTICAL, true, true, false);
        panel4Chart.setBackgroundPaint(new Color(141,128,111));
        panel4Chart.removeLegend();
        
        CategoryPlot plot = panel4Chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        plot.getDomainAxis().setLabelFont(font);
        plot.getRangeAxis().setLabelFont(font);
        plot.setBackgroundPaint(new Color(42,50,46));
        CategoryAxis xAxis = plot.getDomainAxis();  
        ValueAxis yAxis = plot.getRangeAxis();
        xAxis.setTickLabelFont(font3);
        yAxis.setTickLabelFont(font2);
        
        ChartPanel chartPanel = new ChartPanel(panel4Chart);
        chartPanel.setSize(800, 527);
        chartPanelWindow.removeAll();
        chartPanelWindow.add(chartPanel);
        chartPanelWindow.updateUI();
        
        BarRenderer bar = new BarRenderer();
        bar.setSeriesPaint(0,new Color(216,203,187));
        bar.setShadowVisible(false);
        plot.setRenderer(bar);
             
    }

    private CategoryDataset createDataset(){
    
        try {
            String vehicleType = "";
            String optionChosen = (String) p4Options.getSelectedItem();
            
            
            switch(optionChosen){
            
                case "All Vehicles":
                    vehicleType = "pedal_cycles + all_motor_vehicles";
                    break;
                case "Pedal Cycles":
                    vehicleType = "pedal_cycles";
                    break;
                case "Motorcycles":
                    vehicleType = "two_wheeled_motor_vehicles";
                    break;
                case "Cars and Taxis":
                    vehicleType = "cars_and_taxis";
                    break;
                case "Buses and Coaches":
                    vehicleType = "buses_and_coaches";
                    break;
                case "Large Goods Vehicles":
                    vehicleType = "lgvs";
                    break;
                case "Heavy Goods Vehicles":
                    vehicleType = "all_hgvs";
                    break;
            }
            
            String sqlQuery = "SELECT direction_of_travel, SUM(" + vehicleType + ") FROM CountEntry GROUP BY direction_of_travel";
            
            JDBCCategoryDataset jdbc = new JDBCCategoryDataset(jdbcApi.trafficDataLogic.ConnectTrafficDB.getConnection(), sqlQuery);
            return jdbc;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
        
    
    }//GEN-LAST:event_p4OptionsItemStateChanged

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        CategoryDataset dataset = createDataset();
        Font font = new Font("Dialog", Font.BOLD, 18);
        Font font2 = new Font("Dialog", Font.PLAIN, 12);
        Font font3 = new Font("Dialog", Font.BOLD, 14);
        JFreeChart panel4Chart = ChartFactory.createBarChart("Number of Cars based on direction", "Direction", "Number of Vehicles", dataset, PlotOrientation.VERTICAL, true, true, false);
        
        ChartFrame chartFrm = new ChartFrame("Number of Cars based on direction", panel4Chart, true);
        chartFrm.setVisible(true);
        chartFrm.setLocationRelativeTo(null);
        chartFrm.setSize(800, 600);
        
        BarRenderer bar = new BarRenderer();
        bar.setSeriesPaint(0,new Color(216,203,187));
        bar.setShadowVisible(false);
        
        CategoryPlot plot = panel4Chart.getCategoryPlot();
        panel4Chart.setBackgroundPaint(new Color(141,128,111));
        panel4Chart.removeLegend();
        
        plot.setBackgroundPaint(new Color(42,50,46));
        plot.setRangeGridlinePaint(Color.black);
        plot.setRenderer(bar);
        plot.getDomainAxis().setLabelFont(font);
        plot.getRangeAxis().setLabelFont(font);
        CategoryAxis xAxis = plot.getDomainAxis();  
        ValueAxis yAxis = plot.getRangeAxis();
        xAxis.setTickLabelFont(font3);
        yAxis.setTickLabelFont(font2);
    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Panel4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel b1;
    private javax.swing.JPanel b2;
    private javax.swing.JPanel b3;
    private javax.swing.JPanel b4;
    private javax.swing.JLabel bl1;
    private javax.swing.JLabel bl2;
    private javax.swing.JLabel bl3;
    private javax.swing.JLabel bl4;
    private javax.swing.JLabel bl5;
    private javax.swing.JPanel chartPanelWindow;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JComboBox<String> p4Options;
    private javax.swing.JPanel pan1;
    private javax.swing.JPanel settings;
    // End of variables declaration//GEN-END:variables
}
