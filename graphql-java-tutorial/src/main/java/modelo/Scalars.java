package modelo;


import java.text.ParseException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import graphql.GraphQLException;
import graphql.language.ObjectValue;
import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;

public class Scalars {
    
    public static GraphQLScalarType dateTime = new GraphQLScalarType("DateTime", "DataTime scalar", new Coercing() {
        @Override
        public Object serialize(Object input) {
            if(input instanceof DateTime)
            	return ((DateTime)input).getDate().toString();
            else {
            	System.err.println( input.getClass());
            	return null;
            } 
            	
        }

        @Override
        public Object parseValue(Object input) {
            return serialize(input);
        }

        @Override
        public Object parseLiteral(Object input) {
            //parse the string values coming in
            if (input instanceof StringValue) {
                try {
					return new DateTime(((StringValue) input).getValue());
				} catch (ParseException e) {
					throw new GraphQLException("Invalid date format: Expected: dd-mm-yyyy");
				}
            } else if (input instanceof ObjectValue)
            	return (ObjectValue) input;
            else {
                return null;
                
            }
        }
    });
}
