package ua.org.oa.evlashdv.lectures.lecture1.patterns;

public class Expert {
    private int idTest;
    private int numberQuest;
    private String testName;
    private int currentNumberQuest;

    public Expert(int idTest, int numberQuest, String testName, int currentNumberQuest) {
        this.idTest = idTest;
        this.numberQuest = numberQuest;
        this.testName = testName;
        this.currentNumberQuest = currentNumberQuest;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public int getNumberQuest() {
        return numberQuest;
    }

    public void setNumberQuest(int numberQuest) {
        this.numberQuest = numberQuest;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getCurrentNumberQuest() {
        return currentNumberQuest;
    }

    public void setCurrentNumberQuest(int currentNumberQuest) {
        this.currentNumberQuest = currentNumberQuest;
    }
}
class LineRequestQuest{
    private int questID;

    public LineRequestQuest(int questID) {
        this.questID = questID;
    }

    public int getQuestID() {
        return questID;
    }

    public void setQuestID(int questID) {
        this.questID = questID;
    }
}
class Quest{
    private int idQuest;
    private int testID;

    public Quest(int idQuest, int testID) {
        this.idQuest = idQuest;
        this.testID = testID;
    }

    public int getIdQuest() {
        return idQuest;
    }

    public void setIdQuest(int idQuest) {
        this.idQuest = idQuest;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }
}