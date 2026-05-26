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
package net.croz.nrich.notification.service;

import lombok.RequiredArgsConstructor;
import net.croz.nrich.notification.api.service.NotificationMessageResolverService;
import net.croz.nrich.notification.constant.NotificationConstants;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class MessageSourceNotificationMessageResolverService implements NotificationMessageResolverService {

    private final MessageSource messageSource;

    @Override
    public String resolveMessage(List<String> messageCodeList, List<Object> argumentList, String defaultMessage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String resolveMessageForObjectError(Class<?> validationFailedOwningType, ObjectError objectError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<Object> argumentsWithoutMessageCodeResolvable(Object[] arguments) {
        if (arguments == null || arguments.length == 0) {
            return Collections.emptyList();
        }
        Object[] filteredArguments = arguments;
        if (arguments[0] instanceof DefaultMessageSourceResolvable) {
            filteredArguments = Arrays.copyOfRange(arguments, 1, arguments.length);
        }
        return Arrays.stream(filteredArguments).map(value -> value instanceof Object[] objectArray ? convertToString(objectArray) : value).toList();
    }

    private String convertToString(Object[] value) {
        return Arrays.toString(value).replace(NotificationConstants.LEFT_BRACKET, NotificationConstants.SPACE).replace(NotificationConstants.RIGHT_BRACKET, NotificationConstants.SPACE).trim();
    }
}
