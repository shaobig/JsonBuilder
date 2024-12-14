package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.ObjectCreator;
import org.shaobig.json.builder.object.builder.EntityBuilderCreator;
import org.shaobig.json.builder.object.builder.JsonObjectBuilderCreator;
import org.shaobig.json.builder.object.manager.JsonObjectManager;
import org.shaobig.json.builder.object.manager.JsonObjectManagerEntityFactory;
import org.shaobig.json.builder.reader.value.ListObjectReader;
import org.shaobig.json.builder.reader.value.ObjectReader;

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

    public static class Builder implements EntityBuilderCreator, JsonObjectBuilderCreator {

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

        public JsonObjectManager getJsonBuilderManager() {
            return jsonObjectManager;
        }

        public void setJsonBuilderManager(JsonObjectManager jsonObjectManager) {
            this.jsonObjectManager = jsonObjectManager;
        }

    }

}
