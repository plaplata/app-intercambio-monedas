package com.isil.Intercambio.Intercambio;

import lombok.Data;

@Data
public class IntercambioResultado {
    private IntercambioResponseInfo query;
    private IntercambioInfo info;
    private String result;
}
