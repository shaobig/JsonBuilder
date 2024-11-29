package org.shaobig.json.builder.factory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonNodeEntityFactory implements EntityFactory<JsonNode> {

    @Override
    public JsonNode createEntity() {
        return new ObjectMapper().missingNode();
    }

}
