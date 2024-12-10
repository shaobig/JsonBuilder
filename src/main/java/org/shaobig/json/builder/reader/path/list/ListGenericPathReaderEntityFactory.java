package org.shaobig.json.builder.reader.path.list;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.reader.path.ChangeableListPathReader;
import org.shaobig.json.builder.reader.path.IterativeChangeablePathReader;
import org.shaobig.json.builder.reader.path.ValidationChangeablePathReader;
import org.shaobig.json.builder.reader.value.list.ListValueReader;

public class ListGenericPathReaderEntityFactory implements EntityFactory<ChangeableListPathReader> {

    private JsonNode jsonNode;
    private ListValueReader listValueReader;

    public ListGenericPathReaderEntityFactory(JsonNode jsonNode, ListValueReader listValueReader) {
        this.jsonNode = jsonNode;
        this.listValueReader = listValueReader;
    }

    @Override
    public ChangeableListPathReader createEntity() {
        return new ListGenericPathReader(new ValidationChangeablePathReader(new IterativeChangeablePathReader(getJsonNode())), getListValueReader());
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    public ListValueReader getListValueReader() {
        return listValueReader;
    }

    public void setListValueReader(ListValueReader listValueReader) {
        this.listValueReader = listValueReader;
    }

}
