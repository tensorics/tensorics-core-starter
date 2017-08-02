/**
 * Copyright (c) 2017 European Organisation for Nuclear Research (CERN), All Rights Reserved.
 */

package org.tensorics.core.starter;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tensorics.core.resolve.engine.ResolvingEngine;
import org.tensorics.core.resolve.engine.ResolvingEngines;
import org.tensorics.core.resolve.resolvers.Resolver;

@Configuration
public class TensoricsCoreDefaultConfiguration {
    
    @Bean
    public ResolvingEngine resolvingEngine(List<Resolver<?, ?>> resolvers) {
        return ResolvingEngines.defaultEngineWithAdditional(resolvers.stream().toArray(Resolver[]::new));
    }

}
