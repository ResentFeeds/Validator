package me.Elliott_.Validator.exceptions.fitlterExceptions;

import org.jdom2.Element;

public class UnknownBlockException extends Exception {

    private static final long serialVersionUID = 8L;

    private Element element;
    private String block;

    public UnknownBlockException(String block, Element element) {
        this.element = element;
        this.block = block;
    }

    public UnknownBlockException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return this.element.getName() + " is contains an unknown block: " + block;
    }
}
