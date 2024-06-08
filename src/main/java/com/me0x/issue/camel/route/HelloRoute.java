package com.me0x.issue.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Teodor MAMOLEA
 */
@Component
public class HelloRoute extends RouteBuilder {

    @Override
    public void configure() {
        rest("/say")
                .get("/hello")
                .to("direct:hello");

        from("direct:hello")
                .group("API")
                .transform()
                .constant("<message>Hello World!</message>");
    }

}
