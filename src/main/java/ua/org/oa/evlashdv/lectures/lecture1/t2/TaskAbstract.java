package ua.org.oa.evlashdv.lectures.lecture1.t2;

import java.io.File;

public class TaskAbstract{

    File fileNameIn;
    File fileNameOut;

    /**
     * @return the fileNameIn
     */
    public File getFileNameIn() {
        return fileNameIn;
    }

    /**
     * @param fileNameIn the fileNameIn to set
     */
    public void setFileNameIn(File fileNameIn) {
        this.fileNameIn = fileNameIn;
    }

    /**
     * @return the fileNameOut
     */
    public File getFileNameOut() {
        return fileNameOut;
    }

    /**
     * @param fileNameOut the fileNameOut to set
     */
    public void setFileNameOut(File fileNameOut) {
        this.fileNameOut = fileNameOut;
    }

}