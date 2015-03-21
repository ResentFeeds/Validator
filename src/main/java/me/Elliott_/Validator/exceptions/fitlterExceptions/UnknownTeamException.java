package me.Elliott_.Validator.exceptions.fitlterExceptions;

import org.jdom2.Element;

public class UnknownTeamException extends Exception {

    private static final long serialVersionUID = 7L;

    private Element element;
    private String team;

    public UnknownTeamException(String team, Element element) {
        this.element = element;
        this.team = team;
    }

    public UnknownTeamException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return this.element.getName() + " is contains an unknown team: " + team;
    }
}
