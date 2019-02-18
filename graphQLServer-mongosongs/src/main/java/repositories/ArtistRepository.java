package repositories;



import modelo.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.or;
import static com.mongodb.client.model.Filters.eq;

import org.bson.types.ObjectId;
import org.bson.Document;
import org.bson.conversions.Bson;

public class ArtistRepository {
    
	private final MongoCollection<Document> artists;

    public ArtistRepository(MongoCollection<Document> artists) {
        this.artists = artists;
    }
    
    public Artist findById(String id) {
        Document doc = artists.find(eq("_id", new ObjectId(id))).first();
        return artist(doc);
    }
    
    public List<Artist> getAllArtists() {
        List<Artist> allArtist = new ArrayList<Artist>();
        for (Document doc : artists.find()) {
            allArtist.add(artist(doc));
        }
        return allArtist;
    }
    
    public List<Artist> getAllArtists(Artist artist) {
    	Optional<Bson> mongoFilter = Optional.ofNullable(artist).map(this::buildFilter);
        List<Artist> allArtist = new ArrayList<Artist>();
        FindIterable<Document> documents = mongoFilter.map(artists::find).orElseGet(artists::find);
        for (Document doc : documents) {
            allArtist.add(artist(doc));
        }
        return allArtist;
    }
    
       
    public void saveArtist(Artist artist) {
        Document doc = new Document();
        doc.append("name", artist.getName());
        doc.append("startingYear", artist.getStartingYear());
        /*doc.append("albums", artist.getAlbums());
        doc.append("composedTracks", artist.getComposedTracks());
        doc.append("lyricsTracks", artist.getLyricstracks());
        */artists.insertOne(doc);
    }
    
    private Bson buildFilter(Artist artist) {
        String name = artist.getName();
        String id = artist.getId();
        Bson nameCondition = null;
        Bson idCondition = null;
        
        if (name != null && !name.isEmpty()) {
            nameCondition = eq("name", name);
        }
        
        if (id != null && !id.isEmpty()) {
            idCondition = eq("_id", id);
        }
        
        if (nameCondition != null && idCondition != null) {
            return or(nameCondition, idCondition);
        }
        return nameCondition != null ? nameCondition : idCondition;
    }
    
    private Artist artist(Document doc) {
        return new Artist(
        		doc.get("_id").toString(),
                doc.get("name").toString(),
                doc.getInteger("startingYear"));
    }
}
