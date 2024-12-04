package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.reader.IntegerPathReader;
import org.shaobig.json.builder.reader.StringPathReader;

public class JsonObjectManager implements StringNodeInserter, IntegerNodeInserter, StringPathReader, IntegerPathReader, JsonNodeSetter {

    private JsonNode jsonNode;
    private MergerNodeCreatorManager mergerNodeCreatorManager;
    private GenericPathReaderManager genericPathReaderManager;

    public JsonObjectManager(JsonNode jsonNode, MergerNodeCreatorManager mergerNodeCreatorManager, GenericPathReaderManager genericPathReaderManager) {
        this.jsonNode = jsonNode;
        this.mergerNodeCreatorManager = mergerNodeCreatorManager;
        this.genericPathReaderManager = genericPathReaderManager;
    }

    @Override
    public JsonNode insertString(String path, String string) {
        JsonNode jsonNode = getMergerNodeCreatorManager().insertString(path, string);
        setJsonNode(jsonNode);
        return jsonNode;
    }

    @Override
    public JsonNode insertInteger(String path, Integer integer) {
        JsonNode jsonNode = getMergerNodeCreatorManager().insertInteger(path, integer);
        setJsonNode(jsonNode);
        return jsonNode;
    }

    @Override
    public String readString(String path) {
        return getGenericPathReaderManager().readString(path);
    }

    @Override
    public Integer readInteger(String path) {
        return getGenericPathReaderManager().readInteger(path);
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
        getMergerNodeCreatorManager().setJsonNode(jsonNode);
        getGenericPathReaderManager().setJsonNode(jsonNode);
    }

    public MergerNodeCreatorManager getMergerNodeCreatorManager() {
        return mergerNodeCreatorManager;
    }

    public void setMergerNodeCreatorManager(MergerNodeCreatorManager mergerNodeCreatorManager) {
        this.mergerNodeCreatorManager = mergerNodeCreatorManager;
    }

    public GenericPathReaderManager getGenericPathReaderManager() {
        return genericPathReaderManager;
    }

    public void setGenericPathReaderManager(GenericPathReaderManager genericPathReaderManager) {
        this.genericPathReaderManager = genericPathReaderManager;
    }

    @Override
    public String toString() {
        return getJsonNode().toString();
    }

}
