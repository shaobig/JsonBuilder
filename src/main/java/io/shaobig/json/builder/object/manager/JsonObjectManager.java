package io.shaobig.json.builder.object.manager;

import com.fasterxml.jackson.databind.JsonNode;
import io.shaobig.json.builder.creator.ObjectCreator;
import io.shaobig.json.builder.object.JsonNodeSetter;
import io.shaobig.json.builder.reader.value.ListObjectReader;
import io.shaobig.json.builder.reader.value.ObjectReader;

import java.util.List;
import java.util.Objects;

public class JsonObjectManager implements ObjectCreator, ObjectReader, ListObjectReader, JsonNodeSetter {

    private JsonNode jsonNode;
    private ObjectCreatorManager objectCreatorManager;
    private ObjectReaderManager objectReaderManager;

    public JsonObjectManager(JsonNode jsonNode, ObjectCreatorManager objectCreatorManager, ObjectReaderManager objectReaderManager) {
        this.jsonNode = jsonNode;
        this.objectCreatorManager = objectCreatorManager;
        this.objectReaderManager = objectReaderManager;
    }

    @Override
    public JsonNode createObject(String path, Object object) {
        JsonNode jsonNode = getObjectCreatorManager().createObject(path, object);
        setJsonNode(jsonNode);
        return jsonNode;
    }

    @Override
    public <T> List<T> readList(String path, Class<T> valueType) {
        return getObjectReaderManager().readList(path, valueType);
    }

    @Override
    public <T> T readObject(String path, Class<T> valueType) {
        return getObjectReaderManager().readObject(path, valueType);
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
        getObjectCreatorManager().setJsonNode(jsonNode);
        getObjectReaderManager().setJsonNode(jsonNode);
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public ObjectCreatorManager getObjectCreatorManager() {
        return objectCreatorManager;
    }

    public void setObjectCreatorManager(ObjectCreatorManager objectCreatorManager) {
        this.objectCreatorManager = objectCreatorManager;
    }

    public ObjectReaderManager getObjectReaderManager() {
        return objectReaderManager;
    }

    public void setObjectReaderManager(ObjectReaderManager objectReaderManager) {
        this.objectReaderManager = objectReaderManager;
    }

    @Override
    public String toString() {
        return getJsonNode().toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        JsonObjectManager that = (JsonObjectManager) object;
        return Objects.equals(jsonNode, that.jsonNode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(jsonNode);
    }
}
