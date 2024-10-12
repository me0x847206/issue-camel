Official opened issue:
- https://issues.apache.org/jira/browse/CAMEL-20853

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

# Issue Description

The actual issue can be seen into the application's logs:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.0)

<date>:35:58.842+03:00  INFO 61344 --- [           main] com.me0x.issue.camel.Application         : Starting Application using Java 21.0.3 with PID 61344 (/ext/secure/home/active/project/issue/camel/target/classes started by me0x847206 in /ext/secure/home/active/project/issue/camel)
<date>:35:58.844+03:00  INFO 61344 --- [           main] com.me0x.issue.camel.Application         : No active profile set, falling back to 1 default profile: "default"
<date>:35:59.333+03:00  INFO 61344 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
<date>:35:59.338+03:00  INFO 61344 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
<date>:35:59.338+03:00  INFO 61344 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.24]
<date>:35:59.358+03:00  INFO 61344 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
<date>:35:59.358+03:00  INFO 61344 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 487 ms
<date>:35:59.676+03:00  INFO 61344 --- [           main] o.a.c.c.s.CamelHttpTransportServlet      : Initialized CamelHttpTransportServlet[name=CamelServlet, contextPath=]
<date>:35:59.677+03:00  INFO 61344 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
<date>:35:59.706+03:00  INFO 61344 --- [           main] c.me0x.issue.camel.CamelConfiguration    : Route Details: URI [direct:bye          ]; Group [API];
<date>:35:59.706+03:00  INFO 61344 --- [           main] c.me0x.issue.camel.CamelConfiguration    : Route Details: URI [rest:get:/say:/bye  ]; Group [null];
<date>:35:59.706+03:00  INFO 61344 --- [           main] c.me0x.issue.camel.CamelConfiguration    : Route Details: URI [rest:get:/say:/hello]; Group [API];
<date>:35:59.776+03:00  INFO 61344 --- [           main] o.a.c.impl.engine.AbstractCamelContext   : Apache Camel 4.6.0 (camel-1) is starting
<date>:35:59.783+03:00  INFO 61344 --- [           main] o.a.c.impl.engine.AbstractCamelContext   : Routes startup (total:3 rest-dsl:2)
<date>:35:59.784+03:00  INFO 61344 --- [           main] o.a.c.impl.engine.AbstractCamelContext   :     Started route1 (direct://bye)
<date>:35:59.784+03:00  INFO 61344 --- [           main] o.a.c.impl.engine.AbstractCamelContext   :     Started route2 (rest://get:/say:/bye)
<date>:35:59.784+03:00  INFO 61344 --- [           main] o.a.c.impl.engine.AbstractCamelContext   :     Started route3 (rest://get:/say:/hello)
<date>:35:59.784+03:00  INFO 61344 --- [           main] o.a.c.impl.engine.AbstractCamelContext   : Apache Camel 4.6.0 (camel-1) started in 7ms (build:0ms init:0ms start:7ms)
<date>:35:59.785+03:00  INFO 61344 --- [           main] com.me0x.issue.camel.Application         : Started Application in 1.097 seconds (process running for 1.33)
<date>:36:00.876+03:00  INFO 61344 --- [ionShutdownHook] o.a.c.impl.engine.AbstractCamelContext   : Apache Camel 4.6.0 (camel-1) is shutting down (timeout:45s)
<date>:36:00.880+03:00  INFO 61344 --- [ionShutdownHook] o.a.c.impl.engine.AbstractCamelContext   : Routes stopped (total:3 rest-dsl:2)
<date>:36:00.880+03:00  INFO 61344 --- [ionShutdownHook] o.a.c.impl.engine.AbstractCamelContext   :     Stopped route3 (rest://get:/say:/hello)
<date>:36:00.880+03:00  INFO 61344 --- [ionShutdownHook] o.a.c.impl.engine.AbstractCamelContext   :     Stopped route2 (rest://get:/say:/bye)
<date>:36:00.880+03:00  INFO 61344 --- [ionShutdownHook] o.a.c.impl.engine.AbstractCamelContext   :     Stopped route1 (direct://bye)
<date>:36:00.882+03:00  INFO 61344 --- [ionShutdownHook] o.a.c.impl.engine.AbstractCamelContext   : Apache Camel 4.6.0 (camel-1) shutdown in 5ms (uptime:1s)
<date>:36:00.884+03:00  INFO 61344 --- [ionShutdownHook] o.a.c.c.s.CamelHttpTransportServlet      : Destroyed CamelHttpTransportServlet[CamelServlet]

Process finished with exit code 130 (interrupted by signal 2:SIGINT)
```

And specifically, the following part of them:

```
Route Details: URI [direct:bye          ]; Group [API];
Route Details: URI [rest:get:/say:/bye  ]; Group [null];
Route Details: URI [rest:get:/say:/hello]; Group [API];
```

Observations:

- The `rest:get:/say:/hello` URIed route has the `API` group;
- The `rest:get:/say:/bye` URIed route does not have any group;
- Both mentioned routes are configured into the similar way, except for
  the `bye` route, which has an `onException` clause;
- If the `onException` clause is deleted from the `bye` route, then:
    - it becomes part of the `API` group;
    - the `direct:bye` URIed route dissappears from application logs;

Expectations:

- The `rest:get:/say:/bye` URIed route has the `API` group as well even if it
  has any `onException` clause;

Or otherwise:

- How exactly a rest type of route can be part of a specific group?
