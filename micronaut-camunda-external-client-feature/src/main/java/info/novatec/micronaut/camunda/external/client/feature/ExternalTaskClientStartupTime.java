/*
 * Copyright 2021 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package info.novatec.micronaut.camunda.external.client.feature;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.server.EmbeddedServer;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;

/**
 * @author Martin Sawilla
 */
@Requires(missingBeans = EmbeddedServer.class)
@Singleton
public class ExternalTaskClientStartupTime implements ApplicationEventListener<StartupEvent> {

    private static final Logger log = LoggerFactory.getLogger(ExternalTaskClientStartupTime.class);

    @Override
    public void onApplicationEvent(StartupEvent event) {
        log.info("Application started in {} ms", ManagementFactory.getRuntimeMXBean().getUptime());
    }
}
