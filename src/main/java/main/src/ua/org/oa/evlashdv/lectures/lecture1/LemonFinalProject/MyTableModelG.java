package ua.org.oa.evlashdv.lectures.lecture1.LemonFinalProject;

import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.DBWorker;
import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Gliders;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MyTableModelG extends AbstractTableModel {

    private Set<TableModel> tableModel = new HashSet<>();

    private ArrayList<String []> dataArraList;

    public MyTableModelG() {
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
        return 10;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:return "name";
            case 1:return "type";
            case 2:return "developer";
            case 3:return "country";
            case 4:return "mass";
            case 5:return "length";
            case 6:return "height";
            case 7:return "wingSpan";
            case 8:return "wingArea";
            case 9:return "team";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Gliders.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String []rows=dataArraList.get(rowIndex);
        return rows[columnIndex];
//        switch (columnIndex) {
//            case 0:
//                return gliders.getName();
//            case 1:
//                return gliders.getType();
//            case 2:
//                return gliders.getDeveloper();
//            case 3:
//                return gliders.getCountry();
//            case 4:
//                return gliders.getMass();
//            case 5:
//                return gliders.getLength();
//            case 6:
//                return gliders.getHeight();
//            case 7:
//                return gliders.getWingSpan();
//            case 8:
//                return gliders.getWindArea();
//            case 9:
//                return gliders.getTeam();
//        }
//        return null;
    }

    public void addData(String []row){
        String []rowTable=new String [getColumnCount()];
        rowTable=row;
        dataArraList.add(rowTable);
    }

    public void addData(DBWorker worker){
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * from gliders1");
            while (resultSet.next()){
                String []row={
                        resultSet.getString("name"),
                        resultSet.getString("type"),
                        resultSet.getString("developer"),
                        resultSet.getString("country"),
                        resultSet.getString("mass"),
                        resultSet.getString("length"),
                        resultSet.getString("height"),
                        resultSet.getString("wingSpan"),
                        resultSet.getString("wingArea"),
                        resultSet.getString("team")
                };
                addData(row);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getGliders1(String name){
        String query="select * from gliders1 WHERE name=";
        try {
            DBWorker worker=new DBWorker();
            Statement statement=worker.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query+"'"+name+"'");
            while (resultSet.next()){
                String []row={
                        resultSet.getString("name"),
                        resultSet.getString("type"),
                        resultSet.getString("developer"),
                        resultSet.getString("country"),
                        resultSet.getString("mass"),
                        resultSet.getString("length"),
                        resultSet.getString("height"),
                        resultSet.getString("wingSpan"),
                        resultSet.getString("wingArea"),
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