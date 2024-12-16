package org.shaobig.json.builder.reader.path;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.object.JsonNodeSetter;

public abstract class JsonPathReader implements PathReader, JsonNodeSetter {

    private JsonNode jsonNode;

    public JsonPathReader(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

}
