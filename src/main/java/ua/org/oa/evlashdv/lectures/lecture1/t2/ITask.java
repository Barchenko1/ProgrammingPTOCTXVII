package ua.org.oa.evlashdv.lectures.lecture1.t2;
public interface ITask {
    public void loadFromFile() throws InvalidFileFormatException;
    public void solution();
    public void writeToFile();
}