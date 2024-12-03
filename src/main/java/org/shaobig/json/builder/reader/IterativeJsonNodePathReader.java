package org.shaobig.json.builder.reader;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Arrays;

public class IterativeJsonNodePathReader implements JsonNodePathReader {

    private static final String DELIMITER_REG_EXP = "\\.";

    private JsonNode jsonNode;

    public IterativeJsonNodePathReader(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    @Override
    public JsonNode readPath(String path) {
        return Arrays.stream(path.split(DELIMITER_REG_EXP))
                .reduce(getJsonNode(), JsonNode::get, (jsonNodes, jsonNodes2) -> jsonNodes);
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

}
