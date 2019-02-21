package resolvers;

import java.util.List;


import com.coxautodev.graphql.tools.GraphQLRootResolver;
import graphql.GraphQLException;
import modelo.Artist;
import modelo.RatingInput;
import modelo.Album;
import modelo.Album1;
import modelo.Album2;
import modelo.Album3;
import modelo.Track;
import repositories.AlbumRepository;
import repositories.ArtistRepository;
import repositories.TrackRepository;

public class Mutation implements GraphQLRootResolver {

	private ArtistRepository artistRepository;
	private TrackRepository trackRepository;
	private AlbumRepository albumRepository;

	public Mutation(ArtistRepository artistRepository, TrackRepository trackRepository,
			AlbumRepository albumRepository) {
		super();
		this.artistRepository = artistRepository;
		this.trackRepository = trackRepository;
		this.albumRepository = albumRepository;
	}

	public Artist createArtist(String name, int startingYear) {
		Artist newArtist = new Artist(name, startingYear);
		artistRepository.saveArtist(newArtist);
		return newArtist;
	}

	public Artist addTracks(String id, List<String> composedTrack_ids, List<String> lyricsTrack_ids) {
		Artist artist = artistRepository.findById(id);
		if (artist == null)
			throw new GraphQLException("Invalid artist ID:" + id);

		for (String track_id : composedTrack_ids) {
			if (trackRepository.findById(track_id) == null)
				throw new GraphQLException("Invalid composed track ID:" + track_id);
		}

		artist.addComposedTracks(composedTrack_ids);

		if (lyricsTrack_ids == null) {
			artistRepository.updateArtist(artist);
			return artist;
		}

		for (String track_id : lyricsTrack_ids) {
			if (trackRepository.findById(track_id) == null)
				throw new GraphQLException("Invalid lyrycs track ID:" + track_id);
		}

		artist.addLyricsTracks(lyricsTrack_ids);

		artistRepository.updateArtist(artist);
		return artist;

	}

	public Artist addAlbums(String id, List<String> album_ids) {
		Artist artist = artistRepository.findById(id);
		if (artist == null)
			throw new GraphQLException("Invalid artist ID:" + id);

		for (String album_id : album_ids) {
			if (albumRepository.findById(album_id) == null)
				throw new GraphQLException("Invalid album ID:" + album_id);
		}

		artist.addAlbums(album_ids);

		artistRepository.updateArtist(artist);
		return artist;
	}

	public Track createTrack(String name, double length, List<String> genres, List<String> artist_ids,
			RatingInput ratings) {
		Track track = new Track(null, genres, length, name, artist_ids, ratings.getRating());
		trackRepository.saveTrack(track);
		return track;
	}

	public Album createAlbum1(List<String> formats, String name, List<String> tracks, int releaseYear,
			String availabitlity, String genre) {
		Album1 album = new Album1(name, formats, releaseYear, tracks, availabitlity, genre);
		albumRepository.saveAlbum(album);
		return album;
	}

	public Album createAlbum2(List<String> formats, String name, List<String> tracks, int releaseYear,
			List<String> availabitlity, String genre) {
		Album2 album = new Album2(name, formats, releaseYear, tracks, availabitlity, genre);
		albumRepository.saveAlbum(album);
		return album;
	}

	public Album createAlbum3(List<String> formats, String name, List<String> tracks, int releaseYear,
			List<String> availabitlity, List<String> genres) {
		Album3 album = new Album3(name, formats, releaseYear, tracks, availabitlity, genres);
		albumRepository.saveAlbum(album);
		return album;
	}

}
