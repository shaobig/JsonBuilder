package org.shaobig.json.builder.reader.value.object.reader;

import com.fasterxml.jackson.databind.ObjectReader;

public interface ObjectReaderSupplier {

    <T> ObjectReader getObjectReader(Class<T> valueType);

}
