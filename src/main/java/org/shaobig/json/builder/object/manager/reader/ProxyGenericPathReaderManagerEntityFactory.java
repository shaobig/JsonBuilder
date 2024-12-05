package org.shaobig.json.builder.object.manager.reader;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.reader.path.GenericPathReaderEntityFactory;
import org.shaobig.json.builder.reader.value.IntegerValueReader;
import org.shaobig.json.builder.reader.value.StringValueReader;

public class ProxyGenericPathReaderManagerEntityFactory implements EntityFactory<GenericPathReaderManager> {

    private JsonNode jsonNode;

    public ProxyGenericPathReaderManagerEntityFactory(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    @Override
    public GenericPathReaderManager createEntity() {
        return new GenericPathReaderManagerEntityFactory(new GenericPathReaderEntityFactory<>(getJsonNode(), new StringValueReader()), new GenericPathReaderEntityFactory<>(getJsonNode(), new IntegerValueReader())).createEntity();
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

}
