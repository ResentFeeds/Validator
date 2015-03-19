package me.Elliott_.Validator.exceptions;

import org.jdom2.Attribute;
import org.jdom2.Element;

public class InvalidAttributeException extends Exception {

    private static final long serialVersionUID = 1L;

    private Attribute atttrubute;
    private Element element;

    public InvalidAttributeException(Attribute attribute, Element element) {
        this.atttrubute = attribute;
        this.element = element;
    }

    public InvalidAttributeException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return this.element.getName() + " contains an invalid attribute: " + this.atttrubute.getName() + " with an unknown value of: " + this.atttrubute.getValue();
    }

}
