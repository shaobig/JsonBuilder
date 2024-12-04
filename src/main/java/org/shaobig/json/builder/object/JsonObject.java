package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.object.manager.JsonObjectManager;
import org.shaobig.json.builder.object.manager.ProxyJsonObjectManagerEntityFactory;
import org.shaobig.json.builder.object.manager.creator.*;
import org.shaobig.json.builder.reader.path.IntegerPathReader;
import org.shaobig.json.builder.reader.path.StringPathReader;

public class JsonObject implements StringNodeCreator, IntegerNodeCreator, StringPathReader, IntegerPathReader {

    private JsonObjectManager jsonObjectManager;

    public JsonObject(JsonObjectManager jsonObjectManager) {
        this.jsonObjectManager = jsonObjectManager;
    }

    @Override
    public JsonNode createString(String path, String string) {
        return getJsonObjectManager().createString(path, string);
    }

    @Override
    public JsonNode createInteger(String path, Integer integer) {
        return getJsonObjectManager().createInteger(path, integer);
    }

    @Override
    public String readString(String path) {
        return getJsonObjectManager().readString(path);
    }

    @Override
    public Integer readInteger(String path) {
        return getJsonObjectManager().readInteger(path);
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

    public static class Builder implements StringBuilderCreator, IntegerBuilderCreator, JsonObjectCreator {

        private JsonObjectManager jsonObjectManager;

        private Builder(JsonObjectManager jsonObjectManager) {
            this.jsonObjectManager = jsonObjectManager;
        }

        public Builder() {
            this(new ProxyJsonObjectManagerEntityFactory().createEntity());
        }

        @Override
        public Builder createString(String path, String string) {
            getJsonBuilderManager().createString(path, string);
            return this;
        }

        @Override
        public Builder createInteger(String path, Integer integer) {
            getJsonBuilderManager().createInteger(path, integer);
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
