package ua.org.oa.evlashdv.lectures.lecture1.lecture7b.wait;

public class App {
    public static void main(String[] args) {
        Clock clock=new Clock();
        ChessMan chessMan1=new ChessMan("Vasya",clock,Color.WHITE);
        ChessMan chessMan2=new ChessMan("Sveta",clock,Color.BLACK);

        chessMan1.start();
        chessMan2.start();
    }
}
