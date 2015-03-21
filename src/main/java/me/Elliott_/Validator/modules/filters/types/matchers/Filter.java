package me.Elliott_.Validator.modules.filters.types.matchers;


import me.Elliott_.Validator.exceptions.MissingAttributeException;
import me.Elliott_.Validator.exceptions.fitlterExceptions.UnknownFilterException;
import me.Elliott_.Validator.modules.PGMElement;
import me.Elliott_.Validator.utils.FilterUtil;
import org.jdom2.Element;

public class Filter extends PGMElement {

    private Element element;

    public Filter(Element element) {
        this.element = element;
    }

    @Override
    public void validate() throws Exception {
        if (element.getAttribute("name") != null) {
            if (!FilterUtil.checkFilters("name", element.getDocument()))
                throw new UnknownFilterException("name", element);
        } else throw new MissingAttributeException(element, "name");
    }
}
