package ua.org.oa.evlashdv.lectures.lecture1.swingTest;

import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.DBWorker;
import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Gliders;
import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Helicopters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TestFrame extends JFrame {

    static int i=0;

    public TestFrame() {
        DBWorker worker=new DBWorker();
        worker.getConnection();

        JFrame frame=new JFrame("FRAME");
        frame.setSize(new Dimension(600,400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //frame.setLayout(new GridBagLayout());

        ArrayList glidersList = Gliders.selectAllGlidersArrayList();


        JButton addButton=new JButton("Добавить");
        JButton deleteButton=new JButton("Изменить");
        JButton clearButton=new JButton("Удалить");

        MyTableModel btm=new MyTableModel(glidersList);
        JTable bookTable=new JTable(btm);
        JScrollPane bookTableScroolPage=new JScrollPane(bookTable);
        bookTableScroolPage.setPreferredSize(new Dimension(400,400));

        //btm.addData(worker);

        //btm.selectAllGliders();


//        frame.add(bookTableScroolPage,new GridBagConstraints(0, 0, 3, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
//
//        frame.add(addButton,new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
//
//        frame.add(deleteButton,new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
//
//        frame.add(clearButton,new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.setVisible(true);
        frame.pack();

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestFrame();
            }
        });
    }


}
