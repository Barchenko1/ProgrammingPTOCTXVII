package ua.org.oa.evlashdv.lectures.lecture1.xml;

import java.io.InputStream;

public abstract class ProductParser {
    public abstract void parse(InputStream input);
    void writeTitle(){
        System.out.println("Products:");
    }
    void writeCategoryStart(String name){
        System.out.println("Category: "+name.trim());
    }
    public void writeCategoryEnd() {
        System.out.println();
    }
    public void writeSubcategoryStart(String name) {
        System.out.println("Subcategory: " + name.trim());
    }
    public void writeSubcategoryEnd() {
        System.out.println();
    }
    public void writeProductStart() {
        System.out.println(" Product Start ");
    }
    public void writeProductEnd() {
        System.out.println(" Product End ");
    }
    void writeProductFeatureStart(String name){
        switch (ParserEnum.valueOf(name.toUpperCase())){
            case PRODUCT:
                System.out.println("Provider: ");break;
            case MODEL:
                System.out.println("Model: "); break;
            case YEAR:
                System.out.println("Date of issue: ");break;
            case COLOR:
                System.out.println("Color: "); break;
            case NOTAVAILABLE:
                System.out.println("Not available");break;
            case COST:
                System.out.println("Cost");break;
        }
    }
    public void writeProductFeatureEnd() {
        System.out.println();
    }
    public void writeText(String text) {
        System.out.print(text.trim());
    }
}
