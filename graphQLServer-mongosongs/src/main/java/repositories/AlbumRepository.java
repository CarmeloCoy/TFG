package repositories;



import modelo.SuperAlbum;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;

import org.bson.types.ObjectId;
import org.bson.Document;

public class AlbumRepository {
    
	private final MongoCollection<Document> Album;

    public AlbumRepository(MongoCollection<Document> albums) {
        this.Album = albums;
        
    }

    public SuperAlbum findById(String id) {
        Document doc = Album.find(eq("_id", new ObjectId(id))).first();
        return album(doc);
    }
    
    private SuperAlbum album(Document doc) {
        return null;
    }
}
