package com.example.demo.musicfiledata;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "songdata")
public class SongData {

	
	@Id
	private long songID = (long)Math.random()*10000000;
	
	@Field(name="Username")
	private String username;
	
	@Field(name="Genre")
	private String genre;
	
	@Field(name="AlbumName")
	@Indexed(unique = true)
	private String albumname;
	
	@Field(name="SongName")
	private String songname; 
	
	@Field(name="SingerName")
	private String singername;
	
	
	
	public SongData(long songID, String username, String genre, String albumname, String songname, String singername) {
		super();
		this.songID = songID;
		this.username = username;
		this.genre = genre;
		this.albumname = albumname;
		this.songname = songname;
		this.singername = singername;
	}


	@Override
	public String toString() {
		return "SongData [songID=" + songID + ", genre=" + genre + ", albumname=" + albumname
				+ ", songname=" + songname + ", singername=" + singername + "]";
	}


	public SongData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public long getSongID() {
		return songID;
	}

	public void setSongID(long songID) {
		this.songID = songID;
	}

	public String getsongname() {
		return songname;
	}

	public void setsongname(String songname) {
		this.songname = songname;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getAlbumname() {
		return albumname;
	}


	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}


	public String getSingername() {
		return singername;
	}


	public void setSingername(String singername) {
		this.singername = singername;
	}

	


}
