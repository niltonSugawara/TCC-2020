package io.github.jn.clientes.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigDecimalConverter {
    //Conversor String -> BigDecimal  1.000,00 -> 1000.00 ->
    public BigDecimal converter (String value) {

        if (value == null) {
            return  null;
        }

        value = value.replace(".", "");
        return new BigDecimal(value);
    }

}
