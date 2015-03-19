package me.Elliott_.Validator.modules.map;

import me.Elliott_.Validator.exceptions.UnknownElementException;
import me.Elliott_.Validator.modules.PGMElement;
import me.Elliott_.Validator.exceptions.InvalidAttributeException;
import me.Elliott_.Validator.exceptions.MissingAttributeException;
import me.Elliott_.Validator.exceptions.UnknownAttributeException;
import me.Elliott_.Validator.utils.ProtocolUtil;
import org.jdom2.Attribute;
import org.jdom2.Element;

import java.util.Arrays;
import java.util.List;

public class Map extends PGMElement {

    private final Element element;

    public Map(Element element) {
        this.element = element;
    }

    private final String[] requiredAttributes = {"proto"};
    private final List<String> attributes = Arrays.asList("proto", "internal");

    @Override
    public void validate() throws Exception {
        if (element.getName().equals("map")) {
            if (requiredAttributes != null) {
                for (String required : requiredAttributes) {
                    if (element.getAttribute(required) == null) throw new MissingAttributeException(element, required);
                }
                for (Attribute attribute : element.getAttributes()) {
                    if (attributes.contains(attribute.getName())) {
                        if (attribute.getName().equals("proto"))
                            if (ProtocolUtil.validateProto(attribute.getValue())) {
                                if (!ProtocolUtil.getCurrentMapProto().equals(attribute.getValue()))
                                    System.err.println("WARNING: protocol: " + attribute.getValue() + " is not up to date with: " + ProtocolUtil.getCurrentMapProto());
                            } else
                                throw new InvalidAttributeException(attribute, element);
                        if (attribute.getName().equals("internal")) {
                            if (!Boolean.parseBoolean(attribute.getValue()))
                                throw new InvalidAttributeException(attribute, element);
                        }

                    } else throw new UnknownAttributeException(element, attribute);
                }
            }
        }
    }
}
