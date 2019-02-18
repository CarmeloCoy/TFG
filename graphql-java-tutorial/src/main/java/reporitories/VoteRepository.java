package reporitories;

import com.mongodb.client.MongoCollection;

import modelo.Scalars;
import modelo.Track;

import static com.mongodb.client.model.Filters.eq;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;


public class VoteRepository {
    
    private final MongoCollection<Document> votes;

    public VoteRepository(MongoCollection<Document> votes) {
        this.votes = votes;
    }

    public List<Track> findByUserId(String userId) {
        List<Track> list = new ArrayList<>();
        for (Document doc : votes.find(eq("userId", userId))) {
            list.add(vote(doc));
        }
        return list;
    }

    public List<Track> findByLinkId(String linkId) {
        List<Track> list = new ArrayList<>();
        for (Document doc : votes.find(eq("linkId", linkId))) {
            list.add(vote(doc));
        }
        return list;
    }

    public Track saveVote(Track vote) {
        Document doc = new Document();
        doc.append("userId", vote.getUserId());
        doc.append("linkId", vote.getLinkId());
        doc.append("createdAt", Scalars.dateTime.getCoercing().serialize(vote.getCreatedAt()));
        votes.insertOne(doc);
        return new Track(
                doc.get("_id").toString(),
                vote.getCreatedAt(),
                vote.getUserId(),
                vote.getLinkId());
    }
    
    private Track vote(Document doc) {
        return new Track(
                doc.get("_id").toString(),
                ZonedDateTime.parse(doc.getString("createdAt")),
                doc.getString("userId"),
                doc.getString("linkId")
        );
    }
}
