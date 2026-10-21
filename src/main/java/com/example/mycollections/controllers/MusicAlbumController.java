package com.example.mycollections.controllers;

import com.example.mycollections.models.Book;
import com.example.mycollections.models.MusicAlbum;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/albums")
public class MusicAlbumController {

    private final List<MusicAlbum> albums = new ArrayList<>() {{

        add(new MusicAlbum("Thriller", "Michael Jackson", 1982, 9));
        add(new MusicAlbum("25", "Adele", 2015, 11));
        add(new MusicAlbum("Lemonade", "Beyonce",2016, 12));
    }};

    @GetMapping("/json")
    public List<MusicAlbum> getAlbumsJson() {
        return albums;
    }

    @GetMapping("/html")
    public String getAlbumsHtml(){
        String albumList = "<ul>";

        for(MusicAlbum album : albums) {
            albumList += "<li>" + album + "<li>";
        }

        albumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Albums</h1>
                        <ul>
                """ +
                albumList +
                """
                        </ul>
                    </body>
                """;
    }



}
