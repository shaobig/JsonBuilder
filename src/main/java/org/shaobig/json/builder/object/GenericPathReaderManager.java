package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.reader.path.GenericPathReader;
import org.shaobig.json.builder.reader.path.IntegerPathReader;
import org.shaobig.json.builder.reader.path.StringPathReader;

public class GenericPathReaderManager implements StringPathReader, IntegerPathReader, JsonNodeSetter {

    private GenericPathReader<String> stringGenericPathReader;
    private GenericPathReader<Integer> integerGenericPathReader;

    public GenericPathReaderManager(GenericPathReader<String> stringGenericPathReader, GenericPathReader<Integer> integerGenericPathReader) {
        this.stringGenericPathReader = stringGenericPathReader;
        this.integerGenericPathReader = integerGenericPathReader;
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
    public void setJsonNode(JsonNode jsonNode) {
        getStringGenericPathReader().setJsonNode(jsonNode);
        getIntegerGenericPathReader().setJsonNode(jsonNode);
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

}
