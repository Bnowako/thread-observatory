Want to see what is happening to threads in your application?

Requirements

- Java 17
- Docker
- K6 run:

```bash
brew install k6
```

1. In docker-compose.yml add host ip

### Thread observatory for:

- Classic thread per request server
- Coroutine based server

`Work in progress phase!`

# Docs

## JVM arguments

Remember that the key thing is to tune JVM parameters

JVM start heap size: ```-Xms512m```
JVM max heap size: ```-Xmx512m```

# k6 scripts

### Variables for all scripts:

| Name              |    Type     | Default |
|-------------------|:-----------:|--------:|
| SLEEP_TIME_MILLIS |   number    |    1000 |
| DURATION          |  number(s)  |      10 |
| RATE              | number(rps) |      10 |


## sleep.js

This will mitigate waiting for some resource
### Specific variable

| Name              |    Type     | Default |
|-------------------|:-----------:|--------:|
| SLEEP_TIME_MILLIS |   number    |    1000 |

```bash
k6 run -e SLEEP_TIME_MILLIS=100 -e RATE=30 -e DURATION=10 load-tests/sleep.js
```

## sleep.js

This will mitigate waiting for some resource
### Specific variable

| Name          |  Type  | Default |
|---------------|:------:|--------:|
| OBJECTS_COUNT | number |     100 |

```bash
k6 run -e OBJECTS_COUNT=2115 load-tests/spawn.js 
```
