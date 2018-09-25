package ua.org.oa.evlashdv.lectures.lecture1.LemonFinalProject;

import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameA extends JFrame {
    private static JTextField textField1 = new JTextField(50);
    private static JTextField textField2 = new JTextField(50);
    private static JTextField textField3 = new JTextField(50);
    private static JTextField textField4 = new JTextField(50);
    private static JTextField textField5 = new JTextField(50);
    private static JTextField textField6 = new JTextField(50);
    private static JTextField textField7 = new JTextField(50);
    private static JTextField textField8 = new JTextField(50);
    private static JTextField textField9 = new JTextField(50);
    private static JTextField textField10 = new JTextField(50);
    private static JTextField textField11 = new JTextField(50);
    private static JTextField textField12 = new JTextField(50);
    private static JTextField textField13 = new JTextField(50);

    public FrameA() {
        JFrame frame = new JFrame("Title");
        frame.setSize(new Dimension(1600, 1000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        JLabel label1 = new JLabel("name");
        JLabel label2 = new JLabel("type");
        JLabel label3 = new JLabel("developer");
        JLabel label4 = new JLabel("country");
        JLabel label5 = new JLabel("mass");
        JLabel label6 = new JLabel("speed");
        JLabel label7 = new JLabel("distance");
        JLabel label8 = new JLabel("length");
        JLabel label9 = new JLabel("height");
        JLabel label10 = new JLabel("wingSpan");
        JLabel label11 = new JLabel("wingArea");
        JLabel label12 = new JLabel("motor");
        JLabel label13 = new JLabel("team");

        JButton addButton = new JButton("Добавить");
        addButton.addActionListener(new addActionListener());

        JButton deleteButton = new JButton("Удалить");
        deleteButton.addActionListener(new deleteActionListener());

        JButton changeButton = new JButton("Изменить");
        changeButton.addActionListener(new changeActionListener());
        JButton sourceButton = new JButton("Поиск");
        sourceButton.addActionListener(new sourceActionListener());

        //MyTableModelG tableModel = new MyTableModelG();
        MyTableModelA tableModel=new MyTableModelA();
        //MyTableModelH tableModel=new MyTableModelH();
        JTable table = new JTable(tableModel);
        JScrollPane TableScroolPage = new JScrollPane(table);
        TableScroolPage.setPreferredSize(new Dimension(1000, 400));

        tableModel.addData(new DBWorker());

        frame.add(TableScroolPage, new GridBagConstraints(0, 0, 4, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(addButton, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(deleteButton, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(changeButton, new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(sourceButton, new GridBagConstraints(3, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(textField1, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(label1, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(textField2, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(label2, new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(textField3, new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(label3, new GridBagConstraints(1, 4, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(textField4, new GridBagConstraints(0, 5, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(label4, new GridBagConstraints(1, 5, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(textField5, new GridBagConstraints(0, 6, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(label5, new GridBagConstraints(1, 6, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(textField6, new GridBagConstraints(0, 7, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(label6, new GridBagConstraints(1, 7, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(textField7, new GridBagConstraints(0, 8, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(label7, new GridBagConstraints(1, 8, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(textField8, new GridBagConstraints(0, 9, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(label8, new GridBagConstraints(1, 9, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(textField9, new GridBagConstraints(0, 10, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(label9, new GridBagConstraints(1, 10, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(textField10, new GridBagConstraints(0, 11, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(label10, new GridBagConstraints(1, 11, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(textField11, new GridBagConstraints(0, 12, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(label11, new GridBagConstraints(1, 12, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(textField12, new GridBagConstraints(0, 13, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(label12, new GridBagConstraints(1, 13, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(textField13, new GridBagConstraints(0, 14, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        frame.add(label13, new GridBagConstraints(1, 14, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));



        frame.setVisible(true);

        frame.pack();

    }

    class sourceActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = textField1.getText();
            Airplanes1.getAiroplanes(str1);
            System.out.println(Airplanes1.getAiroplanes(str1));
        }
    }

    static class addActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1=textField1.getText();
            String str2=textField2.getText();
            String str3=textField3.getText();
            String str4=textField4.getText();
            String str5=textField5.getText();
            String str6=textField6.getText();
            String str7=textField7.getText();
            String str8=textField8.getText();
            String str9=textField9.getText();
            String str10=textField10.getText();
            String str11=textField11.getText();
            String str12=textField12.getText();
            String str13=textField13.getText();

            Airplanes1 airplanes1=new Airplanes1(str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13);
            Airplanes1.createAiroplane(airplanes1);
        }
    }
    static class deleteActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1=textField1.getText();
            Airplanes1.deleteAirplanes(str1);
        }
    }

    static class changeActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1=textField1.getText();
            String str2=textField2.getText();
            String str3=textField3.getText();
            String str4=textField4.getText();
            String str5=textField5.getText();
            String str6=textField6.getText();
            String str7=textField7.getText();
            String str8=textField8.getText();
            String str9=textField9.getText();
            String str10=textField10.getText();
            String str11=textField11.getText();
            String str12=textField12.getText();
            String str13=textField13.getText();
            Airplanes1 airplanes1=new Airplanes1(str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13);
            Airplanes1.updateAirplanes(airplanes1);
        }
    }
}
