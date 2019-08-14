package com.maiya.lookify.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maiya.lookify.models.Song;
import com.maiya.lookify.services.SongService;

@Controller
public class LookifyController {
	@Autowired
	SongService ss;

//	******************
//	show home
//	******************
	@GetMapping("/")
	public String home() {
		return "/WEB-INF/lookify/home.jsp";
	}
//	******************
//	show top ten songs
//	******************
	@GetMapping("/search/TopTen")
	public String topTen(Model model) {
		List<Song> songs = ss.topTenSongs();
		model.addAttribute("songs", songs);
		return "/WEB-INF/lookify/topTen.jsp";
	}
//	******************
//	show all songs with search
//	******************
	@PostMapping("/search")
	public String search(Model model, HttpServletRequest request) {
		String artist = request.getParameter("searchArtist");
//		if (artist.equals("TopTen")) {
//			List<Song> songs = ss.topTenSongs();
//			model.addAttribute("songs", songs);
//			return "/WEB-INF/lookify/topTen.jsp";
//		} else {
			List<Song> songs = ss.searchSongs(artist);
			model.addAttribute("songs", songs);
			model.addAttribute("artist", artist);
			return "/WEB-INF/lookify/search.jsp";
//		}
		
	}
//	******************
//	show all songs
//	******************
	@GetMapping("/dashboard")
	public String index(Model model) {
		List<Song> songs = ss.allSongs();
		model.addAttribute("songs", songs);
		return "/WEB-INF/lookify/index.jsp";
	}

//	******************
//	show one song
//	******************
	@GetMapping("/songs/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Song song = ss.findSong(id);
		model.addAttribute("song", song);
		return "/WEB-INF/lookify/show.jsp";
	}

//	******************
//	add song
//	******************
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "/WEB-INF/lookify/new.jsp";
	}

	@PostMapping(value = "/songs")
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "/WEB-INF/lookify/new.jsp";
		} else {
			ss.createSong(song);
			return "redirect:/dashboard";
		}
	}

//	******************
//    edit song
//	******************
	@GetMapping("/songs/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Song song = ss.findSong(id);
		model.addAttribute("song", song);
		return "/WEB-INF/lookify/edit.jsp";
	}

	@PutMapping(value = "/songs/{id}")
	public String update(@Valid @ModelAttribute("song") Song song, BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "/WEB-INF/lookify/edit.jsp";
		} else {
			ss.updateSong(id, song);
			return "redirect:/dashboard";
		}
	}

//	******************
//    delete song
//	******************
	@DeleteMapping(value = "/songs/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		ss.deleteSong(id);
		return "redirect:/dashboard";
	}
}
