package me.Elliott_.Validator.exceptions;

import org.jdom2.Element;

public class UnknownElementException extends Exception {

    private static final long serialVersionUID = 5L;

    private Element element;

    public UnknownElementException(Element element) {
        this.element = element;
    }

    public UnknownElementException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return this.element.getName() + " is an unknown element: " ;
    }

}
