package com.example.demo.musicfiledata;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//import com.example.demo.credentials.ResourceNotFoundException;
@RestController
@RequestMapping("/songs")
public class SongController {
	
	
	@Autowired
	private SongRepository songrep;
	
	@PostMapping("/uploadsongdata")
	public String songdata_upload(@Validated @RequestBody SongData sdata) {
		
		if(!songrep.existsById(sdata.getSongID()))
		{
			songrep.save(sdata);
		}
		else return "song data exists already";
		return "DATA SUCCESSFULLY SAVED";
	}
	@GetMapping("/getsongdetails/songname/{songname}")
	public List<SongData> displaysong(@PathVariable String songname) {
		 return songrep.findBySongnameIgnoreCase(songname);
	}
	
	@GetMapping("/getsongdetails/singer/{singername}")
	public List<SongData> displaysong1(@PathVariable String singername) {
		 return songrep.findBySingernameIgnoreCase(singername);
	}
	@GetMapping("/getsongdetails/album/{albumname}")
	public List<SongData> displaysong2(@PathVariable String albumname) {
		 return songrep.findByAlbumnameIgnoreCase(albumname);
	}
	@GetMapping("/getsongdetails/genre/{genre}")
	public List<SongData> displaysong3(@PathVariable String genre) {
		 return songrep.findByGenreIgnoreCase(genre);
	}
	@GetMapping("/getsongdetails/{username}")
	public List<SongData> displaysong4(@RequestParam String username){
		return songrep.findByUsername(username);
	}
	
	@GetMapping("/getsongdetails/{username}/songname/{songname}")
	public List<SongData> displayusersong(@RequestParam String username , @PathVariable String songname) {
		
		 if(songrep.findBySongnameIgnoreCase(songname) == songrep.findByUsername(username)) {
			 return songrep.findByUsername(username);
		 }
		 return songrep.findByUsername(username);
	}
	
	@GetMapping("/getsongdetails/{username}/singer/{singername}")
	public List<SongData> displayusersong1(@RequestParam String username, @PathVariable String singername) {
		 if(songrep.findBySingernameIgnoreCase(singername) == songrep.findByUsername(username)) {
			 return songrep.findByUsername(username);
		 }
		 return songrep.findByUsername(username);
	}
	@GetMapping("/getsongdetails/{username}/album/{albumname}")
	public List<SongData> displayusersong2(@RequestParam String username ,@PathVariable String albumname) {
		 if(songrep.findByAlbumnameIgnoreCase(albumname) == songrep.findByUsername(username)) {
			 return songrep.findByUsername(username);
		 }
		 return songrep.findByUsername(username);
	}
	@GetMapping("/getsongdetails/{username}/genre/{genre}")
	public List<SongData> displayusersong3(@RequestParam String username ,@PathVariable String genre) {
		 if(songrep.findByGenreIgnoreCase(genre) == songrep.findByUsername(username)) {
			 return songrep.findByUsername(username);
		 }
		 return songrep.findByUsername(username);
	}
	}
