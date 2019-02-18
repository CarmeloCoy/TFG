package resolvers;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import modelo.Link;
import modelo.LinkFilter;
import modelo.User;
import reporitories.LinkRepository;
import reporitories.TrackRepository;

public class Query implements GraphQLRootResolver {

	private final LinkRepository linkRepository;
	private final TrackRepository userRepository;

	public Query(LinkRepository linkRepository, TrackRepository userRepository) {
		this.linkRepository = linkRepository;
		this.userRepository = userRepository;
	}
	
	public List<Link> allLinks(LinkFilter filter, Number skip, Number first) {
	    return linkRepository.getAllLinks(filter, skip.intValue(), first.intValue());
	}

	
	public List<User> allUsers(){
		return userRepository.getAllUsers();
	}
	
	
}
