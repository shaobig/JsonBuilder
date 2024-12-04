package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.reader.IntegerPathReader;
import org.shaobig.json.builder.reader.StringPathReader;

public class JsonObject implements StringNodeInserter, IntegerNodeInserter, StringPathReader, IntegerPathReader {

    private JsonObjectManager jsonObjectManager;

    public JsonObject(JsonObjectManager jsonObjectManager) {
        this.jsonObjectManager = jsonObjectManager;
    }

    @Override
    public JsonNode insertString(String path, String string) {
        return getJsonObjectManager().insertString(path, string);
    }

    @Override
    public JsonNode insertInteger(String path, Integer integer) {
        return getJsonObjectManager().insertInteger(path, integer);
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

    public static class Builder implements StringJsonObjectBuilderInserter, IntegerJsonObjectBuilderInserter, JsonObjectCreator {

        private JsonObjectManager jsonObjectManager;

        private Builder(JsonObjectManager jsonObjectManager) {
            this.jsonObjectManager = jsonObjectManager;
        }

        public Builder() {
            this(new ProxyJsonObjectManagerEntityFactory().createEntity());
        }

        @Override
        public Builder insertString(String path, String string) {
            getJsonBuilderManager().insertString(path, string);
            return this;
        }

        @Override
        public Builder insertInteger(String path, Integer integer) {
            getJsonBuilderManager().insertInteger(path, integer);
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
