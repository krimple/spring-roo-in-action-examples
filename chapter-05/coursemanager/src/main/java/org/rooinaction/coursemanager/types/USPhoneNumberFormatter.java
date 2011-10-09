package org.rooinaction.coursemanager.types;

import org.apache.commons.lang.StringUtils;
import org.springframework.binding.convert.ConversionException;
import org.springframework.format.Formatter;
import sun.misc.Regexp;

import java.text.ParseException;
import java.util.Locale;

public class USPhoneNumberFormatter implements Formatter<USPhoneNumber> {

    @Override
    public USPhoneNumber parse(String text, Locale locale) throws ParseException {
        String sanitized = text.replaceAll("\\D", "");
        if (!StringUtils.isNumeric(sanitized) ||
                sanitized.length() != 10)
            throw new ParseException("not a valid US phone number", 0);
        String areaCode = sanitized.substring(0, 3);
        String exchange = sanitized.substring(3, 3);
        String number = sanitized.substring(6, 4);

        return new USPhoneNumber(areaCode, exchange, number);
    }

    @Override
    public String print(USPhoneNumber object, Locale locale) {
        return new StringBuffer()
                .append('(')
                .append(object.getAreaCode())
                .append(')')
                .append(object.getExchange())
                .append('-')
                .append(object.getNumber())
                .toString();
    }
}
