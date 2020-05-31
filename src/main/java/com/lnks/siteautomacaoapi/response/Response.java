package com.lnks.siteautomacaoapi.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Singular;

@Data
public class Response<T> {
    private T data;
    private List<String> errors = new ArrayList<String>();    
    
}