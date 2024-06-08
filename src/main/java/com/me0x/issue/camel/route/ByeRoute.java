package com.me0x.issue.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Teodor MAMOLEA
 */
@Component
public class ByeRoute extends RouteBuilder {

    @Override
    public void configure() {
        onException(RuntimeException.class)
                .routeGroup("API")
                .handled(true)
                .transform()
                .constant("<message>Exception!</message>");

        rest("/say")
                .get("/bye")
                .to("direct:bye");

        from("direct:bye")
                .group("API")
                .transform()
                .constant("<message>Bye World!</message>");
    }

}
