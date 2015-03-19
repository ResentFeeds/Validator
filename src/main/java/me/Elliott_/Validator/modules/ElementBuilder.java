package me.Elliott_.Validator.modules;

import me.Elliott_.Validator.modules.authors.Author;
import me.Elliott_.Validator.modules.authors.Authors;
import me.Elliott_.Validator.modules.contributors.Contributor;
import me.Elliott_.Validator.modules.contributors.Contributors;
import me.Elliott_.Validator.modules.map.Map;
import me.Elliott_.Validator.modules.name.Name;
import me.Elliott_.Validator.modules.objective.Objective;
import me.Elliott_.Validator.modules.regions.type.*;
import me.Elliott_.Validator.modules.rules.Rule;
import me.Elliott_.Validator.modules.rules.Rules;
import me.Elliott_.Validator.modules.teams.Team;
import me.Elliott_.Validator.modules.teams.Teams;
import org.jdom2.Element;

public class ElementBuilder {

    public static PGMElement getPGMElement(Element element) {
        switch (element.getName().toLowerCase()) {
            case "map":
                return new Map(element);
            case "rules":
                return new Rules(element);
            case "rule":
                return new Rule(element);
            case "name":
                return new Name(element);
            case "objective":
                return new Objective(element);
            case "authors":
                return new Authors(element);
            case "author":
                return new Author(element);
            case "contributors":
                return new Contributors(element);
            case "contributor":
                return new Contributor(element);
            case "teams":
                return new Teams(element);
            case "team":
                return new Team(element);
            case "cuboid":
                return new Block(element);
            case "cylinder":
                return new Cylinder(element);
            case "empty":
                return new Empty(element);
            case "point":
                return new Point(element);
            case "rectangle":
                return new Rectagle(element);
            case "sphere":
                return new Sphere(element);
            default:
                return null;
        }
    }

}
