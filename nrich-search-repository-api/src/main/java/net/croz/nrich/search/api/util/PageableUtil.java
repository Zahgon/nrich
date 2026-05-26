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
package net.croz.nrich.search.api.util;

import net.croz.nrich.search.api.model.sort.SortDirection;
import net.croz.nrich.search.api.model.sort.SortProperty;
import net.croz.nrich.search.api.request.SortablePageableRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

// TODO maybe another project? search-util?
/**
 * Util class for converting paging and sort properties to Pageable instances.
 * Unique sort property is here since some databases do not guarantee consistent paging if sorting by non unique properties,
 * it is defined also as a separate arguments since it probably won't be sent from client.
 */
public final class PageableUtil {

    private PageableUtil() {
    }

    public static Pageable convertToPageable(SortablePageableRequest request, SortProperty uniqueSortProperty) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Pageable convertToPageable(SortablePageableRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Pageable convertToPageable(Integer pageNumber, Integer pageSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Pageable convertToPageable(Integer pageNumber, Integer pageSize, SortProperty uniqueSortProperty) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Pageable convertToPageable(Integer pageNumber, Integer pageSize, List<SortProperty> sortPropertyList) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Pageable convertToPageable(Integer pageNumber, Integer pageSize, SortProperty uniqueSortProperty, List<SortProperty> sortPropertyList) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Sort.Order convertToSortOrder(SortProperty sortProperty) {
        return sortProperty.getDirection() == SortDirection.ASC ? Sort.Order.asc(sortProperty.getProperty()) : Sort.Order.desc(sortProperty.getProperty());
    }
}
