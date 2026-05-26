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
package net.croz.nrich.excel.util;

import net.croz.nrich.excel.api.model.TypeDataFormat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public final class TypeDataFormatUtil {

    private TypeDataFormatUtil() {
    }

    public static List<TypeDataFormat> resolveTypeDataFormatList(String dateFormat, String dateTimeFormat, String integerNumberFormat, String decimalNumberFormat, boolean writeDateWithTime, List<TypeDataFormat> additionalTypeDataFormatList) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static TypeDataFormat findTypeDataFormat(List<TypeDataFormat> typeDataFormatList, Class<?> type) {
        return typeDataFormatList.stream().filter(typeDataFormat -> type.equals(typeDataFormat.type())).findFirst().orElse(null);
    }
}
