package me.Elliott_.Validator.modules.filters.types.matchers;

import me.Elliott_.Validator.exceptions.fitlterExceptions.UnknownFilterException;
import me.Elliott_.Validator.exceptions.fitlterExceptions.UnknownTeamException;
import me.Elliott_.Validator.modules.PGMElement;
import me.Elliott_.Validator.utils.FilterUtil;
import org.jdom2.Element;

public class Team extends PGMElement {

    private Element element;

    public Team(Element element) {
        this.element = element;
    }

    @Override
    public void validate() throws Exception {
        if (!FilterUtil.checkBlocks(element.getValue()))
            throw new UnknownTeamException(element.getValue(), element);
    }
}
