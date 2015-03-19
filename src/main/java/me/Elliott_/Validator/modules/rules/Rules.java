package me.Elliott_.Validator.modules.rules;

import me.Elliott_.Validator.exceptions.UnknownAttributeException;
import me.Elliott_.Validator.exceptions.UnknownElementException;
import me.Elliott_.Validator.modules.PGMElement;
import org.jdom2.Element;

public class Rules extends PGMElement {

    private final Element element;

    public Rules(Element rulesElement) {
        this.element = rulesElement;
    }


    @Override
    public void validate() throws Exception {
        if (element.getName().equals("rules")) {
            if (element.getChildren() != null) {
                for (Element child : element.getChildren()) {
                    if (child.getName().toLowerCase().equals("rule"))
                        new Rule(child).validate();
                    else throw new UnknownElementException(child);
                }
            }
        }
    }
}
