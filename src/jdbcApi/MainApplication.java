/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcApi;

/**
 *
 * @author gerva
 */
public class MainApplication {
    public static void main(String args[]) {

        //Calling run method to start application
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartScreen().setVisible(true);
            }
        });
    }
}


