package reporitories;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;


import modelo.DateTime;
import modelo.Link;
import modelo.Scalars;
import modelo.Vote;

import static com.mongodb.client.model.Filters.eq;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;


public class VoteRepository {
    
    private final MongoCollection<Document> votes;

    public VoteRepository(MongoCollection<Document> votes) {
        this.votes = votes;
    }

    public List<Vote> findByUserId(String userId) throws ParseException {
        List<Vote> list = new ArrayList<>();
        for (Document doc : votes.find(eq("userId", userId))) {
            list.add(vote(doc));
        }
        return list;
    }

    public List<Vote> findByLinkId(String linkId) throws ParseException {
        List<Vote> list = new ArrayList<>();
        for (Document doc : votes.find(eq("linkId", linkId))) {
            list.add(vote(doc));
        }
        return list;
    }

    public Vote saveVote(Vote vote) {
        Document doc = new Document();
        doc.append("userId", vote.getUserId());
        doc.append("linkId", vote.getLinkId());
        doc.append("createdAt", Scalars.dateTime.getCoercing().serialize(vote.getCreatedAt()));
        votes.insertOne(doc);
        return new Vote(
                doc.get("_id").toString(),
                vote.getCreatedAt(),
                vote.getUserId(),
                vote.getLinkId());
    }
    
    private Vote vote(Document doc) throws ParseException {
        return new Vote(
                doc.get("_id").toString(),
                new DateTime(doc.getString("createdAt")),
                doc.getString("userId"),
                doc.getString("linkId")
        );
    }

	public List<Vote> getAllvotes(int skip, int first) throws ParseException {
		List<Vote> allVotes = new ArrayList<>();
        for (Document doc : votes.find().skip(skip).limit(first)) {
            allVotes.add(vote(doc));
        }
        return allVotes;
	}
}
