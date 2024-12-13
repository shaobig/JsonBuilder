package org.shaobig.json.builder.object.manager;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.JsonNodeCreator;
import org.shaobig.json.builder.creator.NodeCreator;
import org.shaobig.json.builder.object.JsonNodeSetter;

public class NodeCreatorManager implements NodeCreator, JsonNodeSetter {

    private JsonNodeCreator jsonNodeCreator;

    public NodeCreatorManager(JsonNodeCreator jsonNodeCreator) {
        this.jsonNodeCreator = jsonNodeCreator;
    }

    @Override
    public JsonNode createNode(String path, Object object) {
        return getJsonNodeCreator().createNode(path, object);
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        getJsonNodeCreator().setJsonNode(jsonNode);
    }

    public JsonNodeCreator getJsonNodeCreator() {
        return jsonNodeCreator;
    }

    public void setJsonNodeCreator(JsonNodeCreator jsonNodeCreator) {
        this.jsonNodeCreator = jsonNodeCreator;
    }

}
