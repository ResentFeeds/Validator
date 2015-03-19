package me.Elliott_.Validator.exceptions;

import org.jdom2.Attribute;
import org.jdom2.Element;

public class UnknownAttributeException extends Exception {

    private static final long serialVersionUID = 4L;

    private Element element;
    private Attribute attribute;

    public UnknownAttributeException(Element element, Attribute attribute) {
        this.element = element;
        this.attribute = attribute;
    }

    public UnknownAttributeException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return this.element.getName() + " is contains an unknown attribute: " + this.attribute.getName();
    }

}
