package org.shaobig.json.builder.reader.value.list;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.shaobig.json.builder.exception.WrongClassException;

import java.io.IOException;
import java.util.List;

public class ObjectMapperListValueReader implements ListValueReader {

    @Override
    public <T> List<T> readList(JsonNode jsonNode, Class<T> classType) {
        try {
            return new ObjectMapper().readerForListOf(classType).readValue(jsonNode.toString());
        }
        catch (IOException e) {
            throw new WrongClassException(String.format("Can't convert %s elements to %s", jsonNode, classType));
        }
    }

}
