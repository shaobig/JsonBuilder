package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.JsonNodeCreator;
import org.shaobig.json.builder.creator.JsonNodeCreatorEntityFactory;
import org.shaobig.json.builder.creator.NewObjectNodeSupplier;
import org.shaobig.json.builder.creator.NodeCreator;
import org.shaobig.json.builder.object.builder.EntityBuilderCreator;
import org.shaobig.json.builder.object.builder.JsonObjectBuilderCreator;
import org.shaobig.json.builder.object.manager.JsonObjectManager;
import org.shaobig.json.builder.object.manager.NodeCreatorManager;
import org.shaobig.json.builder.object.manager.ValueReaderManager;
import org.shaobig.json.builder.reader.value.*;

import java.util.List;

public class JsonObject implements NodeCreator, ValueReader, ListValueReader {

    private JsonObjectManager jsonObjectManager;

    public JsonObject(JsonObjectManager jsonObjectManager) {
        this.jsonObjectManager = jsonObjectManager;
    }

    @Override
    public JsonNode createNode(String path, Object object) {
        return getJsonObjectManager().createNode(path, object);
    }

    @Override
    public <T> T readValue(String path, Class<T> valueType) {
        return getJsonObjectManager().readValue(path, valueType);
    }

    @Override
    public <T> List<T> readList(String path, Class<T> classType) {
        return getJsonObjectManager().readList(path, classType);
    }

    public JsonObjectManager getJsonObjectManager() {
        return jsonObjectManager;
    }

    public void setJsonObjectManager(JsonObjectManager jsonObjectManager) {
        this.jsonObjectManager = jsonObjectManager;
    }

    @Override
    public String toString() {
        return getJsonObjectManager().toString();
    }

    public static class Builder implements EntityBuilderCreator, JsonObjectBuilderCreator {

        private JsonObjectManager jsonObjectManager;

        private Builder(JsonObjectManager jsonObjectManager) {
            this.jsonObjectManager = jsonObjectManager;
        }

        public Builder() {
            JsonNode jsonNode = new NewObjectNodeSupplier().supplyNode();
            JsonNodeCreator jsonNodeCreator = new JsonNodeCreatorEntityFactory(jsonNode).createEntity();
            EntityValueReader valueReader = new EntityValueReaderEntityFactory(jsonNode).createEntity();
            EntityListValueReader listValueReader = new EntityListValueReaderEntityFactory(jsonNode).createEntity();
            this.jsonObjectManager = new JsonObjectManager(jsonNode, new NodeCreatorManager(jsonNodeCreator), new ValueReaderManager(valueReader, listValueReader));
        }

        @Override
        public Builder createNode(String path, Object object) {
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
