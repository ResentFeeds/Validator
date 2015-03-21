package me.Elliott_.Validator.modules.filters.types;

import java.util.ArrayList;
import java.util.List;

public enum MasterFilter {

    ALLOW_ALL, DENY_ALL, ALLOW_PLAYERS, DENY_PLAYERS, ALLOW_BLOCKS, DENY_BLOCKS, ALLOW_WORLD, DENY_WORLD, ALLOW_SPAWNS, DENY_SPAWNS, ALLOW_ENTITIES, DENY_ENTITIES, ALLOW_MOBS, DENY_MOBS;

    public MasterFilter[] getMasterFilters() {
        return MasterFilter.values();
    }

    public List<String> getStringMasterFilter() {
        List<String> masterFilters = new ArrayList<>();
        for (MasterFilter masterFilter : getMasterFilters()) {
            masterFilters.add(masterFilter.toString().toLowerCase().replace('_', '-'));
        }
        return masterFilters;
    }

}

