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
package net.croz.nrich.encrypt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.croz.nrich.encrypt.api.model.EncryptionContext;
import net.croz.nrich.encrypt.api.model.EncryptionOperation;
import net.croz.nrich.encrypt.api.service.DataEncryptionService;
import net.croz.nrich.encrypt.api.service.TextEncryptionService;
import net.croz.nrich.encrypt.constants.EncryptConstants;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.CollectionUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class DefaultDataEncryptService implements DataEncryptionService {

    private final TextEncryptionService textEncryptionService;

    @Override
    public <T> T encryptData(T data, List<String> pathToEncryptDecryptList, EncryptionContext encryptionContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T decryptData(T data, List<String> pathToEncryptDecryptList, EncryptionContext encryptionContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected <T> T encryptDecryptData(T data, List<String> pathToEncryptDecryptList, EncryptionContext encryptionContext, EncryptionOperation encryptionOperation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void executeEncryptionOperation(EncryptionContext encryptionContext, Object object, String targetPath, EncryptionOperation operation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void encryptDecryptNestedValue(EncryptionContext encryptionContext, Object objectContainingFieldsToEncryptOrDecrypt, String propertyName, EncryptionOperation operation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void encryptDecryptValue(EncryptionContext encryptionContext, Object objectContainingFieldsToEncryptOrDecrypt, String propertyName, EncryptionOperation operation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected Object encryptDecryptValue(EncryptionContext encryptionContext, Object value, EncryptionOperation operation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected Object getPropertyValueByPath(Object holder, String path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    protected void setPropertyValueByPath(Object holder, String path, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String encryptDecryptText(EncryptionContext encryptionContext, String text, EncryptionOperation operation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean isSupportedCollection(Object value) {
        return value instanceof List || value instanceof Set;
    }
}
