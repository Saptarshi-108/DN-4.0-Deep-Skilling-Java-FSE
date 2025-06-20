package Week1_DesignPrinciplesandPattern.Exercise_2_ImplementingtheFactoryMethodPattern.Code;

public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}