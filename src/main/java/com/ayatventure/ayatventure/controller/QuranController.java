package com.ayatventure.ayatventure.controller;

import com.ayatventure.ayatventure.externalApi.DTO.AyatDTO;
import com.ayatventure.ayatventure.externalApi.DTO.SurahDTO;
import com.ayatventure.ayatventure.externalApi.service.QuranService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("quran")
public class QuranController {

    private QuranService quranService;

    //TODO : make those methods to return ResponseEntity rather than object

    @GetMapping("/random")
    public AyatDTO getRandomAyat() {
        return quranService.getRandomAyat();
    }

    @GetMapping("/surahs")
    public List<SurahDTO> getAllSurahs() {
        return quranService.getAllSurahs();
    }
}
