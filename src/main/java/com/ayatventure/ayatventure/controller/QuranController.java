package com.ayatventure.ayatventure.controller;

import com.ayatventure.ayatventure.externalApi.DTO.AyatDTO;
import com.ayatventure.ayatventure.externalApi.DTO.SurahDTO;
import com.ayatventure.ayatventure.externalApi.service.QuranService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("quran")
public class QuranController {

    private QuranService quranService;

    @GetMapping("/random")
    public ResponseEntity<AyatDTO> getRandomAyat() {
        return ResponseEntity.ok().body(quranService.getRandomAyat());
    }

    @GetMapping("/surahs")
    public ResponseEntity<List<SurahDTO>> getAllSurahs() {
        return ResponseEntity.ok().body(quranService.getAllSurahs());
    }
}
