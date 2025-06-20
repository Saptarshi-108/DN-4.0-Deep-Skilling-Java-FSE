package Week1_DesignPrinciplesandPattern.Exercise_2_ImplementingtheFactoryMethodPattern.Code;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document.");
    }
}