package io.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import io.shaobig.json.builder.creator.ObjectCreator;
import io.shaobig.json.builder.object.builder.EntityBuilderCreator;
import io.shaobig.json.builder.object.builder.JsonNodeJsonObjectBuilderCreator;
import io.shaobig.json.builder.object.builder.JsonObjectBuilderCreator;
import io.shaobig.json.builder.object.manager.JsonObjectManager;
import io.shaobig.json.builder.object.manager.JsonObjectManagerEntityFactory;
import io.shaobig.json.builder.reader.value.ListObjectReader;
import io.shaobig.json.builder.reader.value.ObjectReader;

import java.util.List;

public class JsonObject implements ObjectCreator, ObjectReader, ListObjectReader {

    private JsonObjectManager jsonObjectManager;

    public JsonObject(JsonObjectManager jsonObjectManager) {
        this.jsonObjectManager = jsonObjectManager;
    }

    @Override
    public JsonNode createObject(String path, Object object) {
        return getJsonObjectManager().createObject(path, object);
    }

    @Override
    public <T> T readObject(String path, Class<T> valueType) {
        return getJsonObjectManager().readObject(path, valueType);
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

    public static class Builder implements EntityBuilderCreator, JsonObjectBuilderCreator, JsonNodeJsonObjectBuilderCreator {

        private JsonObjectManager jsonObjectManager;

        private Builder(JsonObjectManager jsonObjectManager) {
            this.jsonObjectManager = jsonObjectManager;
        }

        public Builder() {
            this(new JsonObjectManagerEntityFactory().createEntity());
        }

        @Override
        public Builder createObject(String path, Object object) {
            getJsonBuilderManager().createObject(path, object);
            return this;
        }

        @Override
        public JsonObject build() {
            return new JsonObject(getJsonBuilderManager());
        }

        @Override
        public JsonObject build(JsonNode jsonNode) {
            getJsonBuilderManager().setJsonNode(jsonNode);
            return build();
        }

        public JsonObjectManager getJsonBuilderManager() {
            return jsonObjectManager;
        }

        public void setJsonBuilderManager(JsonObjectManager jsonObjectManager) {
            this.jsonObjectManager = jsonObjectManager;
        }

    }

}
