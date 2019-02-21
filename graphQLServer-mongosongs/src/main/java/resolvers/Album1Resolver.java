package resolvers;


import java.util.LinkedList;


import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import modelo.Album1;
import modelo.Track;
import repositories.TrackRepository;

public class Album1Resolver implements GraphQLResolver<Album1> {

	private final TrackRepository trackRepository;

    public Album1Resolver(TrackRepository artistRepository) {
        this.trackRepository = artistRepository;
    }
	
    public List<Track> tracks(Album1 album){
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
