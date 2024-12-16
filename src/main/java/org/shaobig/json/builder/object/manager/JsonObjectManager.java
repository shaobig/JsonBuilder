package org.shaobig.json.builder.object.manager;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.ObjectCreator;
import org.shaobig.json.builder.object.JsonNodeSetter;
import org.shaobig.json.builder.reader.value.ListObjectReader;
import org.shaobig.json.builder.reader.value.ObjectReader;

import java.util.List;

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

}
