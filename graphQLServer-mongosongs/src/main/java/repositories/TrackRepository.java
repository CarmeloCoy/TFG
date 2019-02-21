package repositories;




import modelo.Rating;

import modelo.Track;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.bson.Document;

public class TrackRepository {
    
	private final MongoCollection<Document> tracks;

    public TrackRepository(MongoCollection<Document> tracks) {
        this.tracks = tracks;
        
    }

    public Track findById(String id) {
        Document doc = tracks.find(eq("_id", new ObjectId(id))).first();
        //Document doc = tracks.find(eq("_id", id)).first();
        return track(doc);
    }
    
    public void saveTrack(Track track) {
    	List<Document> ratings = new ArrayList<Document>();
    	ratings.add( new Document()
    			.append("score", track.getRatings().getScore())
    			.append("voters", track.getRatings().getVoters()));
    	Document doc = new Document();
    	doc.append("name", track.getName());
    	doc.append("length", track.getLength());
    	doc.append("genres", track.getGenres());
    	doc.append("artist_ids", track.getArtist_ids());
    	doc.append("ratings", ratings);
    	tracks.insertOne(doc);
    }

    
    @SuppressWarnings("unchecked")
	private Track track(Document doc) {
    	if (doc== null) return null;
    	
    	Rating rating = null;
    	List<Document> ratings =((List<Document>)doc.get("ratings"));
    	if (ratings != null) {
    		Document doc1 = ratings.get(0);
        	
        	if(doc1!=null) {
        		rating=new Rating(doc1.getDouble("score"), doc1.getInteger("voters"));
        	}
		}
    	
        return new Track( 
        		doc.get("_id").toString(),
        		(List<String>)doc.get("genres"),
        		doc.getDouble("length"),
        		doc.getString("name"),
        		(List<String>)doc.get("artist_ids"),
        		rating);
    }

	public List<Track> getAllTracks() {
		List<Track> allTracks = new ArrayList<Track>();
		for (Document doc : tracks.find()) {
			allTracks.add(track(doc));
		}
		return allTracks;
	}
}
