package org.shaobig.json.builder.reader.path;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Arrays;

public class NestedJsonPathReader extends JsonPathReader {

    private static final String DELIMITER_REG_EXP = "\\.";

    public NestedJsonPathReader(JsonNode jsonNode) {
        super(jsonNode);
    }

    @Override
    public JsonNode readPath(String path) {
        return Arrays.stream(path.split(DELIMITER_REG_EXP))
                .reduce(getJsonNode(), JsonNode::get, (jsonNodes, jsonNodes2) -> jsonNodes);
    }

}
