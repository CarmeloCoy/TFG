package resolvers;

import java.util.List;


import com.coxautodev.graphql.tools.GraphQLRootResolver;

import modelo.Album;
import modelo.Artist;
import modelo.Track;
import repositories.AlbumRepository;
import repositories.ArtistRepository;
import repositories.TrackRepository;

public class Query implements GraphQLRootResolver{
	//TODO Factory
	private ArtistRepository artistRepository;
	private TrackRepository trackRepository;
	private AlbumRepository albumRepository;

	public Query(ArtistRepository artistRepository, TrackRepository trackRepository, AlbumRepository albumRepository) {
		super();
		this.artistRepository =artistRepository;
		this.trackRepository = trackRepository;
		this.albumRepository = albumRepository;
	}


	public Artist artist(String id) {
		return artistRepository.findById(id);
	}			
	
	public List<Artist> allArtists() {
		return artistRepository.getAllArtists();
	}
	
	public Track track(String id) {
		return trackRepository.findById(id);
	}
	
	public List<Track> allTracks() {
		return trackRepository.getAllTracks();
	}
	
	public Album album(String id) {
		return albumRepository.findById(id);
	}
	
	public List<Album> allAlbums() {
		return albumRepository.getAllAlbums();
		
	}
	
	
}


