package repositories;

import modelo.Album;

import modelo.Album1;
import modelo.Album2;
import modelo.Album3;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

public class AlbumRepository {
    
	private final MongoCollection<Document> albums;

    public AlbumRepository(MongoCollection<Document> albums) {
        this.albums = albums;
        
    }

    public Album findById(String id) {
        Document doc = albums.find(eq("_id", new ObjectId(id))).first();
    	//Document doc = albums.find(eq("_id", id)).first();
        return album(doc);
    }
    
    
    public List<Album> getAllAlbums() {
        List<Album> allAlbum = new ArrayList<Album>();
        for (Document doc : albums.find()) {
            allAlbum.add(album(doc));
        }
        return allAlbum;
    }
    
    public void saveAlbum(Album album) {
    	Document doc = new Document();
    	doc.append("name", album.getName());
    	doc.append("formats", album.getFormats());
    	doc.append("releaseYear", album.getReleaseYear());
    	doc.append("tracks", album.getTrack_ids());
    	
    	if(album instanceof Album1) {
    		Album1 album1 = (Album1) album;
    		doc.append("availability", album1.getAvailabitlity());
    		doc.append("genre", album1.getGenre());

    		
    	}else if(album instanceof Album2) {
    		Album2 album2 = (Album2) album;
    		doc.append("availability", album2.getAvailabitlity());
    		doc.append("genre", album2.getGenre());

    	}
    	else if(album instanceof Album3) {
    		Album3 album3 = (Album3) album;
    		doc.append("availability", album3.getAvailabitlity());
    		doc.append("genres", album3.getGenres());

    	}
    	albums.insertOne(doc);
    }
    
    
    @SuppressWarnings("unchecked")
	private Album album(Document doc) {
    	String type = getType(doc);
    	
    	switch (type) {
		case "Album1" :
			
			return new Album1(
					doc.get("_id").toString(),
					doc.getString("name"), 
					(List<String>)doc.get("formats"),
					doc.getInteger("releaseYear"),
					(List<String>)doc.get("tracks"), 
					doc.getString("availability"), 
					doc.getString("genre"));
			
		case "Album2" :
			
			return new Album2(
					doc.get("_id").toString(),
					doc.getString("name"), 
					(List<String>)doc.get("formats"),
					doc.getInteger("releaseYear"),
					(List<String>)doc.get("tracks"), 
					(List<String>)doc.get("availability"), 
					doc.getString("genre"));
			
		case "Album3" :
	
			return new Album3(
					doc.get("_id").toString(),
					doc.getString("name"), 
					(List<String>)doc.get("formats"),
					doc.getInteger("releaseYear"),
					(List<String>)doc.get("tracks"), 
					(List<String>)doc.get("availability"), 
					(List<String>)doc.get("genres"));

		default:
			return null;
		}
        
    }

	private String getType(Document doc) {
		Object o1 = doc.get("availability");
		Object o2 = doc.get("genre");
		Object o3 = doc.get("genres");
		
		if(o1 instanceof String && o2 instanceof String)
			return "Album1";
		if(o1 instanceof List<?> && o2 instanceof String)
			return "Album2";
		if(o1 instanceof List<?> && o3 instanceof List<?>)
			return "Album3";
		return new String();
	}
}
