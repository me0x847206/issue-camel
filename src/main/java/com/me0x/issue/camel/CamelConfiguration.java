package com.me0x.issue.camel;

import static java.lang.String.format;

import org.apache.camel.CamelContext;
import org.apache.camel.model.ModelCamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author Teodor MAMOLEA
 */
@Configuration
public class CamelConfiguration implements CamelContextConfiguration {

    private static final Log LOG = LogFactory.getLog(CamelConfiguration.class);

    @Override
    public void beforeApplicationStart(final CamelContext camelContext) {
        camelContext
                .getCamelContextExtension()
                .getContextPlugin(ModelCamelContext.class)
                .getRouteDefinitions()
                .forEach(route -> LOG.info(format("Route Details: URI [%-20s]; Group [%s];", route.getInput().getUri(), route.getGroup())));
    }

    @Override
    public void afterApplicationStart(final CamelContext camelContext) {
        // no operation
    }

}
