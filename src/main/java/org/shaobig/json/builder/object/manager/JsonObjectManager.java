package org.shaobig.json.builder.object.manager;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.object.JsonNodeSetter;
import org.shaobig.json.builder.object.manager.creator.IntegerNodeCreator;
import org.shaobig.json.builder.object.manager.creator.ListNodeCreator;
import org.shaobig.json.builder.object.manager.creator.MergerNodeCreatorManager;
import org.shaobig.json.builder.object.manager.creator.StringNodeCreator;
import org.shaobig.json.builder.object.manager.reader.GenericPathReaderManager;
import org.shaobig.json.builder.reader.path.entity.IntegerPathReader;
import org.shaobig.json.builder.reader.path.entity.ListPathReader;
import org.shaobig.json.builder.reader.path.entity.StringPathReader;

import java.util.List;

public class JsonObjectManager implements StringNodeCreator, IntegerNodeCreator, ListNodeCreator, StringPathReader, ListPathReader, IntegerPathReader, JsonNodeSetter {

    private JsonNode jsonNode;
    private MergerNodeCreatorManager mergerNodeCreatorManager;
    private GenericPathReaderManager genericPathReaderManager;

    public JsonObjectManager(JsonNode jsonNode, MergerNodeCreatorManager mergerNodeCreatorManager, GenericPathReaderManager genericPathReaderManager) {
        this.jsonNode = jsonNode;
        this.mergerNodeCreatorManager = mergerNodeCreatorManager;
        this.genericPathReaderManager = genericPathReaderManager;
    }

    @Override
    public JsonNode createString(String path, String string) {
        JsonNode jsonNode = getMergerNodeCreatorManager().createString(path, string);
        setJsonNode(jsonNode);
        return jsonNode;
    }

    @Override
    public JsonNode createInteger(String path, Integer integer) {
        JsonNode jsonNode = getMergerNodeCreatorManager().createInteger(path, integer);
        setJsonNode(jsonNode);
        return jsonNode;
    }

    @Override
    public JsonNode createList(String path, List<?> list) {
        JsonNode jsonNode = getMergerNodeCreatorManager().createList(path, list);
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

    @Override
    public <T> List<T> readList(String path, Class<T> classType) {
        return getGenericPathReaderManager().readList(path, classType);
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
