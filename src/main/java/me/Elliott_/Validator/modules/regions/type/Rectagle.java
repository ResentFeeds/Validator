package me.Elliott_.Validator.modules.regions.type;

import me.Elliott_.Validator.exceptions.InvalidAttributeException;
import me.Elliott_.Validator.exceptions.MissingAttributeException;
import me.Elliott_.Validator.exceptions.UnknownAttributeException;
import me.Elliott_.Validator.modules.PGMElement;
import me.Elliott_.Validator.types.regions.TwoValues;
import me.Elliott_.Validator.utils.RegexUtil;
import org.jdom2.Attribute;
import org.jdom2.Element;

import java.util.Arrays;
import java.util.List;

public class Rectagle extends PGMElement {

    private final Element element;

    public Rectagle(Element element) {
        this.element = element;
    }

    private final String[] requiredAttributes = {"min", "max"};
    private final List<String> attributes = Arrays.asList("min", "max", "name");

    @Override
    public void validate() throws Exception {
        if (element.getName().equals("rectangle")) {
            for (String required : requiredAttributes) {
                if (element.getAttribute(required) == null) throw new MissingAttributeException(element, required);
            }
            for (Attribute attribute : element.getAttributes()) {
                if (!attributes.contains(attribute.getName())) throw new UnknownAttributeException(element, attribute);
                else if (!RegexUtil.validateRegex(attribute.getValue(), TwoValues.getRegex())) throw new InvalidAttributeException(attribute, element);
            }
        }
    }
}
