package serverGraphQL;
import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ExceptionWhileDataFetching;

public class SanitizedError extends ExceptionWhileDataFetching {
    
	private static final long serialVersionUID = 1L;

	public SanitizedError(ExceptionWhileDataFetching inner) {
    	super(null, inner.getException(), inner.getLocations().get(0));
    }

    @Override
    @JsonIgnore
    public Throwable getException() {
        return super.getException();
    }
}
