package ua.org.oa.evlashdv.lectures.lecture1.lecture1b;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Clothing {
    private String name;
    private int price;

    public void wash() {

    }
}
