package com.isil.Intercambio.Intercambio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class IntercambioController {
    @Autowired
    private RestTemplate restTemplate;

    private static String url = "https://api.exchangerate.host/convert?from={1}&to={2}";
    private static String url2 = "https://api.exchangerate.host/convert?amount={1}&from={2}&to={3}";


    @GetMapping
    @RequestMapping("/tipo-cambio")
    public List<Object> getConvert(@RequestParam String from, @RequestParam String to){
        ResponseIntercambio response = restTemplate.getForObject(url, ResponseIntercambio.class,from,to);
        return Arrays.asList(response);
    }

    @GetMapping
    @RequestMapping("/valor-cambio")
    public List<Object> getConvert(@RequestParam Float monto, @RequestParam String from, @RequestParam String to){
        IntercambioResultado response = restTemplate.getForObject(url2, IntercambioResultado.class,monto,from,to);
        return Arrays.asList(response);
    }
}
