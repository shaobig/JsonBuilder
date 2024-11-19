package org.shaobig.json.builder.factory;

import org.shaobig.json.builder.creator.NodeCreator;

public interface NodeCreatorFactory<T> {

    NodeCreator<T> getValueCreator();

}
