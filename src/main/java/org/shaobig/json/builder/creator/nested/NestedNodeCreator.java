package org.shaobig.json.builder.creator.nested;

import org.shaobig.json.builder.creator.NodeCreator;
import org.shaobig.json.builder.factory.FactoryNodeCreator;

public abstract class NestedNodeCreator<T> implements NodeCreator<T> {

    private FactoryNodeCreator<T> valueCreator;

    public NestedNodeCreator(FactoryNodeCreator<T> valueCreator) {
        this.valueCreator = valueCreator;
    }

    public FactoryNodeCreator<T> getValueCreator() {
        return valueCreator;
    }

    public void setValueCreator(FactoryNodeCreator<T> valueCreator) {
        this.valueCreator = valueCreator;
    }

}
