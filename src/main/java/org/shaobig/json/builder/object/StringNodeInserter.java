package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;

public interface StringNodeInserter {

    JsonNode insertString(String path, String string);

}
