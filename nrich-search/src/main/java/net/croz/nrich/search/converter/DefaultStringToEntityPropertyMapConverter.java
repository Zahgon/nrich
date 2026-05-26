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
package net.croz.nrich.search.converter;

import lombok.RequiredArgsConstructor;
import net.croz.nrich.search.api.converter.StringToEntityPropertyMapConverter;
import net.croz.nrich.search.api.converter.StringToTypeConverter;
import net.croz.nrich.search.api.model.property.SearchPropertyConfiguration;
import net.croz.nrich.search.model.AttributeHolder;
import net.croz.nrich.search.support.JpaEntityAttributeResolver;
import net.croz.nrich.search.util.PathResolvingUtil;
import net.croz.nrich.search.util.PropertyNameUtil;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import jakarta.persistence.metamodel.Attribute;
import jakarta.persistence.metamodel.IdentifiableType;
import jakarta.persistence.metamodel.ManagedType;
import jakarta.persistence.metamodel.PluralAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class DefaultStringToEntityPropertyMapConverter implements StringToEntityPropertyMapConverter {

    private final List<StringToTypeConverter<?>> converterList;

    @Override
    public Map<String, Object> convert(String value, List<String> propertyToSearchList, ManagedType<?> managedType, SearchPropertyConfiguration searchPropertyConfiguration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Object doConversion(String searchTerm, Class<?> attributeType) {
        if (String.class.isAssignableFrom(attributeType)) {
            return searchTerm;
        }
        StringToTypeConverter<?> converter = converterList.stream().filter(value -> value.supports(attributeType)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.format("No converter found for attribute type %s", attributeType.getName())));
        return converter.convert(searchTerm, attributeType);
    }

    private IdentifiableType<?> asIdentifiableType(Attribute<?, ?> attribute) {
        if (attribute instanceof SingularAttribute<?, ?> singularAttribute && singularAttribute.getType() instanceof IdentifiableType<?> identifiableType) {
            return identifiableType;
        }
        if (attribute instanceof PluralAttribute<?, ?, ?> pluralAttribute && pluralAttribute.getElementType() instanceof IdentifiableType<?> identifiableType) {
            return identifiableType;
        }
        return null;
    }
}
