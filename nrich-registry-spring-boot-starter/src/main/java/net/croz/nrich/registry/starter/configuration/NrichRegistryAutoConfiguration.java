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
package net.croz.nrich.registry.starter.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import net.croz.nrich.formconfiguration.api.customizer.FormConfigurationMappingCustomizer;
import net.croz.nrich.javascript.api.converter.JavaToJavascriptTypeConverter;
import net.croz.nrich.javascript.api.service.JavaToJavascriptTypeConversionService;
import net.croz.nrich.javascript.converter.DefaultJavaToJavascriptTypeConverter;
import net.croz.nrich.javascript.service.DefaultJavaToJavascriptTypeConversionService;
import net.croz.nrich.registry.api.configuration.service.RegistryConfigurationService;
import net.croz.nrich.registry.api.core.model.RegistryOverrideConfiguration;
import net.croz.nrich.registry.api.core.model.RegistryOverrideConfigurationHolder;
import net.croz.nrich.registry.api.core.service.RegistryClassResolvingService;
import net.croz.nrich.registry.api.core.service.RegistryEntityFinderService;
import net.croz.nrich.registry.api.data.interceptor.RegistryDataInterceptor;
import net.croz.nrich.registry.api.data.service.RegistryDataService;
import net.croz.nrich.registry.api.enumdata.service.RegistryEnumService;
import net.croz.nrich.registry.api.history.service.RegistryHistoryService;
import net.croz.nrich.registry.configuration.controller.RegistryConfigurationController;
import net.croz.nrich.registry.configuration.service.DefaultRegistryConfigurationService;
import net.croz.nrich.registry.core.model.RegistryDataConfiguration;
import net.croz.nrich.registry.core.model.RegistryDataConfigurationHolder;
import net.croz.nrich.registry.core.model.RegistryGroupDefinitionHolder;
import net.croz.nrich.registry.core.model.RegistryHistoryConfigurationHolder;
import net.croz.nrich.registry.core.service.DefaultRegistryClassResolvingService;
import net.croz.nrich.registry.core.service.DefaultRegistryConfigurationResolverService;
import net.croz.nrich.registry.core.service.EntityManagerRegistryEntityFinderService;
import net.croz.nrich.registry.core.service.RegistryConfigurationResolverService;
import net.croz.nrich.registry.core.support.ManagedTypeWrapper;
import net.croz.nrich.registry.data.controller.RegistryDataController;
import net.croz.nrich.registry.data.customizer.RegistryDataFormConfigurationMappingCustomizer;
import net.croz.nrich.registry.data.service.DefaultRegistryDataRequestConversionService;
import net.croz.nrich.registry.data.service.DefaultRegistryDataService;
import net.croz.nrich.registry.data.service.RegistryDataRequestConversionService;
import net.croz.nrich.registry.enumdata.controller.RegistryEnumController;
import net.croz.nrich.registry.enumdata.service.DefaultRegistryEnumService;
import net.croz.nrich.registry.history.controller.RegistryHistoryController;
import net.croz.nrich.registry.history.service.DefaultRegistryHistoryService;
import net.croz.nrich.registry.security.interceptor.RegistryConfigurationUpdateInterceptor;
import net.croz.nrich.registry.starter.properties.NrichRegistryProperties;
import net.croz.nrich.search.api.converter.StringToEntityPropertyMapConverter;
import net.croz.nrich.search.api.converter.StringToTypeConverter;
import net.croz.nrich.search.converter.DefaultStringToEntityPropertyMapConverter;
import net.croz.nrich.search.converter.DefaultStringToTypeConverter;
import net.croz.nrich.springboot.condition.ConditionalOnPropertyNotEmpty;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AutoConfigureAfter({ ValidationAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@ConditionalOnBean(EntityManagerFactory.class)
@ConditionalOnPropertyNotEmpty("nrich.registry.registry-configuration.group-definition-configuration-list")
@EnableConfigurationProperties(NrichRegistryProperties.class)
@Configuration(proxyBeanMethods = false)
public class NrichRegistryAutoConfiguration {

    private static final String ENVERS_AUDIT_READER_FACTORY = "org.hibernate.envers.AuditReaderFactory";

    private static final String REGISTRY_CONVERTER = "registry";

    @PersistenceContext
    private EntityManager entityManager;

    @ConditionalOnMissingBean
    @Bean
    public Validator validator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnMissingBean(name = "registryDataModelMapper")
    @Bean
    public ModelMapper registryDataModelMapper() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnMissingBean(name = "registryBaseModelMapper")
    @Bean
    public ModelMapper registryBaseModelMapper() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnMissingBean
    @Bean
    public ObjectMapper registryObjectMapper(List<Module> moduleList) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnProperty(name = "nrich.registry.default-converter-enabled", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(name = "registryDefaultStringToTypeConverter")
    @Bean
    public StringToTypeConverter<Object> registryDefaultStringToTypeConverter(NrichRegistryProperties registryProperties) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnMissingBean(name = "registryStringToEntityPropertyMapConverter")
    @Bean
    public StringToEntityPropertyMapConverter registryStringToEntityPropertyMapConverter(@Lazy @Autowired(required = false) Map<String, StringToTypeConverter<?>> stringToTypeConverterList) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnMissingBean
    @Bean
    public RegistryConfigurationResolverService registryConfigurationResolverService(NrichRegistryProperties registryProperties, @Autowired(required = false) List<RegistryOverrideConfigurationHolder> registryOverrideConfigurationHolderList) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnMissingBean
    @Bean
    public RegistryConfigurationUpdateInterceptor registryConfigurationUpdateInterceptor(RegistryConfigurationResolverService registryConfigurationResolverService) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnProperty(name = "nrich.registry.default-java-to-javascript-converter-enabled", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(name = "registryJavaToJavascriptTypeConverter")
    @Bean
    public JavaToJavascriptTypeConverter registryJavaToJavascriptTypeConverter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnMissingBean(name = "registryJavaToJavascriptTypeConversionService")
    @Bean
    public JavaToJavascriptTypeConversionService registryJavaToJavascriptTypeConversionService(@Autowired(required = false) List<JavaToJavascriptTypeConverter> converters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnMissingBean
    @Bean
    public RegistryConfigurationService registryConfigurationService(MessageSource messageSource, RegistryConfigurationResolverService registryConfigurationResolverService, NrichRegistryProperties registryProperties, JavaToJavascriptTypeConversionService registryJavaToJavascriptTypeConversionService) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    @ConditionalOnMissingBean
    @Bean
    public RegistryConfigurationController registryConfigurationController(RegistryConfigurationService registryConfigurationService) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnMissingBean
    @Bean
    public RegistryEntityFinderService registryEntityFinderService(ModelMapper registryBaseModelMapper, RegistryConfigurationResolverService registryConfigurationResolverService) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnMissingBean(RegistryDataService.class)
    @Bean
    public DefaultRegistryDataService registryDataService(ModelMapper registryDataModelMapper, StringToEntityPropertyMapConverter registryStringToEntityPropertyMapConverter, RegistryConfigurationResolverService registryConfigurationResolverService, @Autowired(required = false) List<RegistryDataInterceptor> interceptorList, RegistryEntityFinderService registryEntityFinderService) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnMissingBean
    @Bean
    public RegistryClassResolvingService registryClassResolvingService(RegistryConfigurationResolverService registryConfigurationResolverService, NrichRegistryProperties registryProperties) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnMissingBean
    @Bean
    public RegistryDataRequestConversionService registryDataRequestConversionService(ObjectMapper objectMapper, RegistryClassResolvingService registryClassResolvingService) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    @ConditionalOnMissingBean
    @Bean
    public RegistryDataController registryDataController(RegistryDataService registryDataService, RegistryDataRequestConversionService registryDataRequestConversionService, Validator validator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnClass(name = ENVERS_AUDIT_READER_FACTORY)
    @ConditionalOnMissingBean(RegistryHistoryService.class)
    @Bean
    public DefaultRegistryHistoryService registryHistoryService(RegistryConfigurationResolverService registryConfigurationResolverService, ModelMapper registryBaseModelMapper, RegistryEntityFinderService registryEntityFinderService) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnClass(name = ENVERS_AUDIT_READER_FACTORY)
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    @ConditionalOnMissingBean
    @Bean
    public RegistryHistoryController registryHistoryController(RegistryHistoryService registryHistoryService) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnMissingBean(name = "registryDataFormConfigurationMappingCustomizer")
    @Bean
    public FormConfigurationMappingCustomizer registryDataFormConfigurationMappingCustomizer(RegistryConfigurationResolverService registryConfigurationResolverService, RegistryClassResolvingService registryClassResolvingService) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnMissingBean(RegistryEnumService.class)
    @Bean
    public DefaultRegistryEnumService registryEnumService(MessageSource messageSource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    @ConditionalOnMissingBean
    @Bean
    public RegistryEnumController registryEnumController(RegistryEnumService registryEnumService) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private ModelMapper strictModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
