package me.Elliott_.Validator.exceptions.fitlterExceptions;

import org.jdom2.Element;

public class UnknownFilterException extends Exception {

    private static final long serialVersionUID = 6L;

    private Element element;
    private String attribute;

    public UnknownFilterException(String attribute, Element element) {
        this.element = element;
        this.attribute = attribute;
    }

    public UnknownFilterException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return this.element.getName() + " is contains an unknown filter: " + attribute;
    }

}
