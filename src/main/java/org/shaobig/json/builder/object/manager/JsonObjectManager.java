package org.shaobig.json.builder.object.manager;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.NodeCreator;
import org.shaobig.json.builder.object.JsonNodeSetter;
import org.shaobig.json.builder.reader.value.ListValueReader;
import org.shaobig.json.builder.reader.value.ValueReader;

import java.util.List;

public class JsonObjectManager implements NodeCreator, ValueReader, ListValueReader, JsonNodeSetter {

    private JsonNode jsonNode;
    private NodeCreatorManager nodeCreatorManager;
    private ValueReaderManager valueReaderManager;

    public JsonObjectManager(JsonNode jsonNode, NodeCreatorManager nodeCreatorManager, ValueReaderManager valueReaderManager) {
        this.jsonNode = jsonNode;
        this.nodeCreatorManager = nodeCreatorManager;
        this.valueReaderManager = valueReaderManager;
    }

    @Override
    public JsonNode createNode(String path, Object object) {
        JsonNode jsonNode = getNodeCreatorManager().createNode(path, object);
        setJsonNode(jsonNode);
        return jsonNode;
    }

    @Override
    public <T> List<T> readList(String path, Class<T> valueType) {
        return getValueReaderManager().readList(path, valueType);
    }

    @Override
    public <T> T readValue(String path, Class<T> valueType) {
        return getValueReaderManager().readValue(path, valueType);
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
        getNodeCreatorManager().setJsonNode(jsonNode);
        getValueReaderManager().setJsonNode(jsonNode);
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public NodeCreatorManager getNodeCreatorManager() {
        return nodeCreatorManager;
    }

    public void setNodeCreatorManager(NodeCreatorManager nodeCreatorManager) {
        this.nodeCreatorManager = nodeCreatorManager;
    }

    public ValueReaderManager getValueReaderManager() {
        return valueReaderManager;
    }

    public void setValueReaderManager(ValueReaderManager valueReaderManager) {
        this.valueReaderManager = valueReaderManager;
    }

    @Override
    public String toString() {
        return getJsonNode().toString();
    }

}
