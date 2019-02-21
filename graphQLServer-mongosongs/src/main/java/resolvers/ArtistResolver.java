package resolvers;


import java.util.LinkedList;
import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import modelo.Album;
import modelo.Artist;
import modelo.Track;
import repositories.AlbumRepository;
import repositories.TrackRepository;

public class ArtistResolver implements GraphQLResolver<Artist> {

	private final TrackRepository trackRepository;
	private final AlbumRepository albumRepository;

    public ArtistResolver(TrackRepository artistRepository, AlbumRepository albumRepository) {
        this.trackRepository = artistRepository;
        this.albumRepository = albumRepository;
    }
	
	public List<Track> composedTracks(Artist artist){
		List<Track> tracks = new LinkedList<Track>();
        if (artist.getComposedTracks() == null) {
            return tracks;
        }
        for (String track_id : artist.getComposedTracks()) {
        	tracks.add(trackRepository.findById(track_id));
		}
        return tracks;
	}
	
	public List<Track> lyricsTracks(Artist artist){
		List<Track> tracks = new LinkedList<Track>();
        if (artist.getLyricstracks() == null) {
            return null;
        }
        for (String track_id : artist.getLyricstracks()) {
        	tracks.add(trackRepository.findById(track_id));
		}
        return tracks;
	}
	
	public List<Album> albums(Artist artist){
		List<Album> albums = new LinkedList<Album>();
        if (artist.getAlbum_ids() == null) {
            return null;
        }
        for (String album_id : artist.getAlbum_ids()) {
        	albums.add(albumRepository.findById(album_id));
		}
        return albums;
	}
}
