package me.Elliott_.Validator;

import me.Elliott_.Validator.exceptions.UnknownElementException;
import me.Elliott_.Validator.modules.ElementBuilder;
import me.Elliott_.Validator.modules.PGMElement;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;

public class Validator {

    private static Document document;

    public static void main(String[] args) {
        SAXBuilder saxBuilder = new SAXBuilder();
        document = null;
        try {
            document = saxBuilder.build(new File("test.xml"));
        } catch (JDOMException | IOException e) {
            System.err.println(e.getMessage());
        }
        if (document != null) {
            PGMElement root = ElementBuilder.getPGMElement(document.getRootElement());
            try {
                root.validate();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            for (Element element : document.getRootElement().getChildren()) {
                try {
                    PGMElement pgmElement = ElementBuilder.getPGMElement(element);
                    if (pgmElement != null)
                        pgmElement.validate();
                    else throw new UnknownElementException(element);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }

    }
}
