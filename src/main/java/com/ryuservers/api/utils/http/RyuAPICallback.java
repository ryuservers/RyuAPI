/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryuservers.api.utils.http;

import java.util.Map;

public interface RyuAPICallback {
    public Object callWithParams(Map<String, String> params);
}
