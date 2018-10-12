package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice8;

import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) throws SQLException {
        DBManager dbManager = DBManager.getInstance();
        System.out.println("===========================");
        dbManager.createUser(User.createUser("petrov"));
        dbManager.createUser(User.createUser("obama"));
        System.out.println(dbManager.findAllUsers());
        System.out.println("===========================");
        dbManager.createGroup(Group.createGroup("teamB"));
        dbManager.createGroup(Group.createGroup("teamC"));
        System.out.println(dbManager.findAllGroups());
        System.out.println("===========================");
        User userPetrov = dbManager.getUser("petrov");
        User userIvanov = dbManager.getUser("ivanov");
        User userObama = dbManager.getUser("obama");
        Group teamA = dbManager.getGroup("teamA");
        Group teamB = dbManager.getGroup("teamB");
        Group teamC = dbManager.getGroup("teamC");
        dbManager.setGroupsForUser(userIvanov, teamA);
        dbManager.setGroupsForUser(userPetrov, teamA, teamB);
        dbManager.setGroupsForUser(userObama, teamA, teamB, teamC);
        for (User user : dbManager.findAllUsers()) {
            System.out.println(dbManager.getUserGroups(user));
        }
        System.out.println("===========================");
        dbManager.deleteGroup(teamA);
        System.out.println("===========================");
        teamC.setName("teamX");
        dbManager.updateGroup(teamC);
        System.out.println(dbManager.findAllGroups());
    }
}
