package resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;

import modelo.Link;
import modelo.User;
import reporitories.TrackRepository;

public class LinkResolver implements GraphQLResolver<Link> {
    
    private final TrackRepository userRepository;

    public LinkResolver(TrackRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User postedBy(Link link) {
        if (link.getUserId() == null) {
            return null;
        }
        return userRepository.findById(link.getUserId());
    }
}
