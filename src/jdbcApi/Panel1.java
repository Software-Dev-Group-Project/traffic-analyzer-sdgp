package jdbcApi;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author piotrstanny
 * 
 */
public class Panel1 extends javax.swing.JFrame {
    
    /**
     * SQL QUERIES AND DATA SET CHARACTERISTICS
     */
    private int minYear = 2000;
    private int maxYear = 2019;
    
    // Path to the DB connection method
    Connection dbConnectionMethod = jdbcApi.trafficDataLogic.ConnectTrafficDB.getConnection();
    
    // Default query showing all vehicles and bicycles by road from the whole scope
    private String sqlQuery = "SELECT r.road_name, SUM(ce.all_motor_vehicles + ce.pedal_cycles) AS 'All Motor Vehicles and Bicycles'\n" +
                    "FROM CountEntry ce\n" +
                    "JOIN CountPoint cp ON cp.count_point_id = ce.count_point_id\n" +
                    "JOIN Road r ON r.road_id = cp.road_id\n" +
                    "GROUP BY r.road_name";
    
    /**
     * PANEL1 CONSTRUCTOR
     */
    public Panel1() {
        // Generate the Panel components
        initComponents();        
        
        // Set up content JPanel layout
        setContentLayout(content);
        
        // Load default chart upon the Panel creation
        CategoryDataset dataset = createDataset(dbConnectionMethod, sqlQuery);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        content.add(chartPanel);
        content.validate();
    }
    
    /**
     * CONTENT LAYOUT AND DESIGN SETUP METHODS
     */
    private void setContentLayout(JPanel content) {
        // Layout settings
        content.setLayout(new BorderLayout(20,20));
        Color bgColour = new Color(222,222,222);
        
        
        // Side Panel
        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(bgColour);
        sidePanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 0, 0, 27),  new EtchedBorder(EtchedBorder.LOWERED)));
        
        sidePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        // Side Panel - Create filters
        JPanel yearPanel = yearFilter(bgColour);
        JPanel roadPanel = roadFilter(bgColour);
        
        
        // Side Panel - Add filters to the panel
        sidePanel.add(yearPanel, gbc);
        sidePanel.add(roadPanel, gbc);
        
        
        content.add(sidePanel, BorderLayout.EAST);
        
        
        // Create Margins around
        JPanel top = marginPanel(bgColour);
        content.add(top, BorderLayout.NORTH);
        JPanel left = marginPanel(bgColour);
        content.add(left, BorderLayout.WEST);
        JPanel bottom = marginPanel(bgColour);
        JLabel footer = new JLabel("* Statistics are created out of a data recorded between Years 2000 and 2019 in Bracknell Forest Local Authority in South East England");
        bottom.add(footer);
        content.add(bottom, BorderLayout.SOUTH);
    }
    
    // Year Filter Panel
    JPanel yearFilter(Color bgColour) {
        JPanel panel = new JPanel();
        panel.setBackground(bgColour);
        ArrayList<String> years = new ArrayList<String>();
        years.add("All");
        for (int year = minYear; year <= maxYear; year++) {
            years.add(String.valueOf(year));
        }
        JLabel yearLabel = new JLabel("Selected Year:");
        JComboBox year = new JComboBox(years.toArray());
        panel.add(yearLabel);
        panel.add(year);
        panel.setBorder(BorderFactory.createTitledBorder("Filter results by Year"));
        
        return panel;
    }
    
    // Road Type Filter Panel
    JPanel roadFilter(Color bgColour) {
        JPanel panel = new JPanel();
        panel.setBackground(bgColour);
        JLabel roadType = new JLabel("Selected type:");
        JRadioButton roadAll = new JRadioButton("All");
        roadAll.setSelected(true);
        JRadioButton roadMinor = new JRadioButton("Minor");
        JRadioButton roadMajor = new JRadioButton("Major");
        ButtonGroup bg = new ButtonGroup();
        bg.add(roadAll);
        bg.add(roadMinor);
        bg.add(roadMajor);
        panel.add(roadType);
        panel.add(roadAll);
        panel.add(roadMinor);
        panel.add(roadMajor);
        panel.setBorder(BorderFactory.createTitledBorder("Filter result by Road Type"));
        
        return panel;
    }
    
    // Panel as margin
    JPanel marginPanel(Color bgColour) {
        JPanel panel = new JPanel();
        panel.setBackground(bgColour);
        panel.setSize(1, 1);
        return panel;
    }
    
    /**
     * CHART AND DB RELATED METHODS
     */
    private CategoryDataset createDataset(Connection dbConnectionMethod, String sqlQuery) {
        // Try to connect to DB and execute SQL query
        try {
            JDBCCategoryDataset jdbc = new JDBCCategoryDataset(dbConnectionMethod, sqlQuery);
            return jdbc;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    // Set up chart properties
    private JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "",
                "Road name", 
                "No of Vehicles", 
                dataset, 
                PlotOrientation.HORIZONTAL, 
                rootPaneCheckingEnabled, 
                rootPaneCheckingEnabled, 
                rootPaneCheckingEnabled);
        return chart;
    }
    
    
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
            java.util.logging.Logger.getLogger(Panel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Panel1().setVisible(true);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        content = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(11, 58, 83));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Header.setBackground(new java.awt.Color(11, 58, 83));
        Header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        b1.setBackground(new java.awt.Color(102, 102, 102));
        b1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b1.setToolTipText("Panel 1");
        b1.setAlignmentX(0.0F);
        b1.setAlignmentY(0.0F);
        b1.setPreferredSize(new java.awt.Dimension(223, 50));

        bl1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bl1.setForeground(new java.awt.Color(240, 240, 240));
        bl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bl1.setText("PANEL 1");
        bl1.setToolTipText("Panel 1");

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
                .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settings, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
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

        content.setBackground(new java.awt.Color(222, 222, 222));
        content.setSize(new java.awt.Dimension(1233, 549));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1245, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdbcApi/LATA_LOGO_XS.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Traffic Volume in Bracknell Forest by Road and Direction");

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
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2)
                        .addGap(0, 354, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo)
                    .addComponent(jLabel2))
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

    private void bl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl2MouseClicked
        new Panel2().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_bl2MouseClicked

    private void bl3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl3MouseClicked
        new Panel3().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_bl3MouseClicked

    private void bl4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl4MouseClicked
        new Panel4().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_bl4MouseClicked

    private void bl5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl5MouseEntered
        settings.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_bl5MouseEntered

    private void bl5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl5MouseExited
        settings.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_bl5MouseExited

    private void bl3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl3MouseEntered
        b3.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_bl3MouseEntered

    private void bl3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl3MouseExited
        b3.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_bl3MouseExited

    private void bl4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl4MouseEntered
        b4.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_bl4MouseEntered

    private void bl4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl4MouseExited
        b4.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_bl4MouseExited

    private void bl5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl5MouseClicked
        new HomeScreen().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bl5MouseClicked

    private void bl2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl2MouseEntered
        b2.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_bl2MouseEntered

    private void bl2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl2MouseExited
        b2.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_bl2MouseExited


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
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel settings;
    // End of variables declaration//GEN-END:variables
}
