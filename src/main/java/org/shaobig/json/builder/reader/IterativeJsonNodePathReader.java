package org.shaobig.json.builder.reader;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Arrays;

public class IterativeJsonNodePathReader extends NodePathReader {

    private static final String DELIMITER_REG_EXP = "\\.";

    public IterativeJsonNodePathReader(JsonNode jsonNode) {
        super(jsonNode);
    }

    @Override
    public JsonNode readPath(String path) {
        String[] keyArray = path.split(DELIMITER_REG_EXP);
        return Arrays.stream(keyArray)
                .reduce(getJsonNode(), JsonNode::get, (jsonNodes, jsonNodes2) -> jsonNodes);
    }

}
