package ua.org.oa.evlashdv.lectures.lecture1.spring;

public class ProfileController implements spring.ProfileControllerMBean {
    private boolean enable=true;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
