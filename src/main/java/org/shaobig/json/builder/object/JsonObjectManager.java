package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.NodeCreator;
import org.shaobig.json.builder.creator.merger.MergerNodeCreator;
import org.shaobig.json.builder.reader.GenericPathReader;
import org.shaobig.json.builder.reader.StringPathReader;

public class JsonObjectManager implements NodeCreator<Object>, StringPathReader, JsonNodeSetter {

    private JsonNode jsonNode;
    private MergerNodeCreator<Object> objectNodeCreator;
    private GenericPathReader<String> stringGenericPathReader;

    public JsonObjectManager(JsonNode jsonNode, MergerNodeCreator<Object> objectNodeCreator, GenericPathReader<String> stringGenericPathReader) {
        this.jsonNode = jsonNode;
        this.objectNodeCreator = objectNodeCreator;
        this.stringGenericPathReader = stringGenericPathReader;
    }

    @Override
    public JsonNode createNode(String path, Object object) {
        JsonNode jsonNode = getObjectNodeCreator().createNode(path, object);
        setJsonNode(jsonNode);
        return jsonNode;
    }

    @Override
    public String readString(String path) {
        return getStringGenericPathReader().readPath(path);
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
        getObjectNodeCreator().setJsonNode(jsonNode);
        getStringGenericPathReader().setJsonNode(jsonNode);
    }

    public MergerNodeCreator<Object> getObjectNodeCreator() {
        return objectNodeCreator;
    }

    public void setObjectNodeCreator(MergerNodeCreator<Object> objectNodeCreator) {
        this.objectNodeCreator = objectNodeCreator;
    }

    public GenericPathReader<String> getStringGenericPathReader() {
        return stringGenericPathReader;
    }

    public void setStringGenericPathReader(GenericPathReader<String> stringGenericPathReader) {
        this.stringGenericPathReader = stringGenericPathReader;
    }

    @Override
    public String toString() {
        return getJsonNode().toString();
    }

}
