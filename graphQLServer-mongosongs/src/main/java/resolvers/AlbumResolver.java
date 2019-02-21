package resolvers;


import java.util.LinkedList;


import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;/*
public String id(Album album){
return album.getId();
}


public String name(Album album){
return album.getName();
}

public List<String> formats(Album album){
return album.getFormats();
}

public int releaseYear(Album album) {
return album.getReleaseYear();
}*/


import modelo.Album;
import modelo.Track;
import repositories.TrackRepository;

public class AlbumResolver implements GraphQLResolver<Album> {

	private final TrackRepository trackRepository;

    public AlbumResolver(TrackRepository artistRepository) {
        this.trackRepository = artistRepository;
    }

	public List<Track> tracks(Album album){
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
