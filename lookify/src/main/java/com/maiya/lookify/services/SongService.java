package com.maiya.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiya.lookify.models.Song;
import com.maiya.lookify.repositories.SongRepository;

@Service
public class SongService {
	@Autowired
    SongRepository sr;
    
    // returns all the songs
    public List<Song> allSongs() {
        return sr.findAll();
    }
    // creates a song
    public Song createSong(Song b) {
        return sr.save(b);
    }
    // retrieves a song
    public Song findSong(Long id) {
        Optional<Song> optionalSong = sr.findById(id);
        if(optionalSong.isPresent()) { 
            return optionalSong.get();
        } else {
            return null;
        }
    }
    // find songs by an artist
    public List<Song> searchSongs(String artist) {
    	return sr.findByArtistContaining(artist);
    }
    
    public List<Song> topTenSongs() {
    	return sr.findTop10ByOrderByRatingDesc();
    }
    
	public Song updateSong(Long id, String title, String artist, Integer rating) {
		Song currentSong = sr.findById(id).get();
		currentSong.setTitle(title);
		currentSong.setArtist(artist);
		currentSong.setRating(rating);
		sr.save(currentSong);
		return currentSong;
	}
	public Song updateSong(Long id, Song song) {
		Song currentSong = sr.findById(id).get();
		currentSong.setTitle(song.getTitle());
		currentSong.setArtist(song.getArtist());
		currentSong.setRating(song.getRating());
		sr.save(currentSong);
		return currentSong;
	}
	public void deleteSong(Long id) {
		sr.deleteById(id);
	}
}
