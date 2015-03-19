package me.Elliott_.Validator.modules.teams;

import me.Elliott_.Validator.exceptions.UnknownElementException;
import me.Elliott_.Validator.modules.PGMElement;
import me.Elliott_.Validator.modules.contributors.Contributor;
import org.jdom2.Element;

public class Teams extends PGMElement {

    private final Element element;

    public Teams(Element rulesElement) {
        this.element = rulesElement;
    }


    @Override
    public void validate() throws Exception {
        if (element.getName().equals("teams")) {
            if (element.getChildren() != null) {
                for (Element child : element.getChildren()) {
                    if (child.getName().toLowerCase().equals("team"))
                        new Team(child).validate();
                    else throw new UnknownElementException(child);
                }
            }
        }
    }

}
