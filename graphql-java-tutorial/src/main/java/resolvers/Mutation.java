package resolvers;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import graphql.GraphQLException;
import modelo.AuthData;
import modelo.Link;
import modelo.SigninPayload;
import modelo.User;
import modelo.Track;
import reporitories.LinkRepository;
import reporitories.TrackRepository;
import reporitories.VoteRepository;

public class Mutation implements GraphQLRootResolver {
    
    private final LinkRepository linkRepository;
    private final TrackRepository userRepository;
    private final VoteRepository voteRepository;

    public Mutation(LinkRepository linkRepository, TrackRepository userRepository, VoteRepository voteRepository) {
        this.linkRepository = linkRepository;
        this.userRepository=userRepository;
        this.voteRepository = voteRepository;
    }
    
    public Link createLink(String url, String description, String postedBy) {
        Link newLink = new Link(url, description, postedBy);
        linkRepository.saveLink(newLink);
        return newLink;
    }
    
    public User createUser(String name, AuthData auth) {
        User newUser = new User(name, auth.getEmail(), auth.getPassword());
        return userRepository.saveUser(newUser);
    }
    
    public SigninPayload signinUser(AuthData auth) throws IllegalAccessException {
        User user = userRepository.findByEmail(auth.getEmail());
        if (user.getPassword().equals(auth.getPassword())) {
            return new SigninPayload(user.getId(), user);
        }
        throw new GraphQLException("Invalid credentials");
    }

    public Track createVote(String linkId, String userId) {
        ZonedDateTime now = Instant.now().atZone(ZoneOffset.UTC);
        return voteRepository.saveVote(new Track(now, userId, linkId));
    }

    
}
