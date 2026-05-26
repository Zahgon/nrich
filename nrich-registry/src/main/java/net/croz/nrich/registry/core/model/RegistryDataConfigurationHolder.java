/*
 *  Copyright 2020-2023 CROZ d.o.o, the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package net.croz.nrich.registry.core.model;

import net.croz.nrich.registry.core.support.ManagedTypeWrapper;
import java.util.List;
import java.util.Map;

public record RegistryDataConfigurationHolder(Map<String, ManagedTypeWrapper> classNameManagedTypeWrapperMap, List<RegistryDataConfiguration<Object, Object>> registryDataConfigurationList) {

    public void verifyConfigurationExists(String classFullName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RegistryDataConfiguration<Object, Object> findRegistryConfigurationForClass(String classFullName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ManagedTypeWrapper resolveManagedTypeWrapper(String className) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
