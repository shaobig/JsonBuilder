package org.shaobig.json.builder.reader;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.object.JsonNodeSetter;

public abstract class JsonNodePathReader implements PathReader<JsonNode>, JsonNodeSetter {

    private JsonNode jsonNode;

    public JsonNodePathReader(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    @Override
    public JsonNode readPath(String path) {
        return getJsonNode().get(path);
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

}
