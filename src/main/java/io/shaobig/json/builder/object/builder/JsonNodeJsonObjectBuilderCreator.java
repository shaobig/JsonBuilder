package io.shaobig.json.builder.object.builder;

import com.fasterxml.jackson.databind.JsonNode;
import io.shaobig.json.builder.object.JsonObject;

public interface JsonNodeJsonObjectBuilderCreator {

    JsonObject build(JsonNode jsonNode);

}
