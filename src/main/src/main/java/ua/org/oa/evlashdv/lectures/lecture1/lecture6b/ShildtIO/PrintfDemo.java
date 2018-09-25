package ua.org.oa.evlashdv.lectures.lecture1.lecture6b.ShildtIO;

public class PrintfDemo {
    public static void main(String[] args) {
        System.out.println("Ниже приведены некоторые числа значение которых в разных формах.\n");
        System.out.printf("Разные целочисленные формы: ");
        System.out.printf("%d %(d %+d %d05d\n", 3,-3,3, 3);
        System.out.println();

        System.out.printf("Форма числа с плавающей точкой по умолчанию: %f\n", 1234567.123);
        System.out.printf("Форма числа с плавающей точкой разделяемых запятыми: %,f\n", 1234567.123);
        System.out.printf("Форма отрицательного числа с плавающей точкой по умолчанию: %,f\n", -1234567.123);
        System.out.printf("Другая Форма отрицательного числа с плавающей точкой по умолчанию: %,(f\n", -1234567.123);

        System.out.println();

        System.out.printf("Выравниване положительных и отрицательных числовых значений:\n");
//        System.out.printf("% ,.2f\n% ,.2f\n",);
    }
}
