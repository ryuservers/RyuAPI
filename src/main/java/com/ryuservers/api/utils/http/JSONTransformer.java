package com.ryuservers.api.utils.http;

import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JSONTransformer implements ResponseTransformer {

    private Gson gson = Utils.getStandardGsonInstance();
    
    @Override
    public String render(Object o) throws Exception {
        return gson.toJson(o);
    }
    
}
