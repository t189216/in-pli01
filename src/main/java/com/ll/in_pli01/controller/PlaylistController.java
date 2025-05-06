package com.ll.in_pli01.controller;

import com.ll.in_pli01.domain.Playlist;
import com.ll.in_pli01.repository.PlaylistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class PlaylistController {

    private final  PlaylistRepository playlistRepository;

    public PlaylistController(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @GetMapping("/playlist")
    public String lists(Model model) {
        model.addAttribute("playlists", playlistRepository.findAll());
        return "playlist";
    }

    @PostMapping("/playlist")
    public String addList(@ModelAttribute Playlist list) {
        playlistRepository.save(list);
        return ("redirect:/");
    }
}
