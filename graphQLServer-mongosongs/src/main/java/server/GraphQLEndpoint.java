package server;

import com.coxautodev.graphql.tools.SchemaParser;



import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.annotation.WebServlet;

import graphql.GraphQLError;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repositories.ArtistRepository;
import repositories.TrackRepository;
import resolvers.ArtistResolver;
import resolvers.Mutation;
import resolvers.Query;
import resolvers.TrackResolver;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

	private static final long serialVersionUID = 1L;
	private static final MongoDatabase mongo;
	private static final ArtistRepository artistRepository;
	private static final TrackRepository trackRepository;

	static {
		mongo = new MongoClient().getDatabase("mongosongs");
		artistRepository = new ArtistRepository(mongo.getCollection("artists"));
		trackRepository = new TrackRepository(mongo.getCollection("tracks"));
		
	}
	
	@Override
	public boolean isClientError(GraphQLError e) {
		return true;
	}

	public GraphQLEndpoint() {
		super(buildSchema());
	}

	private static GraphQLSchema buildSchema() {
		return SchemaParser.newParser().file("schema.graphqls")
				.resolvers(new Query(artistRepository, trackRepository), 
						new Mutation(artistRepository, trackRepository),
						new TrackResolver(artistRepository),
						new ArtistResolver(trackRepository))
				.build()
				.makeExecutableSchema();
	}
}
