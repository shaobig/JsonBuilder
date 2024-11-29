package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;

public interface NodeInserter {

    JsonNode insertNode(String path, Object entity);

}
