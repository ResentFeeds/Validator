package me.Elliott_.Validator.exceptions;


import org.jdom2.Element;

public class InvalidElementException extends Exception {

    private static final long serialVersionUID = 2L;

    private Element element;

    public InvalidElementException(Element element) {
        this.element = element;
    }

    public InvalidElementException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return this.element.getName() + " contains an invalid element: " + this.element.getValue();
    }
}
