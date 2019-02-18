package resolvers;


import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import modelo.Artist;
import modelo.Track;
import repositories.TrackRepository;

public class ArtistResolver implements GraphQLResolver<Artist> {

	private final TrackRepository trackRepository;

    public ArtistResolver(TrackRepository artistRepository) {
        this.trackRepository = artistRepository;
    }
	
	public List<Track> composedTracks(Artist artist){
		//TODO 
		return null;
	}
	
	public List<Track> lyricsTracks(Artist artist){
		//TODO 
		return null;
	}
	
}
