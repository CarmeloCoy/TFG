package resolvers;

import java.util.List;


import com.coxautodev.graphql.tools.GraphQLRootResolver;

import modelo.Artist;
import modelo.Track;
import repositories.ArtistRepository;
import repositories.TrackRepository;

public class Query implements GraphQLRootResolver{
	//TODO Factory
	private ArtistRepository artistRepository;
	private TrackRepository trackRepository;

	public Query(ArtistRepository artistRepository, TrackRepository trackRepository) {
		super();
		this.artistRepository =artistRepository;
		this.trackRepository = trackRepository;
	}

	public Artist artist(String id) {
		return artistRepository.findById(id);
	}			
	
	public List<Artist> allArtists() {
		return artistRepository.getAllArtists();
	}
	
	public List<Track> allTracks() {
		return trackRepository.getAllTracks();
	}
	
}


