package ua.org.oa.evlashdv.lectures.lecture1.lecture8b.newjdbc;

import javax.imageio.ImageIO;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class Main {
    static String url = "jdbc:mysql://localhost:3306/mydbtest";
    static String user = "root";
    static String pass = "878988qqq";
    static ResultSet getData() {
        String url = "jdbc:mysql://localhost:3306/mydbtest";
        String user = "root";
        String pass = "878988qqq";

        CachedRowSet cachedRowSet = null;
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stat = connection.createStatement();) {
            RowSetFactory factory = RowSetProvider.newFactory();
            cachedRowSet = factory.createCachedRowSet();

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
            cachedRowSet.populate(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cachedRowSet;
    }
    public static void main(String[] args) throws InterruptedException {
        String url="jdbc:mysql://localhost:3306/mydbtest";
        String user="root";
        String pass="878988qqq";

        try(Connection connection= DriverManager.getConnection(url,user,pass);
        Statement stat=connection.createStatement();){
//            stat.executeUpdate("DROP TABLE books");
//            stat.executeUpdate("CREATE TABLE IF NOT EXISTS books(id MEDIUMINT NOT NULL auto_increment,NAME VARCHAR (30)NOT NULL ,PRIMARY KEY (id))");
//            stat.executeUpdate("insert INTO books (name) VALUES ('Inferno')");
//            stat.executeUpdate("insert INTO books set NAME ='Solomon key'");
            ResultSet rs=stat.executeQuery("SELECT * FROM books");
            while (rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
            }
            ResultSet rs2=stat.executeQuery("SELECT NAME FROM books WHERE id=1");
            while (rs2.next()){
                System.out.println(rs2.getString(1));
            }
//            String bookId="1' or 1='1";
//            ResultSet rs3=stat.executeQuery("SELECT * FROM books WHERE id='"+bookId+"'");
//            while (rs3.next()){
//                System.out.println("bookName: "+rs3.getString("name"));
//            }
            String bookId="1";
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM books WHERE id=?");
            preparedStatement.setString(1,bookId);
            ResultSet rs4=preparedStatement.executeQuery();
            while (rs4.next()){
                System.out.println("bookName: "+rs4.getString("name"));
            }

//            BufferedImage image= ImageIO.read(new File("smile.jpg"));
//            Blob blob=connection.createBlob();
//            try (OutputStream outputStream=blob.setBinaryStream(1)){
//                ImageIO.write(image,"jpg",outputStream);
//            }
//
//            PreparedStatement statement1=connection.prepareStatement("insert into books (name, img) values(?,?)");
//            statement1.setString(1,"Inferno2");
//            statement1.setBlob(2,blob);
//            statement1.execute();
//
//            ResultSet rs1=statement1.executeQuery("SELECT * from books");
//            while (rs1.next()){
//                Blob blob1=rs1.getBlob("img");
//                BufferedImage image1=ImageIO.read(blob.getBinaryStream());
//                File outFile=new File("saved.png");
//                ImageIO.write(image1,"png",outFile);
//            }

//            System.out.println("`````````````1``````````````");
//            CallableStatement callableStatement=connection.prepareCall("{call BooksCount(?)}");
//            callableStatement.registerOutParameter(1, Types.INTEGER);
//            callableStatement.execute();
//            System.out.println(callableStatement.getInt(1));
//
//            CallableStatement callableStatement1=connection.prepareCall("{call getBook(?)}");
//            callableStatement1.setInt(1,1);
//            if (callableStatement1.execute()){
//                ResultSet rs5=callableStatement1.getResultSet();
//                while (rs5.next()){
//                    //System.out.println(rs5.getInt("id"));
//                    System.out.println(rs5.getString("name"));
//                }
//            }
//
//            CallableStatement callableStatement2=connection.prepareCall("{call getCount()}");
//            boolean hasResults=callableStatement2.execute();
//            while (hasResults){
//                ResultSet rs6=callableStatement2.getResultSet();
//                while (rs6.next()){
//                    System.out.println(rs6.getInt(1));
//                }
//            }
//
//            System.out.println("````````````````3`````````````````");
//            Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//            ResultSet resultSet=statement.executeQuery("SELECT * FROM books");
//            while (resultSet.next()){
//                System.out.println(resultSet.getInt("id"));
//                System.out.println(resultSet.getString("name"));
//            }
//            resultSet.last();
//            resultSet.updateString("name","new Value");
//            resultSet.updateRow();
//
//            resultSet.moveToInsertRow();
//            resultSet.updateString("name","insert row");
//            resultSet.insertRow();
//
//            resultSet.absolute(2);
//            resultSet.deleteRow();
//
//            resultSet.beforeFirst();
//            while (resultSet.next()){
//                System.out.println(resultSet.getInt("id"));
//                System.out.println(resultSet.getString("name"));
//            }
//            System.out.println("``````````````````4````````````````````");
//            ResultSet resultSet=getData();
//            while (resultSet.next()){
//                System.out.println(resultSet.getInt("id"));
//                System.out.println(resultSet.getString("name"));
//            }
//            CachedRowSet cachedRowSet= (CachedRowSet) resultSet;
//            cachedRowSet.setUrl(url);
//            cachedRowSet.setUsername(user);
//            cachedRowSet.setPassword(pass);
//
//            cachedRowSet.setCommand("select * fron books where id=?");
//            cachedRowSet.setInt(1,1);
//            cachedRowSet.setPageSize(20);
//            cachedRowSet.execute();
//            do {
//                while (cachedRowSet.next()){
//                    System.out.println(cachedRowSet.getInt("id"));
//                    System.out.println(cachedRowSet.getString("name"));
//                }
//            }while (cachedRowSet.nextPage());
//            System.out.println("```````````````````5````````````````````");
//            DatabaseMetaData databaseMetaData=connection.getMetaData();
//            databaseMetaData.nullPlusNonNullIsNull();
//            ResultSet resultSet=databaseMetaData.getTables(null,null,null,new String []{"Table"});
//            while (resultSet.next()){
//                System.out.println(resultSet.getString(3));
//            }
//            System.out.println("````````");
//            ResultSet resultSet1=stat.executeQuery("SELECT * FROM books");
//            ResultSetMetaData resultSetMetaData=resultSet1.getMetaData();
//            for (int i=1;i<=resultSetMetaData.getColumnCount();i++){
//                System.out.println(resultSetMetaData.getColumnLabel(i));
//            }
//            System.out.println("```````````````````6`````````````````````");
//            connection.setAutoCommit(false);
//            stat.executeUpdate("insert INTO books (name) VALUES ('Pasha')");
//            Savepoint savepoint=connection.setSavepoint();
//            stat.executeUpdate("insert INTO books (name) VALUES ('Sasha')");
//            stat.executeUpdate("insert INTO books (name) VALUES ('Aleksandrov')");
//            connection.rollback(savepoint);
//            connection.commit();
//            connection.releaseSavepoint(savepoint);
//            System.out.println("`````````````````````7``````````````````````");
//            connection.setAutoCommit(false);
//            stat.addBatch("insert INTO books (name) VALUES ('Valera')");
//            stat.addBatch("insert INTO books (name) VALUES ('Serega')");
//            stat.executeBatch();
//            connection.commit();
            System.out.println("```````````````````````8```````````````````````");
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            ResultSet resultSet=stat.executeQuery("SELECT count(*) FROM books");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }

            new OtherTransaction().start();
            Thread.sleep(2000);

            ResultSet resultSet2=stat.executeQuery("SELECT count(*) FROM books");
            while (resultSet2.next()){
                System.out.println(resultSet2.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
    static class OtherTransaction extends Thread{
        @Override
        public void run() {
            try (Connection connection=DriverManager.getConnection(url,user,pass);
            Statement stat=connection.createStatement()){
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                stat.executeUpdate("INSERT INTO books (name) VALUES ('new value')");
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
