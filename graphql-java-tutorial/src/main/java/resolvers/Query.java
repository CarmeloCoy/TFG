package resolvers;

import java.text.ParseException;


import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import graphql.GraphQLException;
import modelo.Link;
import modelo.LinkFilter;
import modelo.User;
import modelo.Vote;
import reporitories.LinkRepository;
import reporitories.TrackRepository;
import reporitories.VoteRepository;

public class Query implements GraphQLQueryResolver {

	private final LinkRepository linkRepository;
	private final TrackRepository userRepository;
	private final VoteRepository voteRepository;

	public Query(LinkRepository linkRepository, TrackRepository userRepository, VoteRepository voteRepository) {
		this.linkRepository = linkRepository;
		this.userRepository = userRepository;
		this.voteRepository = voteRepository;
	}
	
	public List<Link> allLinks(LinkFilter filter, Number skip, Number first) {
	    return linkRepository.getAllLinks(filter, skip.intValue(), first.intValue());
	}

	
	public List<User> allUsers(){
		return userRepository.getAllUsers();
	}
	
	public List<Vote> allVotes(Number skip, Number first) {
	    try {
			return voteRepository.getAllvotes( skip.intValue(), first.intValue());
		} catch (ParseException e) {
			throw new GraphQLException("Invalid date format: Expected: dd-mm-yyyy");
		}
	}
	
}
