package org.shaobig.json.builder.reader.value.list;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface ListValueReader {

    <T> List<T> readList(JsonNode jsonNode, Class<T> classType);

}
