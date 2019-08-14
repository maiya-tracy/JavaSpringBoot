package com.maiya.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maiya.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	// this method retrieves all the songs from the database
		List<Song> findAll();

		// this method find a song by their artist
		List<Song> findByArtistContaining(String search);

		// this method counts how many titles contain a certain string
		Long countByTitleContaining(String search);

		// this method deletes a song that starts with a specific title
		Long deleteByTitleStartingWith(String search);
		
		// returns the top ten highest rated songs
		List<Song> findTop10ByOrderByRatingDesc();
}
