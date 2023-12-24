package com.ayatventure.ayatventure.service;

import com.ayatventure.ayatventure.model.Surah;
import com.ayatventure.ayatventure.persistence.http.ApiAllSurahsResponse;
import com.ayatventure.ayatventure.persistence.http.ApiRandomVerseResponse;
import com.ayatventure.ayatventure.model.Ayat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class QuranService {

    public Ayat getRandomAyat() {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        //todo améliorer la construction des URL
        String GET_RANDOM_AYAT = "https://api.quran.com/api/v4/verses/random?fields=text_uthmani&translations=31,779,136";
        ResponseEntity<String> randomAyatResponse = restTemplate.getForEntity(GET_RANDOM_AYAT, String.class);

        try {
            ApiRandomVerseResponse apiRandomVerseResponse = mapper.readValue(randomAyatResponse.getBody(), ApiRandomVerseResponse.class);

            return apiRandomVerseResponse.getAyat();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Surah> getAllSurahs(){
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        String GET_ALL_SURAH = "https://api.quran.com/api/v4/chapters?language=fr";
        ResponseEntity<String> allSurahsResponse = restTemplate.getForEntity(GET_ALL_SURAH, String.class);

        try {
            ApiAllSurahsResponse apiAllSurahsResponse = mapper.readValue(allSurahsResponse.getBody(), ApiAllSurahsResponse.class);

            return apiAllSurahsResponse.getSurahList();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
