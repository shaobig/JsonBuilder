package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;

public interface IntegerNodeInserter {

    JsonNode insertInteger(String path, Integer integer);

}
