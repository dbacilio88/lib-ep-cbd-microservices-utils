package pe.mil.microservices.utils.components.helpers;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

@Log4j2
@Component
public class CommonTranslatorHelper {

    public String toLocale(String messageCode) {
        Locale locale = LocaleContextHolder.getLocale();
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("i18n/messages", locale);
            return bundle.getString(messageCode);
        } catch (Exception e) {
            log.warn("Key [{}] not internationalized on Locale [{}]", messageCode, locale);
            return null;
        }
    }
}