package org.shaobig.json.builder.object.manager.creator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.creator.MergerNodeCreatorEntityFactory;
import org.shaobig.json.builder.creator.NestedNodeCreator;
import org.shaobig.json.builder.creator.NodeSupplier;
import org.shaobig.json.builder.creator.ObjectNodeSupplier;
import org.shaobig.json.builder.creator.entity.IntegerEntityNodeCreator;
import org.shaobig.json.builder.creator.entity.StringEntityNodeCreator;
import org.shaobig.json.builder.creator.merger.NodeMerger;

public class ProxyMergerNodeCreatorManagerEntityFactory implements EntityFactory<MergerNodeCreatorManager> {

    private JsonNode jsonNode;
    private NodeMerger<JsonNode> nodeMerger;

    public ProxyMergerNodeCreatorManagerEntityFactory(JsonNode jsonNode, NodeMerger<JsonNode> nodeMerger) {
        this.jsonNode = jsonNode;
        this.nodeMerger = nodeMerger;
    }

    @Override
    public MergerNodeCreatorManager createEntity() {
        NodeSupplier<ObjectNode> objectNodeSupplier = new ObjectNodeSupplier();
        return new MergerNodeCreatorManagerEntityFactory(new MergerNodeCreatorEntityFactory<>(getJsonNode(), getNodeMerger(), new NestedNodeCreator<>(new StringEntityNodeCreator(objectNodeSupplier))), new MergerNodeCreatorEntityFactory<>(getJsonNode(), getNodeMerger(), new NestedNodeCreator<>(new IntegerEntityNodeCreator(objectNodeSupplier)))).createEntity();
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    public NodeMerger<JsonNode> getNodeMerger() {
        return nodeMerger;
    }

    public void setNodeMerger(NodeMerger<JsonNode> nodeMerger) {
        this.nodeMerger = nodeMerger;
    }

}
