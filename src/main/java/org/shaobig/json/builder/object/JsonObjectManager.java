package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.NodeCreator;
import org.shaobig.json.builder.creator.merger.MergerNodeCreator;
import org.shaobig.json.builder.reader.PathReader;
import org.shaobig.json.builder.reader.StringPathReader;

public class JsonObjectManager implements NodeCreator<Object>, StringPathReader {

    private JsonNode jsonNode;
    private MergerNodeCreator<Object> objectNodeCreator;
    private PathReader<String> stringPathReader;

    public JsonObjectManager(JsonNode jsonNode, MergerNodeCreator<Object> objectNodeCreator, PathReader<String> stringPathReader) {
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

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
        getObjectNodeCreator().setJsonNode(jsonNode);
    }

    public MergerNodeCreator<Object> getObjectNodeCreator() {
        return objectNodeCreator;
    }

    public void setObjectNodeCreator(MergerNodeCreator<Object> objectNodeCreator) {
        this.objectNodeCreator = objectNodeCreator;
    }

    public PathReader<String> getStringPathReader() {
        return stringPathReader;
    }

    public void setStringPathReader(PathReader<String> stringPathReader) {
        this.stringPathReader = stringPathReader;
    }

    @Override
    public String toString() {
        return getJsonNode().toString();
    }

}
