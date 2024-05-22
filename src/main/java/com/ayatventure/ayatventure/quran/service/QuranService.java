package com.ayatventure.ayatventure.quran.service;

import com.ayatventure.ayatventure.quran.DTO.apiResponse.ApiAllSurahsResponseDTO;
import com.ayatventure.ayatventure.quran.DTO.SurahDTO;
import com.ayatventure.ayatventure.quran.DTO.apiResponse.ApiRandomVerseResponseDTO;
import com.ayatventure.ayatventure.quran.DTO.AyatDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class QuranService {

    @Value("${quran.api.url}")
    private String quranApiUrl;

    public AyatDTO getRandomAyat() {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        String getRandomVerseUrl = UriComponentsBuilder.fromUriString(quranApiUrl + "/verses/random")
                .queryParam("fields", "text_uthmani,chapter_id")
                .queryParam("translations", "31,779,136")
                .build()
                .toUriString();

        ResponseEntity<String> randomAyatResponse = restTemplate.getForEntity(getRandomVerseUrl, String.class);

        try {
            ApiRandomVerseResponseDTO apiRandomVerseResponseDTO = mapper.readValue(randomAyatResponse.getBody(), ApiRandomVerseResponseDTO.class);

            return apiRandomVerseResponseDTO.getAyatDTO();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SurahDTO> getAllSurahs(){
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        String getAllSurahUrl = UriComponentsBuilder.fromUriString(quranApiUrl + "/chapters")
                .queryParam("language", "fr")
                .build()
                .toUriString();

        ResponseEntity<String> allSurahsResponse = restTemplate.getForEntity(getAllSurahUrl, String.class);

        try {
            ApiAllSurahsResponseDTO apiAllSurahsResponseDTO = mapper.readValue(allSurahsResponse.getBody(), ApiAllSurahsResponseDTO.class);

            return apiAllSurahsResponseDTO.getSurahDTOList();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
