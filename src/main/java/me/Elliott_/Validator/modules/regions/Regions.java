package me.Elliott_.Validator.modules.regions;

import me.Elliott_.Validator.exceptions.UnknownElementException;
import me.Elliott_.Validator.modules.ElementBuilder;
import me.Elliott_.Validator.modules.PGMElement;
import me.Elliott_.Validator.modules.authors.Author;
import org.jdom2.Element;

public class Regions extends PGMElement {

    private final Element element;

    public Regions(Element rulesElement) {
        this.element = rulesElement;
    }


    @Override
    public void validate() throws Exception {
        if (element.getName().equals("regions")) {
            if (element.getChildren() != null) {
                for (Element child : element.getChildren()) {
                    PGMElement PGMChild = ElementBuilder.getPGMElement(child);
                    if (PGMChild != null) {
                        PGMChild.validate();
                    } else throw new UnknownElementException(child);
                }
            }
        }
    }
}
