package me.Elliott_.Validator.modules.rules;

import me.Elliott_.Validator.modules.PGMElement;
import me.Elliott_.Validator.exceptions.UnknownAttributeException;
import org.jdom2.Attribute;
import org.jdom2.Element;

public class Rule extends PGMElement {

    private final Element element;

    public Rule(Element ruleElement) {
        this.element = ruleElement;
    }


    @Override
    public void validate() throws Exception {
        if (element.getName().equals("rule")) {
            if (element.hasAttributes()) {
                for (Attribute attribute : element.getAttributes())
                    throw new UnknownAttributeException(element, attribute);
            }
        }
    }
}
