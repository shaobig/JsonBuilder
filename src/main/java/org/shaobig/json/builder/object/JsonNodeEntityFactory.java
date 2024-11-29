package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.shaobig.json.builder.EntityFactory;

class JsonNodeEntityFactory implements EntityFactory<JsonNode> {

    @Override
    public JsonNode createEntity() {
        return new ObjectMapper().missingNode();
    }

}
