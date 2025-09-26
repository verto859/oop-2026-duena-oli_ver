# Proxy

A structural design pattern that allows us to substitute an object with another object.

## Use cases

Access control → Check permissions before calling pay()

Lazy initialization → Create the real object only when needed

Remote proxy → Handle communication with a remote service

Caching proxy → Cache results from expensive operations

## An example

```mermaid
classDiagram
    class JSONStore {
        -_data Dict[str, Any]
        -__db str

        +set(key: str, value: Any)
        +get(key: str) Any
        +delete(key: str)
    }

    class JSONStoreProxy {
        +JSONStoreProxy()

        +set(key: str, value: Any)
        +get(key: str) Any
        +delete(key: str)
    }

    JSONStore <|-- JSONStoreProxy
```


