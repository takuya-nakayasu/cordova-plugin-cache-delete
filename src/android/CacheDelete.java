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

package jp.l08084;

import java.io.File;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

public class CacheDelete extends CordovaPlugin {
    private static final String TAG = "CacheDelete";
    private static final String ERROR_MESSAGE = "Failed to delete the cache, error";
    
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext)
            throws JSONException {
        if("deleteCache".equals(action)) {
            return deleteCache();
        }
        return false;
    }

    private void deleteCache() {
        File cacheDir = cordova.getActivity().getApplicationContext().getCacheDir();
        return clearCacheFolder(cacheDir);
    }

    /**
     * キャッシュファイルを削除する処理。
     *
     */
    private boolean clearCacheFolder (File dir) {
        try {
            if (dir != null && dir.isDirectory()) {
                for (File child : dir.listFiles()) {
                    if (child.isDirectory()) {
                        clearCacheFolder(child);
                    }
                    child.delete();
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            Log.e(TAG, ERROR_MESSAGE, ex);
            return false;
        }
    }

}