package com.ll.in_pli01;

import com.ll.in_pli01.domain.Playlist;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit() {
            System.out.println("Init1" + this.getClass());

            Playlist p1 = createPlaylist("Dream Lantern", "RADWIMPS", "https://example.com/audio1.mp3");
            Playlist p2 = createPlaylist("Lemon", "Yonezu Kenshi", "https://example.com/audio2.mp3");
            Playlist p3 = createPlaylist("夜に駆ける", "YOASOBI", "https://example.com/audio3.mp3");
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
        }

        private Playlist createPlaylist(String title, String artist, String streamUrl) {
            Playlist playlist = new Playlist();
            playlist.setTitle(title);
            playlist.setArtist(artist);
            playlist.setStreamUrl(streamUrl);
            return playlist;
        }
    }
}
