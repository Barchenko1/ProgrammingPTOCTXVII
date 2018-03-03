package ua.org.oa.evlashdv.lectures.lecture1.swingTest;

import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.DBWorker;
import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Gliders;

import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookTableModel extends AbstractTableModel{
    private static final long serialVersionUID=3883320516766381209L;

    private int columnCount=11;
    private ArrayList<String []> dataArrayList;

    public BookTableModel(){
        dataArrayList=new ArrayList<String []>();
        for (int i = 0; i < dataArrayList.size(); i++) {
            dataArrayList.add(new String [getColumnCount()]);
        }
    }

    @Override
    public int getRowCount() {
        return dataArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnCount){
        switch (columnCount){
            case 0:return "id";
            case 1:return "name";
            case 2:return "type";
            case 3:return "developer";
            case 4:return "country";
            case 5:return "mass";
            case 6:return "length";
            case 7:return "height";
            case 8:return "wingSpan";
            case 9:return "wingArea";
            case 10:return "team";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String []rows=dataArrayList.get(rowIndex);
        return rows[columnIndex];
    }

    public void addData(String []row){
        String []rowTable=new String [getColumnCount()];
        rowTable=row;
        dataArrayList.add(rowTable);
    }
    public void addData(DBWorker worker){

        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT  * from users");
            while (resultSet.next()){
                String []row={
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("age"),
                        resultSet.getString("email")
                };

                addData(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
