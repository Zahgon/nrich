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
package net.croz.nrich.validation.constraint.support.disableconstraints;

import lombok.RequiredArgsConstructor;
import jakarta.validation.metadata.BeanDescriptor;
import jakarta.validation.metadata.ConstraintDescriptor;
import jakarta.validation.metadata.ConstructorDescriptor;
import jakarta.validation.metadata.MethodDescriptor;
import jakarta.validation.metadata.MethodType;
import jakarta.validation.metadata.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BeanDescriptorAdapter implements BeanDescriptor {

    private final BeanDescriptor target;

    private final Map<String, List<Class<? extends Annotation>>> disabledConstraintsPathMap;

    @Override
    public PropertyDescriptor getConstraintsForProperty(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<PropertyDescriptor> getConstrainedProperties() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConstraintFinder findConstraints() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isBeanConstrained() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MethodDescriptor getConstraintsForMethod(String methodName, Class<?>... parameterTypes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<MethodDescriptor> getConstrainedMethods(MethodType methodType, MethodType... methodTypes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConstructorDescriptor getConstraintsForConstructor(Class<?>... parameterTypes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<ConstructorDescriptor> getConstrainedConstructors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean hasConstraints() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Class<?> getElementClass() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<ConstraintDescriptor<?>> getConstraintDescriptors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
