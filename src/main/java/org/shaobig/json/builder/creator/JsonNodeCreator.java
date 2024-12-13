package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.object.JsonNodeSetter;

public abstract class JsonNodeCreator implements NodeCreator, JsonNodeSetter {

    private JsonNode jsonNode;

    public JsonNodeCreator(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

}
