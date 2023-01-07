package pe.mil.microservices.components.enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pe.mil.microservices.utils.components.enums.LanguageCode;

@SpringBootTest
public class LanguageCodeTest {

    private static final Logger logger = LogManager.getLogger(LanguageCodeTest.class);

    @Test
    @DisplayName(value = "test code find by code")
    void findLanguageByCodeTest() {
        //Given
        final LanguageCode actual = LanguageCode.findLanguageByCode("AR");
        logger.info("language code actual ({}) ", actual.getLanguageCode());
        //When
        final LanguageCode expected = LanguageCode.LANGUAGE_CODE_AR;
        logger.info("language code expected ({}) ", expected.getLanguageCode());
        //Then
        Assertions.assertEquals(expected.getLanguageCode(), actual.getLanguageCode());
    }
}
