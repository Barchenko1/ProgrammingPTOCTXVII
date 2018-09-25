package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;

import java.io.Console;
import java.util.InputMismatchException;

class Helper{
    public void readFromConsole() {
        Console con = System.console();
        if (con != null) {
            con.printf("Введите числовой код:");
            int code = 0;
            try {
                code = Integer.valueOf(con.readLine());
                System.out.println("Код доступа:" + code); } catch (InputMismatchException e) {
                con.printf("неправильный формат кода" + e);
            }
            if (code != 0) {
                con.printf("Введите пароль:");
                String password;
                char passTemp[] =
                        con.readPassword("Введите пароль: ");
                password = new String(passTemp);
                System.out.println("Пароль:" + password);
            }
        } else {
            System.out.println("Консоль недоступна");
        }
    }
}

public class Runner5 {
    public static void main(String[] args) {
        Helper helper=new Helper();
        helper.readFromConsole();

    }
}
