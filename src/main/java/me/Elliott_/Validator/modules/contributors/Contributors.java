package me.Elliott_.Validator.modules.contributors;

import me.Elliott_.Validator.exceptions.UnknownElementException;
import me.Elliott_.Validator.modules.PGMElement;
import me.Elliott_.Validator.modules.authors.Author;
import org.jdom2.Element;

public class Contributors extends PGMElement {

    private final Element element;

    public Contributors(Element element) {
        this.element = element;
    }


    @Override
    public void validate() throws Exception {
        if (element.getName().equals("contributors")) {
            if (element.getChildren() != null) {
                for (Element child : element.getChildren()) {
                    if (child.getName().toLowerCase().equals("contributor"))
                        new Contributor(child).validate();
                    else throw new UnknownElementException(child);
                }
            }
        }
    }

}
