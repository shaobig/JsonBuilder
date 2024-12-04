package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.creator.merger.NodeMerger;

public class MergerNodeCreatorEntityFactory<T> implements EntityFactory<MergerNodeCreator<T>> {

    private JsonNode jsonNode;
    private NodeMerger nodeMerger;
    private NodeCreator<T> nodeCreator;

    public MergerNodeCreatorEntityFactory(JsonNode jsonNode, NodeMerger nodeMerger, NodeCreator<T> nodeCreator) {
        this.jsonNode = jsonNode;
        this.nodeMerger = nodeMerger;
        this.nodeCreator = nodeCreator;
    }

    @Override
    public MergerNodeCreator<T> createEntity() {
        return new MergerNodeCreator<>(getJsonNode(), getNodeMerger(), new NestedNodeCreator<>(getNodeCreator()));
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    public NodeMerger getNodeMerger() {
        return nodeMerger;
    }

    public void setNodeMerger(NodeMerger nodeMerger) {
        this.nodeMerger = nodeMerger;
    }

    public NodeCreator<T> getNodeCreator() {
        return nodeCreator;
    }

    public void setNodeCreator(NodeCreator<T> nodeCreator) {
        this.nodeCreator = nodeCreator;
    }

}
