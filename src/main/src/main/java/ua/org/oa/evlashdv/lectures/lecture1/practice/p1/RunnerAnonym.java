package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;
class TypeQuest{
    private int id=1;

    public TypeQuest() {
    }

    public TypeQuest(int id) {
        this.id = id;
    }
    void addNewType(){
        System.out.println("добавлен вопрос на соответствие");
    }
}
public class RunnerAnonym {
    public static void main(String[] args) {
        TypeQuest unique = new TypeQuest() {
            void addNewType(){
                System.out.println("добавлен вопрос со свободным ответом");
            }
        };
        unique.addNewType();
        new TypeQuest(71){
            private String name="Drag&Drop";

            public String getName() {
                return name;
            }

            void addNewType(){
                System.out.println("добавлен "+getName());
            }
        }.addNewType();
        TypeQuest standard=new TypeQuest(35);
        standard.addNewType();
    }
}
