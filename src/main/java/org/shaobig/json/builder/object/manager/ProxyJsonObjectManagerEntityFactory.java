package org.shaobig.json.builder.object.manager;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.creator.merger.NodeMerger;
import org.shaobig.json.builder.object.JsonNodeEntityFactory;
import org.shaobig.json.builder.object.manager.creator.ProxyMergerNodeCreatorManagerEntityFactory;
import org.shaobig.json.builder.object.manager.creator.merger.JsonNodeMergerEntityFactory;
import org.shaobig.json.builder.object.manager.reader.ProxyGenericPathReaderManagerEntityFactory;

public class ProxyJsonObjectManagerEntityFactory implements EntityFactory<JsonObjectManager> {

    private EntityFactory<JsonNode> jsonNodeEntityFactory;
    private EntityFactory<NodeMerger<JsonNode>> nodeMergerEntityFactory;

    private ProxyJsonObjectManagerEntityFactory(EntityFactory<JsonNode> jsonNodeEntityFactory, EntityFactory<NodeMerger<JsonNode>> nodeMergerEntityFactory) {
        this.jsonNodeEntityFactory = jsonNodeEntityFactory;
        this.nodeMergerEntityFactory = nodeMergerEntityFactory;
    }

    public ProxyJsonObjectManagerEntityFactory() {
        this(new JsonNodeEntityFactory(), new JsonNodeMergerEntityFactory());
    }

    @Override
    public JsonObjectManager createEntity() {
        JsonNode jsonNode = getJsonNodeEntityFactory().createEntity();
        return new JsonObjectManagerEntityFactory(() -> jsonNode, new ProxyMergerNodeCreatorManagerEntityFactory(jsonNode, getNodeMergerEntityFactory().createEntity()), new ProxyGenericPathReaderManagerEntityFactory(jsonNode)).createEntity();
    }

    public EntityFactory<JsonNode> getJsonNodeEntityFactory() {
        return jsonNodeEntityFactory;
    }

    public void setJsonNodeEntityFactory(EntityFactory<JsonNode> jsonNodeEntityFactory) {
        this.jsonNodeEntityFactory = jsonNodeEntityFactory;
    }

    public EntityFactory<NodeMerger<JsonNode>> getNodeMergerEntityFactory() {
        return nodeMergerEntityFactory;
    }

    public void setNodeMergerEntityFactory(EntityFactory<NodeMerger<JsonNode>> nodeMergerEntityFactory) {
        this.nodeMergerEntityFactory = nodeMergerEntityFactory;
    }

}
