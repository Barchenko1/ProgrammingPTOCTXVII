package ua.org.oa.evlashdv.lectures.lecture1.LemonFinalProject;

import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.DBWorker;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MyTableModelH extends AbstractTableModel {

    private Set<TableModel> tableModel = new HashSet<>();

    private ArrayList<String []> dataArraList;

    public MyTableModelH() {
        dataArraList=new ArrayList<String []>();
        for (int i = 0; i < dataArraList.size(); i++) {
            dataArraList.add(new String [getColumnCount()]);
        }
    }


    @Override
    public int getRowCount() {
        return dataArraList.size();
    }

    @Override
    public int getColumnCount() {
        return 13;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:return "name";
            case 1:return "type";
            case 2:return "developer";
            case 3:return "country";
            case 4:return "mass";
            case 5:return "speed";
            case 6:return "distance";
            case 7:return "length";
            case 8:return "height";
            case 9:return "mainRotor";
            case 10:return "tailRotor";
            case 11:return "motor";
            case 12:return "team";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Helicopters1.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String []rows=dataArraList.get(rowIndex);
        return rows[columnIndex];
    }

    public void addData(String []row){
        String []rowTable=new String [getColumnCount()];
        rowTable=row;
        dataArraList.add(rowTable);
    }

    public void addData(DBWorker worker){
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * from helicopters1");
            while (resultSet.next()){
                String []row={
                        resultSet.getString("name"),
                        resultSet.getString("type"),
                        resultSet.getString("developer"),
                        resultSet.getString("country"),
                        resultSet.getString("mass"),
                        resultSet.getString("speed"),
                        resultSet.getString("distance"),
                        resultSet.getString("length"),
                        resultSet.getString("height"),
                        resultSet.getString("mainRotor"),
                        resultSet.getString("tailRotor"),
                        resultSet.getString("motor"),
                        resultSet.getString("team")
                };
                addData(row);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}