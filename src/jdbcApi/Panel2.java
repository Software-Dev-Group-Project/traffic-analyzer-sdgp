package jdbcApi;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
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
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class Panel2 extends javax.swing.JFrame {

    public Panel2() {

        initComponents();
        ChartFactory.setChartTheme(StandardChartTheme.createJFreeTheme());

        CategoryDataset Panel2Dataset = openDataset();

       
        JFreeChart panel2Chart = ChartFactory.createLineChart("Vehicle count by the hour (2000 - 2019)", "Hour", "Number of Vehicles", Panel2Dataset, PlotOrientation.VERTICAL, true, true, false);
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) panel2Chart.getCategoryPlot().getRenderer();
        renderer.setAutoPopulateSeriesStroke(false);
        renderer.setBaseStroke(new BasicStroke(6.0f));
        panel2Chart.setBackgroundPaint(new Color(255, 255, 102));

        CategoryPlot P2Plot = panel2Chart.getCategoryPlot();
        P2Plot.setRangeGridlinePaint(Color.black);
        P2Plot.setBackgroundPaint(new Color(11, 58, 83));
        P2Plot.getDomainAxis().setLabelFont(new Font("Dialog", Font.BOLD, 15));
        P2Plot.getRangeAxis().setLabelFont(new Font("Dialog", Font.BOLD, 15));
        CategoryAxis xAxis = P2Plot.getDomainAxis();
        ValueAxis yAxis = P2Plot.getRangeAxis();
        xAxis.setTickLabelFont(new Font("Dialog", Font.ROMAN_BASELINE, 15));
        yAxis.setTickLabelFont(new Font("Dialog", Font.ROMAN_BASELINE, 15));

        chartPanel = new ChartPanel(panel2Chart);
        chartPanel.setSize(800, 527);
        dataDisplayPanel.removeAll();
        dataDisplayPanel.add(chartPanel);
        dataDisplayPanel.updateUI();
    }
    
        

    private CategoryDataset openDataset() {

        try {

            String sqlQuery = "SELECT entry_hour, SUM(all_motor_vehicles) FROM CountEntry GROUP BY entry_hour";

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
        chartPanel = new javax.swing.JPanel();
        dataDisplayPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        P2VehicleList = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        P2YearList = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        logo = new javax.swing.JLabel();
        label1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(11, 58, 83));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setPreferredSize(new java.awt.Dimension(1261, 756));

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
            .addComponent(bl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        b1Layout.setVerticalGroup(
            b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bl1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        b2.setBackground(new java.awt.Color(102, 102, 102));
        b2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b2.setAlignmentX(0.0F);
        b2.setAlignmentY(0.0F);
        b2.setPreferredSize(new java.awt.Dimension(223, 50));

        bl2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bl2.setForeground(new java.awt.Color(240, 240, 240));
        bl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bl2.setText("PANEL 2");
        bl2.setToolTipText("Panel 2");

        javax.swing.GroupLayout b2Layout = new javax.swing.GroupLayout(b2);
        b2.setLayout(b2Layout);
        b2Layout.setHorizontalGroup(
            b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(bl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        b3Layout.setVerticalGroup(
            b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bl3, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        b4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b4.setAlignmentX(0.0F);
        b4.setAlignmentY(0.0F);
        b4.setPreferredSize(new java.awt.Dimension(223, 50));

        bl4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bl4.setText("PANEL 4");
        bl4.setToolTipText("Panel 4");
        bl4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bl4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bl4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bl4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout b4Layout = new javax.swing.GroupLayout(b4);
        b4.setLayout(b4Layout);
        b4Layout.setHorizontalGroup(
            b4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(bl5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settings, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
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

        chartPanel.setBackground(new java.awt.Color(11, 58, 83));

        dataDisplayPanel.setBackground(new java.awt.Color(255, 255, 102));
        dataDisplayPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout dataDisplayPanelLayout = new javax.swing.GroupLayout(dataDisplayPanel);
        dataDisplayPanel.setLayout(dataDisplayPanelLayout);
        dataDisplayPanelLayout.setHorizontalGroup(
            dataDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );
        dataDisplayPanelLayout.setVerticalGroup(
            dataDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chartPanelLayout.createSequentialGroup()
                .addComponent(dataDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        chartPanelLayout.setVerticalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));

        jPanel2.setBackground(new java.awt.Color(11, 58, 83));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        P2VehicleList.setBackground(new java.awt.Color(240, 240, 240));
        P2VehicleList.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        P2VehicleList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Motor Vehicles", "Heavy Goods Vehicles", "Large Goods Vehicles", "Cars and Taxis", "Buses and Coaches", "Cycles" }));
        P2VehicleList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                P2VehicleListItemStateChanged(evt);
            }
        });
        P2VehicleList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2VehicleListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(P2VehicleList, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(P2VehicleList, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(11, 58, 83));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        P2YearList.setBackground(new java.awt.Color(240, 240, 240));
        P2YearList.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        P2YearList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Years", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019" }));
        P2YearList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                P2YearListItemStateChanged(evt);
            }
        });
        P2YearList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2YearListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(P2YearList, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(P2YearList, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel1.setText("Vehicle Type");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Year");

        button1.setActionCommand("exitButton");
        button1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        button1.setLabel("Exit");
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button1MouseClicked(evt);
            }
        });
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(155, 155, 155))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        button1.getAccessibleContext().setAccessibleName("exitButton");

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdbcApi/LATA_LOGO_XS.png"))); // NOI18N

        label1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Statistics taken from Bracknell Forest Local Authority, South East England(2000-2019)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logo)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logo)
                .addGap(13, 13, 13)
                .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl1MouseClicked
        new Panel1().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_bl1MouseClicked

    private void bl1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl1MouseEntered
        b1.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_bl1MouseEntered

    private void bl1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl1MouseExited
        b1.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_bl1MouseExited

    private void bl3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl3MouseClicked
        new Panel3().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_bl3MouseClicked

    private void bl3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl3MouseEntered
        b3.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_bl3MouseEntered

    private void bl3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl3MouseExited
        b3.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_bl3MouseExited

    private void bl4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl4MouseClicked
        new Panel4().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_bl4MouseClicked

    private void bl4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl4MouseEntered
        b4.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_bl4MouseEntered

    private void bl4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl4MouseExited
        b4.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_bl4MouseExited

    private void bl5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl5MouseEntered
        settings.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_bl5MouseEntered

    private void bl5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl5MouseExited
        settings.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_bl5MouseExited

    private void bl5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl5MouseClicked
        new HomeScreen().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bl5MouseClicked

    private void P2VehicleListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_P2VehicleListItemStateChanged
        CategoryDataset Panel2Dataset = updateChart();

        JFreeChart panel2Chart = ChartFactory.createLineChart("Vehicle count by the hour (2000 - 2019)", "Hour", "Number of Vehicles", Panel2Dataset, PlotOrientation.VERTICAL, true, true, false);
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) panel2Chart.getCategoryPlot().getRenderer();
        renderer.setAutoPopulateSeriesStroke(false);
        renderer.setBaseStroke(new BasicStroke(6.0f));

        panel2Chart.setBackgroundPaint(new Color(255, 255, 102));

        CategoryPlot P2Plot = panel2Chart.getCategoryPlot();
        P2Plot.setRangeGridlinePaint(Color.black);
        P2Plot.setBackgroundPaint(new Color(11, 58, 83));
        P2Plot.getDomainAxis().setLabelFont(new Font("Dialog", Font.BOLD, 15));
        P2Plot.getRangeAxis().setLabelFont(new Font("Dialog", Font.BOLD, 15));
        CategoryAxis xAxis = P2Plot.getDomainAxis();
        ValueAxis yAxis = P2Plot.getRangeAxis();
        xAxis.setTickLabelFont(new Font("Dialog", Font.ROMAN_BASELINE, 15));
        yAxis.setTickLabelFont(new Font("Dialog", Font.ROMAN_BASELINE, 15));

        chartPanel = new ChartPanel(panel2Chart);
        chartPanel.setSize(800, 527);
        dataDisplayPanel.removeAll();
        dataDisplayPanel.add(chartPanel);
        dataDisplayPanel.updateUI();
    }//GEN-LAST:event_P2VehicleListItemStateChanged

    private void P2YearListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_P2YearListItemStateChanged
        CategoryDataset Panel2Dataset = updateChart();

        JFreeChart panel2Chart = ChartFactory.createLineChart("Vehicle count by the hour (2000 - 2019)", "Hour", "Number of Vehicles", Panel2Dataset, PlotOrientation.VERTICAL, true, true, false);
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) panel2Chart.getCategoryPlot().getRenderer();
        renderer.setAutoPopulateSeriesStroke(false);
        renderer.setBaseStroke(new BasicStroke(6.0f));

        panel2Chart.setBackgroundPaint(new Color(255, 255, 102));

        // panel2Chart.removeLegend();
        CategoryPlot P2Plot = panel2Chart.getCategoryPlot();
        P2Plot.setRangeGridlinePaint(Color.black);
        P2Plot.setBackgroundPaint(new Color(11, 58, 83));
        P2Plot.getDomainAxis().setLabelFont(new Font("Dialog", Font.BOLD, 15));
        P2Plot.getRangeAxis().setLabelFont(new Font("Dialog", Font.BOLD, 15));
        CategoryAxis xAxis = P2Plot.getDomainAxis();
        ValueAxis yAxis = P2Plot.getRangeAxis();
        xAxis.setTickLabelFont(new Font("Dialog", Font.ROMAN_BASELINE, 15));
        yAxis.setTickLabelFont(new Font("Dialog", Font.ROMAN_BASELINE, 15));

        chartPanel = new ChartPanel(panel2Chart);
        chartPanel.setSize(800, 527);
        dataDisplayPanel.removeAll();
        dataDisplayPanel.add(chartPanel);
        dataDisplayPanel.updateUI();

    }//GEN-LAST:event_P2YearListItemStateChanged

    private void P2YearListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2YearListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_P2YearListActionPerformed

    private void P2VehicleListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2VehicleListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_P2VehicleListActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
       int a=JOptionPane.showConfirmDialog(null, "Are you sure you want to close the application? ", "Select",JOptionPane.YES_NO_OPTION);
       if(a==0){
           System.exit(0);
       }
    }//GEN-LAST:event_button1ActionPerformed

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked

        
    }//GEN-LAST:event_button1MouseClicked

    private CategoryDataset updateChart() {

        try {

            String sqlQuery = "";

            String vehicleName = (String) P2VehicleList.getSelectedItem();
            String yearName = (String) P2YearList.getSelectedItem();
            
            if (vehicleName.equals("All Motor Vehicles")){
                 vehicleName = "all_motor_vehicles";                  
            }
            else if(vehicleName.equals("Cycles")){
                vehicleName = "pedal_cycles";
            }
            else if(vehicleName.equals("Motorcycles")){
                vehicleName = "two_wheeled_motor_vehicles";
            }
            else if(vehicleName.equals("Cars and Taxis")){
                vehicleName = "cars_and_taxis";
            }
             else if(vehicleName.equals("Buses and Coaches")){
                vehicleName = "buses_and_coaches";
            }
             else if(vehicleName.equals("Large Goods Vehicles")){
                vehicleName = "lgvs";
            }else{
                 vehicleName = "all_hgvs";
             }
            

            if (vehicleName.equals("All Motor Vehicles") && yearName.equals("All Years")) {

                sqlQuery = "SELECT entry_hour, SUM(all_motor_vehicles) FROM CountEntry GROUP BY entry_hour";

            } else if (vehicleName.equals("All Motor Vehicles") && !yearName.equals("All Years")) {

                sqlQuery = "SELECT entry_hour, SUM(all_motor_vehicles) FROM CountEntry WHERE entry_year = " + yearName + " GROUP BY entry_hour";

            } else if (!vehicleName.equals("All Motor Vehicles") && yearName.equals("All Years")) {

                sqlQuery = "SELECT entry_hour, SUM(" + vehicleName + ") FROM CountEntry GROUP BY entry_hour";
            } else {

                sqlQuery = "SELECT entry_hour, SUM(" + vehicleName + ") FROM CountEntry WHERE entry_year = " + yearName + " GROUP BY entry_hour";
            }

            //String sqlQuery = "SELECT entry_hour , SUM(" + selected_vehicle + ") FROM CountEntry GROUP BY entry_hour";
            JDBCCategoryDataset jdbc = new JDBCCategoryDataset(jdbcApi.trafficDataLogic.ConnectTrafficDB.getConnection(), sqlQuery);
            return jdbc;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Panel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Main;
    private javax.swing.JComboBox<String> P2VehicleList;
    private javax.swing.JComboBox<String> P2YearList;
    private javax.swing.JPanel b1;
    private javax.swing.JPanel b2;
    private javax.swing.JPanel b3;
    private javax.swing.JPanel b4;
    private javax.swing.JLabel bl1;
    private javax.swing.JLabel bl2;
    private javax.swing.JLabel bl3;
    private javax.swing.JLabel bl4;
    private javax.swing.JLabel bl5;
    private java.awt.Button button1;
    private javax.swing.JPanel chartPanel;
    private javax.swing.JPanel dataDisplayPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private java.awt.Label label1;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel settings;
    // End of variables declaration//GEN-END:variables
}
