package server;

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
import modelo.Album1;
import modelo.Album2;
import modelo.Album3;
import repositories.AlbumRepository;
import repositories.ArtistRepository;
import repositories.TrackRepository;
import resolvers.Album1Resolver;
import resolvers.Album2Resolver;
import resolvers.Album3Resolver;
import resolvers.AlbumResolver;
import resolvers.ArtistResolver;
import resolvers.Mutation;
import resolvers.Query;
import resolvers.TrackResolver;
import server.SanitizedError;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

	private static final long serialVersionUID = 1L;
	private static final MongoDatabase mongo;
	private static final ArtistRepository artistRepository;
	private static final TrackRepository trackRepository;
	private static final AlbumRepository albumRepository;

	static {
		mongo = new MongoClient().getDatabase("mongosongs");
		//artistRepository = new ArtistRepository(mongo.getCollection("artists"));
		//trackRepository = new TrackRepository(mongo.getCollection("tracks"));
		//albumRepository = new AlbumRepository(mongo.getCollection("albums"));
		artistRepository = new ArtistRepository(mongo.getCollection("Artist"));
		trackRepository = new TrackRepository(mongo.getCollection("Track"));
		albumRepository = new AlbumRepository(mongo.getCollection("Album"));
		
	}
	
	/*@Override
	public boolean isClientError(GraphQLError e) {
		return true;
	}*/
	
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
				.dictionary(Album1.class, Album2.class, Album3.class)
				.resolvers(new Query(artistRepository, trackRepository, albumRepository), 
						new Mutation(artistRepository, trackRepository, albumRepository),
						new TrackResolver(artistRepository),
						new AlbumResolver(trackRepository),
						new Album1Resolver(trackRepository),
						new Album2Resolver(trackRepository),
						new Album3Resolver(trackRepository),
						new ArtistResolver(trackRepository, albumRepository))
				.build()
				.makeExecutableSchema();
	}
}
