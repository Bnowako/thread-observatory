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


## Docs

Sample usage of k6 scripts
### sleep.js

This will mitigate waiting for some resource

Variables:

| Name              |    Type     | Default |
|-------------------|:-----------:|--------:|
| SLEEP_TIME_MILLIS |   number    |    1000 |
| DURATION          |  number(s)  |      10 |
| RATE              | number(rps) |      10 |

```bash
k6 run -e SLEEP_TIME_MILLIS=100 -e RATE=30 -e DURATION=10 load-tests/sleep.js
```
