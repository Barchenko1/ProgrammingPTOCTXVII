package ua.org.oa.evlashdv.lectures.lecture1.swingTest;

import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.DBWorker;
import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Gliders;
import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Helicopters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Main1 {
    public static void main(String[] args) {
        DBWorker worker=new DBWorker();
        worker.getConnection();


        JFrame frame=new JFrame("FRAME");
        frame.setSize(new Dimension(600,400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        JButton addButton=new JButton("Добавить");
        JButton deleteButton=new JButton("Изменить");
        JButton clearButton=new JButton("Удалить");

        BookTableModel btm=new BookTableModel();
        JTable bookTable=new JTable(btm);
        JScrollPane bookTableScroolPage=new JScrollPane(bookTable);
        bookTableScroolPage.setPreferredSize(new Dimension(400,400));



        btm.selectAllGliders();

//        String []str=new String [4];
//        str[0]="0";
//        str[1]="Название книги";
//        str[2]="4531414";
//        str[3]="Описание книги";
//        for (int i = 0; i <100 ; i++) {
//            btm.addData(str);
//        }

        frame.add(bookTableScroolPage,new GridBagConstraints(0, 0, 3, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(addButton,new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(deleteButton,new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(clearButton,new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.setVisible(true);
        frame.pack();

    }
    public class addButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
