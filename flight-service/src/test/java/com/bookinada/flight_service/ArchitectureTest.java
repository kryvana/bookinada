package com.bookinada.flight_service;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(
        packages = "com.bookinada.flight_service",
        importOptions = ImportOption.DoNotIncludeTests.class)

public class ArchitectureTest {
    @ArchTest
    static final ArchRule controllersDoNotAccessPersistence =
            noClasses()
                    .that().resideInAPackage("..controller..")
                    .should().dependOnClassesThat()
                    .resideInAPackage("..persistence..");
}


