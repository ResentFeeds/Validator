package me.Elliott_.Validator.utils;

import me.Elliott_.Validator.types.Material;
import me.Elliott_.Validator.types.SpawnReason;
import org.jdom2.Document;
import org.jdom2.Element;

public class FilterUtil {

    public static boolean checkFilters(String filter, Document document) {
        if (document.getRootElement().getChild("filters").getChildren() != null) {
            for (Element element : document.getRootElement().getChild("filters").getChildren()) {
                if (element.getAttribute("name") != null) {
                    if (filter.equals(element.getAttributeValue("name"))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkTeams(String team, Document document) {
        if (document.getRootElement().getChild("teams").getChildren() != null) {
            for (Element element : document.getRootElement().getChild("teams").getChildren()) {
                if (element.getAttribute("id") != null) {
                    if (element.getAttributeValue("id").equals(team))
                        return true;
                }
                if (element.getValue().equals(team))
                    return true;
            }
        }
        return false;
    }

    public static boolean checkBlocks(String block) {
        for (Material material : Material.values()) {
            if (material.toString().equals(block.toUpperCase().replace(' ', '_')))
                return true;
        }
        return false;
    }

    public static boolean checkSpawnReason(String spawn) {
        for (SpawnReason spawnReason : SpawnReason.values()) {
            if (spawnReason.toString().equals(spawn.toUpperCase().replace(' ', '_')))
                return true;
        }
        return false;
    }


}
