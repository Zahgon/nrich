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
package net.croz.nrich.webmvc.advice;

import lombok.RequiredArgsConstructor;
import net.croz.nrich.logging.api.service.LoggingService;
import net.croz.nrich.notification.api.model.AdditionalNotificationData;
import net.croz.nrich.notification.api.service.BaseNotificationResponseService;
import net.croz.nrich.webmvc.api.service.ExceptionAuxiliaryDataResolverService;
import net.croz.nrich.webmvc.api.service.ExceptionHttpStatusResolverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
public class NotificationErrorHandlingRestControllerAdvice {

    private final List<String> exceptionToUnwrapList;

    private final List<String> exceptionAuxiliaryDataToIncludeInNotification;

    private final BaseNotificationResponseService<?> notificationResponseService;

    private final LoggingService loggingService;

    private final ExceptionAuxiliaryDataResolverService exceptionAuxiliaryDataResolverService;

    private final ExceptionHttpStatusResolverService httpStatusResolverService;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception, HttpServletRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<Object> handleBindException(BindException exception, HttpServletRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception exception, HttpServletRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected Exception unwrapException(Exception exception) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void logExceptionWithResolvedAuxiliaryData(Exception exception, HttpServletRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected Map<String, Object> resolveExceptionAuxiliaryData(Exception exception, HttpServletRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected HttpStatus resolveHttpStatusForException(Exception exception, HttpStatus defaultStatus) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
