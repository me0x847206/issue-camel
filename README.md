# Build

```
mvn clean install
```

The `target/camel-0.0.0-SNAPSHOT.jar` file is expected to be created.

# Run

Consider one of the below described options.

## Maven Plugin

In terminal, run the following command:

```
mvn spring-boot:run
```

Press `Ctrl + C` to stop it.

## IntelliJ IDEA

Run the `com.me0x.issue.camel.Application` class.

Press the `Stop` button to stop it.

# Functionality

Invoke the following HTTP endpoints:

```
GET http://localhost:8080/camel/say/hello
GET http://localhost:8080/camel/say/bye
```

Expected output, respectively:

```
<message>Hello World!</message>
<message>Bye World!</message>
```
