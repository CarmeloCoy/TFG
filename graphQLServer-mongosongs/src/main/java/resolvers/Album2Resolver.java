package resolvers;


import java.util.LinkedList;


import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;


import modelo.Album2;
import modelo.Track;
import repositories.TrackRepository;

public class Album2Resolver implements GraphQLResolver<Album2> {

	private final TrackRepository trackRepository;

    public Album2Resolver(TrackRepository artistRepository) {
        this.trackRepository = artistRepository;
    }
	
    public List<Track> tracks(Album2 album){
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
