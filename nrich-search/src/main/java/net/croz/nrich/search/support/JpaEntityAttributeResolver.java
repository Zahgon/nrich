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
package net.croz.nrich.search.support;

import net.croz.nrich.search.model.AttributeHolder;
import net.croz.nrich.search.util.AttributeResolvingUtil;
import net.croz.nrich.search.util.PathResolvingUtil;
import org.springframework.util.Assert;
import jakarta.persistence.metamodel.Attribute;
import jakarta.persistence.metamodel.ManagedType;
import jakarta.persistence.metamodel.PluralAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import java.util.Arrays;

public record JpaEntityAttributeResolver(ManagedType<?> managedType) {

    public AttributeHolder resolveAttributeByPath(String path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private ManagedType<?> resolveManagedTypeFromAttribute(Attribute<?, ?> attribute) {
        ManagedType<?> currentManagedType = null;
        if (attribute instanceof SingularAttribute && ((SingularAttribute<?, ?>) attribute).getType() instanceof ManagedType<?> attributeManagedType) {
            currentManagedType = attributeManagedType;
        } else if (attribute instanceof PluralAttribute && ((PluralAttribute<?, ?, ?>) attribute).getElementType() instanceof ManagedType<?> attributeManagedType) {
            currentManagedType = attributeManagedType;
        }
        return currentManagedType;
    }
}
