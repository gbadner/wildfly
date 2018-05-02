/*
 * JBoss, Home of Professional Open Source
 * Copyright 2018, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.jpa.hibernate5.service;

import java.util.Map;

import org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator;
import org.hibernate.engine.transaction.jta.platform.spi.JtaPlatform;
import org.hibernate.service.spi.ServiceRegistryImplementor;

/**
 * Custom JtaPlatform initiator for use inside WildFly picking an appropriate
 * fallback JtaPlatform.
 *
 * @author Steve Ebersole
 */
public class CustomJtaPlatformInitiator extends JtaPlatformInitiator {
    @Override
    protected JtaPlatform getFallbackProvider(Map configurationValues, ServiceRegistryImplementor registry) {
        return new org.hibernate.engine.transaction.jta.platform.internal.JBossAppServerJtaPlatform();
    }
}
