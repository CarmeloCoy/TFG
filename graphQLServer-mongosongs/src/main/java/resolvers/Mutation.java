package resolvers;


import java.util.List;
import com.coxautodev.graphql.tools.GraphQLRootResolver;

import modelo.Artist;
import modelo.Rating_;
import modelo.Track;
import repositories.ArtistRepository;
import repositories.TrackRepository;

public class Mutation implements GraphQLRootResolver {
	
	private ArtistRepository artistRepository;
	private TrackRepository trackRepository;

	public Mutation(ArtistRepository artistRepository, TrackRepository trackRepository) {
		super();
		this.artistRepository =artistRepository;
		this.trackRepository = trackRepository;
	}

	public Artist createArtist(String name, int startingYear) {
		Artist newArtist = new Artist(name, startingYear);
		artistRepository.saveArtist(newArtist);
		return newArtist;
	}
	
	public Track createTrack(String name, double length, List<String> genres, List<String> artist_ids, Rating_ ratings) {
		Track track = new Track(null, genres,length, name,artist_ids,ratings.getRating());
		trackRepository.saveTrack(track);
		return track;
	}

}
