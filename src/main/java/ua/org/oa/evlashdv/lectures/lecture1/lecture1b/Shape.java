package ua.org.oa.evlashdv.lectures.lecture1.lecture1b;

import lombok.*;

public class Shape {
    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    @NoArgsConstructor
    static class Color{
        private int red;
        private int green;
        private int blue;

    }
}
