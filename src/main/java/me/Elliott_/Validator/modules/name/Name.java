package me.Elliott_.Validator.modules.name;

import me.Elliott_.Validator.exceptions.UnknownAttributeException;
import me.Elliott_.Validator.modules.PGMElement;
import org.jdom2.Attribute;
import org.jdom2.Element;

public class Name extends PGMElement {

    private final Element element;

    public Name(Element element) {
        this.element = element;
    }

    @Override
    public void validate() throws Exception {
        if (element.hasAttributes()) {
            for (Attribute attribute : element.getAttributes()) {
                throw new UnknownAttributeException(element, attribute);
            }
        }
    }
}
