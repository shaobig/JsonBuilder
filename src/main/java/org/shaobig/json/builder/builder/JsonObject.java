package org.shaobig.json.builder.builder;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.shaobig.json.builder.factory.JsonBuilderManagerEntityFactory;

public class JsonObject {

    private ObjectNode objectNode;

    public JsonObject(ObjectNode objectNode) {
        this.objectNode = objectNode;
    }

    public ObjectNode getObjectNode() {
        return objectNode;
    }

    public void setObjectNode(ObjectNode objectNode) {
        this.objectNode = objectNode;
    }

    @Override
    public String toString() {
        return "JsonObject{" +
                "objectNode=" + objectNode +
                '}';
    }

    public static class Builder implements NodeInserter, JsonObjectCreator {

        private JsonBuilderManager jsonBuilderManager;

        public Builder() {
            this.jsonBuilderManager = new JsonBuilderManagerEntityFactory().createEntity();
        }

        @Override
        public Builder insertNode(String path, Object object) {
            getJsonBuilderManager().createNode(path, object);
            return this;
        }

        @Override
        public JsonObject createJsonObject() {
            return new JsonObject(getJsonBuilderManager().getObjectNodeMergerNodeCreator().getObjectNode());
        }

        public JsonBuilderManager getJsonBuilderManager() {
            return jsonBuilderManager;
        }

        public void setJsonBuilderManager(JsonBuilderManager jsonBuilderManager) {
            this.jsonBuilderManager = jsonBuilderManager;
        }
    }

}
