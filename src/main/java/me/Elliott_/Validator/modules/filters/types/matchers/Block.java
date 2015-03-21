package me.Elliott_.Validator.modules.filters.types.matchers;

import me.Elliott_.Validator.exceptions.fitlterExceptions.UnknownBlockException;
import me.Elliott_.Validator.exceptions.fitlterExceptions.UnknownFilterException;
import me.Elliott_.Validator.modules.PGMElement;
import me.Elliott_.Validator.utils.FilterUtil;
import org.jdom2.Element;

public class Block extends PGMElement {

    private Element element;

    public Block(Element element) {
        this.element = element;
    }

    @Override
    public void validate() throws Exception {
        if (!FilterUtil.checkTeams(element.getValue(), element.getDocument()))
            throw new UnknownBlockException(element.getValue(), element);
    }
}
