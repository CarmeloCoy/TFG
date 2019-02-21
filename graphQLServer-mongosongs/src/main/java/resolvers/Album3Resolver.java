package resolvers;


import java.util.LinkedList;


import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import modelo.Album3;
import modelo.Track;
import repositories.TrackRepository;

public class Album3Resolver implements GraphQLResolver<Album3> {

	private final TrackRepository trackRepository;

    public Album3Resolver(TrackRepository artistRepository) {
        this.trackRepository = artistRepository;
    }
	
    public List<Track> tracks(Album3 album){
		List<Track> tracks = new LinkedList<Track>();
        if (album.getTrack_ids() == null) {
            return tracks;
        }
        for (String track_id : album.getTrack_ids()) {
        	tracks.add(trackRepository.findById(track_id));
		}
        return tracks;
	}
	
	
}
