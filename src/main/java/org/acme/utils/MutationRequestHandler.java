package org.acme.utils;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import graphql.schema.DataFetchingEnvironment;
import io.smallrye.graphql.api.Context;
import io.vertx.core.json.JsonObject;

public class MutationRequestHandler {

	public static <T> T getObject(Context context, String targetEntity, ObjectMapper objectMapper, T entity) 
			throws JsonMappingException, JsonProcessingException {
		ObjectReader objectReader = objectMapper.readerForUpdating(entity);
		DataFetchingEnvironment dfe = context.unwrap(DataFetchingEnvironment.class);
		Map<String, Object> l = dfe.getArgument(targetEntity);
		System.out.println("arguments>>>>>>>>>>>>>>>>>"+l);
		T objectUpdated = objectReader.readValue(new JsonObject(l).toString());
		return objectUpdated;
	}
}
