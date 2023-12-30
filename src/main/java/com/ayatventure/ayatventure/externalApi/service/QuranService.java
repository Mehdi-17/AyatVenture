package com.ayatventure.ayatventure.externalApi.service;

import com.ayatventure.ayatventure.externalApi.DTO.ApiAllSurahsResponseDTO;
import com.ayatventure.ayatventure.externalApi.DTO.SurahDTO;
import com.ayatventure.ayatventure.externalApi.DTO.ApiRandomVerseResponseDTO;
import com.ayatventure.ayatventure.externalApi.DTO.AyatDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class QuranService {

    public AyatDTO getRandomAyat() {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        //todo améliorer la construction des URL
        String GET_RANDOM_AYAT = "https://api.quran.com/api/v4/verses/random?fields=text_uthmani&translations=31,779,136";
        ResponseEntity<String> randomAyatResponse = restTemplate.getForEntity(GET_RANDOM_AYAT, String.class);

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

        String GET_ALL_SURAH = "https://api.quran.com/api/v4/chapters?language=fr";
        ResponseEntity<String> allSurahsResponse = restTemplate.getForEntity(GET_ALL_SURAH, String.class);

        try {
            ApiAllSurahsResponseDTO apiAllSurahsResponseDTO = mapper.readValue(allSurahsResponse.getBody(), ApiAllSurahsResponseDTO.class);

            return apiAllSurahsResponseDTO.getSurahDTOList();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
