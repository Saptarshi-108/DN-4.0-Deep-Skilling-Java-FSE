package Week1_DesignPrinciplesandPattern.Exercise_2_ImplementingtheFactoryMethodPattern.Code;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document.");
    }
}