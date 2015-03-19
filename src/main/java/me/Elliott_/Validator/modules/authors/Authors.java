package me.Elliott_.Validator.modules.authors;

import me.Elliott_.Validator.exceptions.UnknownElementException;
import me.Elliott_.Validator.modules.PGMElement;
import me.Elliott_.Validator.modules.rules.Rule;
import org.jdom2.Element;

public class Authors extends PGMElement {

    private final Element element;

    public Authors(Element element) {
        this.element = element;
    }


    @Override
    public void validate() throws Exception {
        if (element.getName().equals("authors")) {
            if (element.getChildren() != null) {
                for (Element child : element.getChildren()) {
                    if (child.getName().toLowerCase().equals("author"))
                        new Author(child).validate();
                    else throw new UnknownElementException(child);
                }
            }
        }
    }
}
