package org.shaobig.json.builder.reader;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class NodePathReader implements PathReader<JsonNode> {

    private JsonNode jsonNode;

    public NodePathReader(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    @Override
    public JsonNode readPath(String path) {
        return getJsonNode().get(path);
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

}
