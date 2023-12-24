package com.ayatventure.ayatventure.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ayat {
    @JsonProperty("verse_key")
    private String key;

    @JsonProperty("text_uthmani")
    private String textArab;

    @JsonProperty("translations")
    private List<Translation> translations;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private record Translation(String text) {
    }
}
