package resolvers;

import java.util.LinkedList;
import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import modelo.Artist;
import modelo.Track;
import repositories.ArtistRepository;

public class TrackResolver implements GraphQLResolver<Track> {
    
    private final ArtistRepository artistRepository;

    public TrackResolver(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> artist_ids(Track track) {
    	List<Artist> artists = new LinkedList<Artist>();
        if (track.getArtist_ids() == null) {
            return artists;
        }
        for (String artist_id : track.getArtist_ids()) {
			artists.add(artistRepository.findById(artist_id));
		}
        return artists;
    }
}
