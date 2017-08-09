/**
 * Copyright (c) 2017 European Organisation for Nuclear Research (CERN), All Rights Reserved.
 */

package org.tensorics.core.starter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tensorics.core.resolve.engine.ResolvingEngine;
import org.tensorics.core.resolve.engine.ResolvingEngines;
import org.tensorics.core.resolve.resolvers.Resolver;

@Configuration
public class TensoricsCoreDefaultConfiguration {
    
    @Autowired(required=false)
    private List<Resolver<?, ?>> resolvers;

    @Bean
    public ResolvingEngine resolvingEngine() {
        if(resolvers == null) {
            return ResolvingEngines.defaultEngine();
        }
        return ResolvingEngines.defaultEngineWithAdditional(resolvers.stream().toArray(Resolver[]::new));
    }

}
