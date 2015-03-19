package me.Elliott_.Validator.exceptions;

import org.jdom2.Element;

import java.util.Arrays;

public class MissingAttributeException extends Exception {

    private static final long serialVersionUID = 3L;

    private Element element;
    private String[] attributes;

    public MissingAttributeException(Element element, String... attributes) {
        this.element = element;
        this.attributes = attributes;
    }

    public MissingAttributeException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return this.element.getName() + " is missing a required attribute: " + Arrays.toString(this.attributes);
    }
}
