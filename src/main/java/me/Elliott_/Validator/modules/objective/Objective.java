package me.Elliott_.Validator.modules.objective;

import me.Elliott_.Validator.exceptions.UnknownAttributeException;
import me.Elliott_.Validator.modules.PGMElement;
import org.jdom2.Attribute;
import org.jdom2.Element;

public class Objective extends PGMElement {

    private final Element element;

    public Objective(Element element) {
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
