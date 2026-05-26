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
package net.croz.nrich.search.api.model.operator;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import java.util.Collection;
import java.util.Locale;
import java.util.Objects;

// TODO check if other operators are required
/**
 * Contains default operators that will be used when building queries.
 */
@SuppressWarnings("unchecked")
public enum DefaultSearchOperator implements SearchOperator {

    CONTAINS {

        @Override
        public Predicate asPredicate(CriteriaBuilder criteriaBuilder, Path<?> path, Object value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    ILIKE {

        @Override
        public Predicate asPredicate(CriteriaBuilder criteriaBuilder, Path<?> path, Object value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    LIKE {

        @Override
        public Predicate asPredicate(CriteriaBuilder criteriaBuilder, Path<?> path, Object value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    EQ {

        @Override
        public Predicate asPredicate(CriteriaBuilder criteriaBuilder, Path<?> path, Object value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    GE {

        @Override
        public Predicate asPredicate(CriteriaBuilder criteriaBuilder, Path<?> path, Object value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    LE {

        @Override
        public Predicate asPredicate(CriteriaBuilder criteriaBuilder, Path<?> path, Object value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    GT {

        @Override
        public Predicate asPredicate(CriteriaBuilder criteriaBuilder, Path<?> path, Object value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    LT {

        @Override
        public Predicate asPredicate(CriteriaBuilder criteriaBuilder, Path<?> path, Object value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    IN {

        @Override
        public Predicate asPredicate(CriteriaBuilder criteriaBuilder, Path<?> path, Object value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    LOWER_IN {

        @Override
        public Predicate asPredicate(CriteriaBuilder criteriaBuilder, Path<?> path, Object value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

}
