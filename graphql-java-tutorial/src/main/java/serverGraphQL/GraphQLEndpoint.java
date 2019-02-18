package serverGraphQL;

import com.coxautodev.graphql.tools.SchemaParser;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.annotation.WebServlet;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import modelo.Scalars;
import reporitories.LinkRepository;
import reporitories.TrackRepository;
import reporitories.VoteRepository;
import resolvers.LinkResolver;
import resolvers.Mutation;
import resolvers.Query;
import resolvers.SigninResolver;
import resolvers.VoteResolver;



@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

	private static final long serialVersionUID = 1L;
	private static final LinkRepository linkRepository;
	private static final TrackRepository userRepository;
	private static final VoteRepository voteRepository;

	static {
		MongoDatabase mongo = new MongoClient().getDatabase("exampleDB");
		linkRepository = new LinkRepository(mongo.getCollection("links"));
		userRepository = new TrackRepository(mongo.getCollection("users"));
		voteRepository = new VoteRepository(mongo.getCollection("votes"));
	}
	
	@Override
	protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
	    return errors.stream()
	            .filter(e -> e instanceof ExceptionWhileDataFetching || super.isClientError(e))
	            .map(e -> e instanceof ExceptionWhileDataFetching ? new SanitizedError((ExceptionWhileDataFetching) e) : e)
	            .collect(Collectors.toList());
	}
	
	public GraphQLEndpoint() {
		super(buildSchema());
	}

	private static GraphQLSchema buildSchema() {
		return SchemaParser.newParser().file("schema.graphqls")
				 .resolvers(
				            new Query(linkRepository, userRepository),
				            new Mutation(linkRepository, userRepository, voteRepository),
				            new SigninResolver(),
				            new LinkResolver(userRepository),
				            new VoteResolver(linkRepository, userRepository)) 
				        .scalars(Scalars.dateTime). 
				build().makeExecutableSchema();
	}
}
