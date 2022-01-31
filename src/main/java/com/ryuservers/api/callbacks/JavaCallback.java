package com.ryuservers.api.callbacks;

import com.google.gson.Gson;
import com.ryuservers.api.utils.http.RyuAPICallback;
import com.ryuservers.api.utils.http.Utils;

import java.io.Serializable;
import java.util.Map;

public abstract class JavaCallback implements RyuAPICallback, Serializable {
    private Gson gsonInstance;

    public Gson getGsonInstance() {
        if(gsonInstance == null)
            gsonInstance = Utils.getStandardGsonInstance();

        return gsonInstance;
    }
}
