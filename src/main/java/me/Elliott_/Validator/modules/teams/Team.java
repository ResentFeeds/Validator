package me.Elliott_.Validator.modules.teams;

import me.Elliott_.Validator.exceptions.MissingAttributeException;
import me.Elliott_.Validator.exceptions.UnknownAttributeException;
import me.Elliott_.Validator.modules.PGMElement;
import org.jdom2.Attribute;
import org.jdom2.Element;

import java.util.Arrays;
import java.util.List;

public class Team extends PGMElement {

    private final Element element;

    public Team(Element rulesElement) {
        this.element = rulesElement;
    }

    private final String[] requiredAttributes = {"color", "max"};
    private final List<String> attributes = Arrays.asList("id", "color", "max", "max-overfill", "respawn-limit");

    @Override
    public void validate() throws Exception {
        if (element.getName().equals("contributor")) {
            for (String required : requiredAttributes) {
                if (element.getAttribute(required) == null) throw new MissingAttributeException(element, required);
            }
            for (Attribute attribute : element.getAttributes()) {
                if (!attributes.contains(attribute.getName())) throw new UnknownAttributeException(element, attribute);
            }
        }
    }
}
