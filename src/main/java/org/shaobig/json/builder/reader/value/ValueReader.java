package org.shaobig.json.builder.reader.value;

public interface ValueReader {

    <T> T readValue(String path, Class<T> valueType);

}
