package com.maiya.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maiya.lookify.models.Song;
import com.maiya.lookify.services.SongService;

@RestController
public class LookifyAPI {
	@Autowired
    SongService ss;

	@RequestMapping("/api/songs")
	public List<Song> index() {
		return ss.allSongs();
	}

	@RequestMapping(value = "/api/songs", method = RequestMethod.POST)
	public Song create(@RequestParam(value = "title") String title, @RequestParam(value = "artist") String artist, @RequestParam(value = "pages") Integer rating) {
		Song song = new Song(title, artist, rating);
		return ss.createSong(song);
	}

	@RequestMapping("/api/songs/{id}")
	public Song show(@PathVariable("id") Long id) {
		Song song = ss.findSong(id);
		return song;
	}
	
	@RequestMapping(value="/api/songs/{id}", method=RequestMethod.PUT)
    public Song update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="pages") Integer rating) {
        Song song = ss.updateSong(id, title, artist, rating);
        return song;
    }
    
    @RequestMapping(value="/api/songs/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
    	ss.deleteSong(id);
    }
}
