package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.NodeInserter;
import org.shaobig.json.builder.factory.GenericPathReaderEntityFactory;
import org.shaobig.json.builder.factory.JsonNodeEntityFactory;
import org.shaobig.json.builder.factory.JsonObjectManagerEntityFactory;
import org.shaobig.json.builder.factory.MergerNodeCreatorEntityFactory;
import org.shaobig.json.builder.reader.StringPathReader;
import org.shaobig.json.builder.reader.StringValueReader;

public class JsonObject implements NodeInserter, StringPathReader {

    private JsonObjectManager jsonObjectManager;

    public JsonObject(JsonObjectManager jsonObjectManager) {
        this.jsonObjectManager = jsonObjectManager;
    }

    @Override
    public JsonNode insertNode(String path, Object object) {
        return getJsonObjectManager().createNode(path, object);
    }

    @Override
    public String readString(String path) {
        return getJsonObjectManager().readString(path);
    }

    public JsonObjectManager getJsonObjectManager() {
        return jsonObjectManager;
    }

    public void setJsonObjectManager(JsonObjectManager jsonObjectManager) {
        this.jsonObjectManager = jsonObjectManager;
    }

    @Override
    public String toString() {
        return getJsonObjectManager().getJsonNode().toString();
    }

    public static class Builder implements NodeBuilderInserter, JsonObjectCreator {

        private JsonObjectManager jsonObjectManager;

        public Builder() {
            JsonNode jsonNode = new JsonNodeEntityFactory().createEntity();
            this.jsonObjectManager = new JsonObjectManagerEntityFactory(() -> jsonNode, new MergerNodeCreatorEntityFactory<>(jsonNode), new GenericPathReaderEntityFactory<>(jsonNode, new StringValueReader(), "")).createEntity();
        }

        @Override
        public Builder insertNode(String path, Object object) {
            getJsonBuilderManager().createNode(path, object);
            return this;
        }

        @Override
        public JsonObject createJsonObject() {
            return new JsonObject(getJsonBuilderManager());
        }

        public JsonObjectManager getJsonBuilderManager() {
            return jsonObjectManager;
        }

        public void setJsonBuilderManager(JsonObjectManager jsonObjectManager) {
            this.jsonObjectManager = jsonObjectManager;
        }

    }

}
