package org.shaobig.json.builder.reader;

public class GenericPathReader<T> implements PathReader<T> {

    private NodePathReader jsonNodePathReader;
    private ValueReader<T> valueReader;

    public GenericPathReader(NodePathReader jsonNodePathReader, ValueReader<T> valueReader) {
        this.jsonNodePathReader = jsonNodePathReader;
        this.valueReader = valueReader;
    }

    @Override
    public T readPath(String path) {
        return getValueReader().readValue(getJsonNodePathReader().readPath(path));
    }

    public NodePathReader getJsonNodePathReader() {
        return jsonNodePathReader;
    }

    public void setJsonNodePathReader(NodePathReader jsonNodePathReader) {
        this.jsonNodePathReader = jsonNodePathReader;
    }

    public ValueReader<T> getValueReader() {
        return valueReader;
    }

    public void setValueReader(ValueReader<T> valueReader) {
        this.valueReader = valueReader;
    }

}
