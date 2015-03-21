package me.Elliott_.Validator.modules.filters;

import me.Elliott_.Validator.exceptions.UnknownElementException;
import me.Elliott_.Validator.modules.ElementBuilder;
import me.Elliott_.Validator.modules.PGMElement;
import org.jdom2.Element;

import java.util.Arrays;
import java.util.List;

public class Filters extends PGMElement {

    private final Element element;

    public Filters(Element element) {
        this.element = element;
    }


    @Override
    public void validate() throws Exception {
        if (element.getName().equals("regions")) {
            if (element.getChildren() != null) {
                for (Element child : element.getChildren()) {
                    if (child.getName().equals("filter")) {
                        PGMElement PGMChild = ElementBuilder.getPGMElement(child);
                        if (PGMChild != null) {
                            PGMChild.validate();
                        } else throw new UnknownElementException(child);
                    } else throw new UnknownElementException(child);
                }
            }
        }
    }
}
