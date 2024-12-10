package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.object.builder.IntegerBuilderCreator;
import org.shaobig.json.builder.object.builder.JsonObjectBuilderCreator;
import org.shaobig.json.builder.object.builder.ListBuilderCreator;
import org.shaobig.json.builder.object.builder.StringBuilderCreator;
import org.shaobig.json.builder.object.manager.JsonObjectManager;
import org.shaobig.json.builder.object.manager.ProxyJsonObjectManagerEntityFactory;
import org.shaobig.json.builder.object.manager.creator.IntegerNodeCreator;
import org.shaobig.json.builder.object.manager.creator.ListNodeCreator;
import org.shaobig.json.builder.object.manager.creator.StringNodeCreator;
import org.shaobig.json.builder.reader.path.entity.IntegerPathReader;
import org.shaobig.json.builder.reader.path.entity.ListPathReader;
import org.shaobig.json.builder.reader.path.entity.StringPathReader;

import java.util.List;

public class JsonObject implements StringNodeCreator, IntegerNodeCreator, ListNodeCreator, StringPathReader, IntegerPathReader, ListPathReader {

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
    public JsonNode createList(String path, List<?> list) {
        return getJsonObjectManager().createList(path, list);
    }

    @Override
    public String readString(String path) {
        return getJsonObjectManager().readString(path);
    }

    @Override
    public Integer readInteger(String path) {
        return getJsonObjectManager().readInteger(path);
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

    public static class Builder implements StringBuilderCreator, IntegerBuilderCreator, ListBuilderCreator, JsonObjectBuilderCreator {

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
        public Builder createList(String path, List<?> list) {
            getJsonBuilderManager().createList(path, list);
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
