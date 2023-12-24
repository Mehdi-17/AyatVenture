package com.ayatventure.ayatventure.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum RevelationPlaceEnum {
    MADINAH("madinah"),
    MAKKAH("makkah");

    private final String label;

    RevelationPlaceEnum(String label) {
        this.label = label;
    }

    public Optional<RevelationPlaceEnum> getByLabel(String label){
        return Arrays.stream(RevelationPlaceEnum.values())
                .filter(revelationPlace -> revelationPlace.getLabel().equals(label))
                .findAny();
    }
}
