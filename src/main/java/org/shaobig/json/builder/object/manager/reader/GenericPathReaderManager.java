package org.shaobig.json.builder.object.manager.reader;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.object.JsonNodeSetter;
import org.shaobig.json.builder.reader.path.ChangeableListPathReader;
import org.shaobig.json.builder.reader.path.GenericPathReader;
import org.shaobig.json.builder.reader.path.entity.IntegerPathReader;
import org.shaobig.json.builder.reader.path.entity.ListPathReader;
import org.shaobig.json.builder.reader.path.entity.StringPathReader;

import java.util.List;

public class GenericPathReaderManager implements StringPathReader, IntegerPathReader, ListPathReader, JsonNodeSetter {

    private GenericPathReader<String> stringGenericPathReader;
    private GenericPathReader<Integer> integerGenericPathReader;
    private ChangeableListPathReader changeableListPathReader;

    public GenericPathReaderManager(GenericPathReader<String> stringGenericPathReader, GenericPathReader<Integer> integerGenericPathReader, ChangeableListPathReader changeableListPathReader) {
        this.stringGenericPathReader = stringGenericPathReader;
        this.integerGenericPathReader = integerGenericPathReader;
        this.changeableListPathReader = changeableListPathReader;
    }

    @Override
    public String readString(String path) {
        return getStringGenericPathReader().readPath(path);
    }

    @Override
    public Integer readInteger(String path) {
        return getIntegerGenericPathReader().readPath(path);
    }

    @Override
    public <T> List<T> readList(String path, Class<T> classType) {
        return getChangeableListPathReader().readList(path, classType);
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        getStringGenericPathReader().setJsonNode(jsonNode);
        getIntegerGenericPathReader().setJsonNode(jsonNode);
        getChangeableListPathReader().setJsonNode(jsonNode);
    }

    public GenericPathReader<String> getStringGenericPathReader() {
        return stringGenericPathReader;
    }

    public void setStringGenericPathReader(GenericPathReader<String> stringGenericPathReader) {
        this.stringGenericPathReader = stringGenericPathReader;
    }

    public GenericPathReader<Integer> getIntegerGenericPathReader() {
        return integerGenericPathReader;
    }

    public void setIntegerGenericPathReader(GenericPathReader<Integer> integerGenericPathReader) {
        this.integerGenericPathReader = integerGenericPathReader;
    }

    public ChangeableListPathReader getChangeableListPathReader() {
        return changeableListPathReader;
    }

    public void setChangeableListPathReader(ChangeableListPathReader changeableListPathReader) {
        this.changeableListPathReader = changeableListPathReader;
    }

}
