package org.shaobig.json.builder.creator.entity.list;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.shaobig.json.builder.creator.NodeSupplier;

public class ArrayNodeSupplier implements NodeSupplier<ArrayNode> {

    @Override
    public ArrayNode supplyNode() {
        return new ObjectMapper().createArrayNode();
    }

}
