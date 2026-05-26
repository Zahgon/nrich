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
package net.croz.nrich.search.api.factory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import jakarta.persistence.EntityManager;

/**
 * Factory that supports creating repository factories for {@link net.croz.nrich.search.api.repository.SearchExecutor} and {@link net.croz.nrich.search.api.repository.StringSearchExecutor} interfaces.
 *
 * @param <T> repository type
 * @param <S> entity type
 * @param <I> id type
 */
public class SearchExecutorJpaRepositoryFactoryBean<T extends Repository<S, I>, S, I> extends JpaRepositoryFactoryBean<T, S, I> {

    private RepositoryFactorySupportFactory repositoryFactorySupportFactory;

    private BeanFactory beanFactory;

    private final Class<? extends T> repositoryInterface;

    public SearchExecutorJpaRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
        this.repositoryInterface = repositoryInterface;
    }

    @Override
    public void afterPropertiesSet() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
