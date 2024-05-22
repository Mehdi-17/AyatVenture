package com.ayatventure.ayatventure.quran.DTO.apiResponse;

import com.ayatventure.ayatventure.quran.DTO.AyatDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiRandomVerseResponseDTO {

    @JsonProperty("verse")
    private AyatDTO ayatDTO;
}
