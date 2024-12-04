package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.MergerNodeCreator;

public class MergerNodeCreatorManager implements StringNodeInserter, IntegerNodeInserter, JsonNodeSetter {

    private MergerNodeCreator<String> stringMergerNodeCreator;
    private MergerNodeCreator<Integer> integerMergerNodeCreator;

    public MergerNodeCreatorManager(MergerNodeCreator<String> stringMergerNodeCreator, MergerNodeCreator<Integer> integerMergerNodeCreator) {
        this.stringMergerNodeCreator = stringMergerNodeCreator;
        this.integerMergerNodeCreator = integerMergerNodeCreator;
    }

    @Override
    public JsonNode insertInteger(String path, Integer integer) {
        JsonNode jsonNode = getIntegerMergerNodeCreator().createNode(path, integer);
        setJsonNode(jsonNode);
        return jsonNode;
    }

    @Override
    public JsonNode insertString(String path, String string) {
        JsonNode jsonNode = getStringMergerNodeCreator().createNode(path, string);
        setJsonNode(jsonNode);
        return jsonNode;
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        getIntegerMergerNodeCreator().setJsonNode(jsonNode);
        getStringMergerNodeCreator().setJsonNode(jsonNode);
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

}
