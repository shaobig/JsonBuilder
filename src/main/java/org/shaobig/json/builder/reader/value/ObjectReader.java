package org.shaobig.json.builder.reader.value;

public interface ObjectReader {

    <T> T readObject(String path, Class<T> valueType);

}
