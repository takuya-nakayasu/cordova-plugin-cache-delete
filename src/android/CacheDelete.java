/**
 * Copyright 2021 Takuya Nakayasu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.l08084.plugin;

import java.io.File;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

public class CacheDelete extends CordovaPlugin {
    private static final String TAG = "CacheDelete";
    private static final String DELETE_CACHE_MESSAGE = "Cordova CacheDelete.deleteCache() called.";
    private static final String ERROR_MESSAGE = "Failed to delete the cache, error";
    
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext)
            throws JSONException {
        Log.v(LOG_TAG, DELETE_CACHE_MESSAGE);
        if("deleteCache".equals(action)) {
            deleteCache(callbackContext);
            return true;
        }
        return false;
    }

    private void deleteCache(final CallbackContext callbackContext) {
        File cacheDir = cordova.getActivity().getApplicationContext().getCacheDir();
        clearCacheFolder(cacheDir, callbackContext);
    }

    private void clearCacheFolder (File dir, final CallbackContext callbackContext) {
        try {
            if (dir != null && dir.isDirectory()) {
                for (File child : dir.listFiles()) {
                    if (child.isDirectory()) {
                        clearCacheFolder(child, callbackContext);
                    }
                    child.delete();
                }
            }
            callbackContext.success();
        } catch (Exception ex) {
            Log.e(TAG, ERROR_MESSAGE, ex);
            callbackContext.error(ERROR_MESSAGE);
        }
    }

}