package com.example.demo.musicfiledata;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<SongData,Long > {
	
	List<SongData> findBySongnameIgnoreCase(String songname);
	List<SongData> findBySingernameIgnoreCase(String singername);
	List<SongData> findByAlbumnameIgnoreCase(String songname);
	List<SongData> findByGenreIgnoreCase(String singername);
	List<SongData> findByUsername(String username);
	

}
