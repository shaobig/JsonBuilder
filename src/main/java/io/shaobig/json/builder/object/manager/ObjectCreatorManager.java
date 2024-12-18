package io.shaobig.json.builder.object.manager;

import com.fasterxml.jackson.databind.JsonNode;
import io.shaobig.json.builder.creator.JsonObjectCreator;
import io.shaobig.json.builder.creator.ObjectCreator;
import io.shaobig.json.builder.object.JsonNodeSetter;

public class ObjectCreatorManager implements ObjectCreator, JsonNodeSetter {

    private JsonObjectCreator jsonNodeCreator;

    public ObjectCreatorManager(JsonObjectCreator jsonNodeCreator) {
        this.jsonNodeCreator = jsonNodeCreator;
    }

    @Override
    public JsonNode createObject(String path, Object object) {
        return getJsonNodeCreator().createObject(path, object);
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        getJsonNodeCreator().setJsonNode(jsonNode);
    }

    public JsonObjectCreator getJsonNodeCreator() {
        return jsonNodeCreator;
    }

    public void setJsonNodeCreator(JsonObjectCreator jsonNodeCreator) {
        this.jsonNodeCreator = jsonNodeCreator;
    }

}
