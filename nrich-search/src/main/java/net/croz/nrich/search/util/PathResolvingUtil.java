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
package net.croz.nrich.search.util;

import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.metamodel.Attribute;
import jakarta.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public final class PathResolvingUtil {

    private static final String PATH_SEPARATOR = ".";

    private static final String PATH_REGEX = "\\.";

    // Hibernate will throw an exception if trying to find as an attribute but it can be used as an condition and as an projection
    private static final String CLASS_ATTRIBUTE_NAME = "class";

    private PathResolvingUtil() {
    }

    public static String[] convertToPathList(String path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String joinPath(String... pathList) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String joinPath(List<String> pathList, String currentPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String removeFirstPathElement(String[] path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Path<?> calculateFullPath(Path<?> rootPath, JoinType defaultJoinType, String[] pathList) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static boolean shouldJoinPath(Path<?> calculatedPath, String currentPathSegment) {
        if (CLASS_ATTRIBUTE_NAME.equals(currentPathSegment)) {
            return false;
        }
        if (calculatedPath.getModel() instanceof EntityType<?> entityType) {
            Attribute<?, ?> attribute = AttributeResolvingUtil.resolveAttributeByName(entityType, currentPathSegment);
            if (attribute != null) {
                return attribute.isCollection() || attribute.isAssociation();
            }
        }
        return false;
    }
}
