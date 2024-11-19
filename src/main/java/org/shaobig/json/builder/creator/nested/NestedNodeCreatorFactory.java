package org.shaobig.json.builder.creator.nested;

import org.shaobig.json.builder.creator.NodeCreator;
import org.shaobig.json.builder.factory.EntityFactory;
import org.shaobig.json.builder.factory.GenericFactoryNodeCreator;
import org.shaobig.json.builder.factory.NodeCreatorFactory;

public class NestedNodeCreatorFactory<T> implements NodeCreatorFactory<T> {

    private EntityFactory<NodeCreator<T>> nodeCreatorEntityFactory;

    public NestedNodeCreatorFactory(EntityFactory<NodeCreator<T>> nodeCreatorEntityFactory) {
        this.nodeCreatorEntityFactory = nodeCreatorEntityFactory;
    }

    @Override
    public NestedNodeCreator<T> getValueCreator() {
        return new ReversedNestedNodeCreator<>(new GenericFactoryNodeCreator<>(getNodeCreatorEntityFactory()));
    }

    public EntityFactory<NodeCreator<T>> getNodeCreatorEntityFactory() {
        return nodeCreatorEntityFactory;
    }

    public void setNodeCreatorEntityFactory(EntityFactory<NodeCreator<T>> nodeCreatorEntityFactory) {
        this.nodeCreatorEntityFactory = nodeCreatorEntityFactory;
    }

}
