package com.ayatventure.ayatventure.controller;

import com.ayatventure.ayatventure.model.ApiRandomVerseResponse;
import com.ayatventure.ayatventure.model.Ayat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("ayat")
public class AyatController {

    public AyatController() {
    }

    @GetMapping("/random")
    public Ayat getRandomAyat(){
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        String GET_RANDOM_AYAT = "https://api.quran.com/api/v4/verses/random?fields=text_uthmani&translations=31,779,136";
        ResponseEntity<String> randomAyatResponse = restTemplate.getForEntity(GET_RANDOM_AYAT, String.class);

        try {
            ApiRandomVerseResponse apiRandomVerseResponse = mapper.readValue(randomAyatResponse.getBody(), ApiRandomVerseResponse.class);

            return apiRandomVerseResponse.getAyat();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
