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
package net.croz.nrich.excel.service;

import lombok.RequiredArgsConstructor;
import net.croz.nrich.excel.api.generator.ExcelReportGenerator;
import net.croz.nrich.excel.api.generator.ExcelReportGeneratorFactory;
import net.croz.nrich.excel.api.model.MultiRowDataProvider;
import net.croz.nrich.excel.api.request.CreateExcelReportRequest;
import net.croz.nrich.excel.api.request.CreateReportGeneratorRequest;
import net.croz.nrich.excel.api.service.ExcelReportService;
import org.springframework.util.Assert;
import java.util.Arrays;
import java.util.Objects;

@RequiredArgsConstructor
public class DefaultExcelReportService implements ExcelReportService {

    private final ExcelReportGeneratorFactory excelReportGeneratorFactory;

    @Override
    public void createExcelReport(CreateExcelReportRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private CreateReportGeneratorRequest toCreateReportGeneratorRequest(CreateExcelReportRequest reportRequest) {
        return CreateReportGeneratorRequest.builder().columnDataFormatList(reportRequest.getColumnDataFormatList()).firstRowIndex(reportRequest.getFirstRowIndex()).outputStream(reportRequest.getOutputStream()).templatePath(reportRequest.getTemplatePath()).templateVariableList(reportRequest.getTemplateVariableList()).autoSizeColumns(reportRequest.isAutoSizeColumns()).build();
    }
}
