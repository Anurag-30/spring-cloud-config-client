
# spring-cloud-config-client
basic example of using spring-cloud-config to retrieve configs from a git-backed server.

This project assumes that there is a spring cloud config server already running backed by git repository.

Please update the `bootstrap.yml` file with the uri of spring cloud config server


### Build code

```bash
git clone https://github.com/Anurag-30/spring-cloud-config-client.git
cd spring-cloud-config-client
mvn clean package
```

### Start Client App
```bash
java -jar client/target/*jar
```

Load [http://localhost:8080](http://localhost:8080) to see the property from the server. 
Alternatively, you can inspect the properties and their sources from the spring-boot-actuator
endpoint at [http://localhost:8080/env](http://localhost:8080/env)

### Reload configuration from server (at runtime)

Spring Cloud Config has a `@RefreshScope` mechanism to allow beans to be reinitialized
on demand to fetch updated configuration values. The AppController on the client
has this annotation, so it will display the new config value once the refresh
endpoint is called.

```bash
curl -X POST 'http://localhost:8080/refresh'
```

### QUICK START

I have pushed the jar for spring cloud config client. you can directly run it .

```
java -jar client/target/spring-cloud-config-client-1.0-SNAPSHOT.jar

```

### ISSUES YOU MIGHT COME ACCROSS

JAVADOC error while running `mvn clean package`
  
RESOLUTION: ``mvn clean package -Dmaven.javadoc.skip=true verify``