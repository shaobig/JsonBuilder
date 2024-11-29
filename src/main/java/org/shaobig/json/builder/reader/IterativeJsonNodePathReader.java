package org.shaobig.json.builder.reader;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Arrays;

public class IterativeJsonNodePathReader implements PathReader<JsonNode> {

    private static final String DELIMITER_REG_EXP = "\\.";

    private JsonNode jsonNode;

    public IterativeJsonNodePathReader(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    @Override
    public JsonNode readPath(String path) {
        String[] keyArray = path.split(DELIMITER_REG_EXP);
        return Arrays.stream(keyArray)
                .reduce(getJsonNode(), JsonNode::get, (jsonNodes, jsonNodes2) -> jsonNodes);
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

}
