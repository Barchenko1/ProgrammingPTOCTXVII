package ua.org.oa.evlashdv.lectures.lecture1.Calculator;

import javax.swing.*;

public class Start {

    private JFrame window;

    public Start() {
        window=new JFrame("Calculator");
        window.setSize(250,345);
        window.add(new Panel());
        window.setLocale(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Start();
            }
        });
    }
}
