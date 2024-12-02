package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.NodeCreator;
import org.shaobig.json.builder.creator.merger.MergerNodeCreator;
import org.shaobig.json.builder.reader.GenericPathReader;
import org.shaobig.json.builder.reader.StringPathReader;

public class JsonObjectManager implements NodeCreator<Object>, StringPathReader, JsonNodeSetter {

    private JsonNode jsonNode;
    private MergerNodeCreator<Object> objectNodeCreator;
    private GenericPathReader<String> stringPathReader;

    public JsonObjectManager(JsonNode jsonNode, MergerNodeCreator<Object> objectNodeCreator, GenericPathReader<String> stringPathReader) {
        this.jsonNode = jsonNode;
        this.objectNodeCreator = objectNodeCreator;
        this.stringPathReader = stringPathReader;
    }

    @Override
    public JsonNode createNode(String path, Object object) {
        JsonNode jsonNode = getObjectNodeCreator().createNode(path, object);
        setJsonNode(jsonNode);
        return jsonNode;
    }

    @Override
    public String readString(String path) {
        return getStringPathReader().readPath(path);
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
        getObjectNodeCreator().setJsonNode(jsonNode);
        getStringPathReader().setJsonNode(jsonNode);
    }

    public MergerNodeCreator<Object> getObjectNodeCreator() {
        return objectNodeCreator;
    }

    public void setObjectNodeCreator(MergerNodeCreator<Object> objectNodeCreator) {
        this.objectNodeCreator = objectNodeCreator;
    }

    public GenericPathReader<String> getStringPathReader() {
        return stringPathReader;
    }

    public void setStringPathReader(GenericPathReader<String> stringPathReader) {
        this.stringPathReader = stringPathReader;
    }

    @Override
    public String toString() {
        return getJsonNode().toString();
    }

}
