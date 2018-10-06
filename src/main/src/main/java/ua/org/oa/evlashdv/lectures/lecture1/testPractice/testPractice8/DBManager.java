package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBManager {

    private static final String SQL_FIND_ALL_USERS = "SELECT * FROM users";
    private static final String SQL_INSERT_USER="INSERT INTO users VALUES (DEFAULT,?)";
    private static final String SQL_INSERT_GROUP = "INSERT INTO groups VALUES (DEFAULT, ?)";
    private static final String SQL_FIND_ALL_GROUPS = "SELECT * FROM groups";
    private static final String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE login=?";
    private static final String SQL_FIND_GROUP_BY_NAME = "SELECT * FROM groups WHERE name=?";
    private static final String SQL_INSERT_USER_GROUP = "INSERT INTO users_groups VALUES(?,?)";
    private static final String SQL_FIND_USER_GROUPS = "SELECT * FROM users_groups WHERE user_id =?";
    private static final String SQL_FIND_GROUP_BY_ID = "SELECT * FROM groups WHERE id =?";
    private static final String SQL_DELETE_GROUP = "DELETE FROM groups WHERE id = ?";
    private static final String SQL_UPDATE_GROUP = "UPDATE groups SET name = ? WHERE id = ?";

    private static DBManager instance;

    public static synchronized DBManager getInstance(){
        if (instance==null){
            instance=new DBManager();
        }
        return instance;
    }

    public DBManager() {
    }
    public List<User> findAllUsers() throws SQLException {
        List<User> users=new ArrayList<>();
        Connection conn=Constants.getConnection();
        Statement statement=conn.createStatement();
        ResultSet rs=statement.executeQuery(SQL_FIND_ALL_USERS);
        while (rs.next()){
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
            users.add(user);
        }
        return users;
    }

    private User extractUser(ResultSet rs) throws SQLException {
        User user=new User();
        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        return user;
    }
    public boolean createUser(User user) throws SQLException {
        Connection conn=Constants.getConnection();
        PreparedStatement ps=conn.prepareStatement(SQL_INSERT_USER,Statement.RETURN_GENERATED_KEYS);
        int k=1;
        ps.setString(1,user.getLogin());
        if (ps.executeUpdate()>0){
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()){
                user.setId(rs.getInt(1));
                return true;
            }
        }
        return false;
    }

    public boolean createGroup(Group group) throws SQLException {
        Connection connection=Constants.getConnection();
        PreparedStatement ps=connection.prepareStatement(SQL_INSERT_GROUP,Statement.RETURN_GENERATED_KEYS);
        int k=1;
        ps.setString(1,group.getName());
        if (ps.executeUpdate()>0){
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()){
                group.setId(rs.getInt(1));
                return true;
            }
        }
        return false;
    }

    public List<Group> findAllGroups() throws SQLException {
        List<Group> groups=new ArrayList<>();
        Connection conn=Constants.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(SQL_FIND_ALL_GROUPS);
        while (rs.next()){
            Group group=extractGroup(rs);
            groups.add(group);
        }
        return groups;
    }

    private Group extractGroup(ResultSet rs) throws SQLException {
        Group group=new Group();
        group.setId(rs.getInt(1));
        group.setName(rs.getString(2));
        return group;
    }
    public User getUser(String login) throws SQLException {
        User user=new User();
        Connection conn=Constants.getConnection();
        PreparedStatement ps=conn.prepareStatement(SQL_FIND_USER_BY_LOGIN);
        ps.setString(1,login);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
        }
        return user;
    }

    public Group getGroup(String name) throws SQLException {
        Group group=new Group();
        Connection conn=Constants.getConnection();
        PreparedStatement ps=conn.prepareStatement(SQL_FIND_GROUP_BY_NAME);
        ps.setString(1,name);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            group.setId(rs.getInt("id"));
            group.setName(rs.getString("name"));
        }
        return group;
    }

    public void setGroupsForUser(User user, Group... groups)  {
        Connection conn=null;
        try {
            conn=Constants.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps=conn.prepareStatement(SQL_INSERT_USER_GROUP);
            ps.setInt(1,user.getId());
            for (Group group:groups){
                ps.setInt(2,group.getId());
                ps.executeUpdate();
            }
            conn.commit();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            rollBack(conn);
        }
    }
    private void rollBack(Connection connection) {
        if (Objects.isNull(connection)){
            throw new NullPointerException();
        }else {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public List<Group> getUserGroups(User user) {
        List<Group> result=new ArrayList<>();
        try (Connection conn=Constants.getConnection()){
            PreparedStatement ps= conn.prepareStatement(SQL_FIND_USER_GROUPS);
            ps.setInt(1,user.getId());
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                result.add(getGroupById(rs.getInt("group_id")));
            }
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
        }
        return result;
    }

    private Group getGroupById(int id) {
        Group group=new Group();
        try (Connection conn=Constants.getConnection()){
            PreparedStatement ps=conn.prepareStatement(SQL_FIND_GROUP_BY_ID);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                group.setId(id);
                group.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
        }
        return group;
    }

    public void deleteGroup(Group team) {
        try (Connection conn=Constants.getConnection()){
            PreparedStatement pr=conn.prepareStatement(SQL_DELETE_GROUP);
            pr.setInt(1,team.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGroup(Group team) {
        try (Connection conn=Constants.getConnection()){
            PreparedStatement pr=conn.prepareStatement(SQL_UPDATE_GROUP);
            pr.setString(1,team.getName());
            pr.setInt(2,team.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
