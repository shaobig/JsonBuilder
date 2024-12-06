package org.shaobig.json.builder.object.manager.creator;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.MergerNodeCreator;
import org.shaobig.json.builder.object.JsonNodeSetter;

import java.util.List;

public class MergerNodeCreatorManager implements StringNodeCreator, IntegerNodeCreator, ListNodeCreator, JsonNodeSetter {

    private MergerNodeCreator<String> stringMergerNodeCreator;
    private MergerNodeCreator<Integer> integerMergerNodeCreator;
    private MergerNodeCreator<List<?>> listMergerNodeCreator;

    public MergerNodeCreatorManager(MergerNodeCreator<String> stringMergerNodeCreator, MergerNodeCreator<Integer> integerMergerNodeCreator, MergerNodeCreator<List<?>> listMergerNodeCreator) {
        this.stringMergerNodeCreator = stringMergerNodeCreator;
        this.integerMergerNodeCreator = integerMergerNodeCreator;
        this.listMergerNodeCreator = listMergerNodeCreator;
    }

    @Override
    public JsonNode createInteger(String path, Integer integer) {
        return getIntegerMergerNodeCreator().createNode(path, integer);
    }

    @Override
    public JsonNode createString(String path, String string) {
        return getStringMergerNodeCreator().createNode(path, string);
    }

    @Override
    public JsonNode createList(String path, List<?> list) {
        return getListMergerNodeCreator().createNode(path, list);
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        getIntegerMergerNodeCreator().setJsonNode(jsonNode);
        getStringMergerNodeCreator().setJsonNode(jsonNode);
        getListMergerNodeCreator().setJsonNode(jsonNode);
    }

    public MergerNodeCreator<String> getStringMergerNodeCreator() {
        return stringMergerNodeCreator;
    }

    public void setStringMergerNodeCreator(MergerNodeCreator<String> stringMergerNodeCreator) {
        this.stringMergerNodeCreator = stringMergerNodeCreator;
    }

    public MergerNodeCreator<Integer> getIntegerMergerNodeCreator() {
        return integerMergerNodeCreator;
    }

    public void setIntegerMergerNodeCreator(MergerNodeCreator<Integer> integerMergerNodeCreator) {
        this.integerMergerNodeCreator = integerMergerNodeCreator;
    }

    public MergerNodeCreator<List<?>> getListMergerNodeCreator() {
        return listMergerNodeCreator;
    }

    public void setListMergerNodeCreator(MergerNodeCreator<List<?>> listMergerNodeCreator) {
        this.listMergerNodeCreator = listMergerNodeCreator;
    }

}
