package com.ayatventure.ayatventure.persistence.http;

import com.ayatventure.ayatventure.model.Surah;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiAllSurahsResponse {

    @JsonProperty("chapters")
    private List<Surah> surahList;
}
