package resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;

import modelo.Link;
import modelo.User;
import modelo.Vote;
import reporitories.LinkRepository;
import reporitories.TrackRepository;

public class VoteResolver implements GraphQLResolver<Vote> {
    
    private final LinkRepository linkRepository;
    private final TrackRepository userRepository;

    public VoteResolver(LinkRepository linkRepository, TrackRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    public User user(Vote vote) {
        return userRepository.findById(vote.getUserId());
    }
    
    public Link link(Vote vote) {
        return linkRepository.findById(vote.getLinkId());
    }
}
