package com.ayatventure.ayatventure.controller;

import com.ayatventure.ayatventure.model.Ayat;
import com.ayatventure.ayatventure.model.Surah;
import com.ayatventure.ayatventure.service.QuranService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("ayat")
public class AyatController {

    private QuranService quranService;

    //TODO : make thoses methods to return ResponseEntity rather than object

    @GetMapping("/random")
    public Ayat getRandomAyat() {
        return quranService.getRandomAyat();
    }

    @GetMapping("/surahs")
    public List<Surah> getAllSurahs() {
        return quranService.getAllSurahs();
    }
}
