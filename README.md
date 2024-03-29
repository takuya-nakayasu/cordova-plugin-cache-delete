[![npm version](https://badge.fury.io/js/cordova-plugin-cache-delete.svg)](https://badge.fury.io/js/cordova-plugin-cache-delete)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Twitter](https://img.shields.io/twitter/follow/takuya_nakayasu?style=social)](https://twitter.com/takuya_nakayasu)

# Cordova plugin to delete Webview cache

This is a WebView cache plugin for Cordova supporting Android. It allows to delete the cordova webview cache.

There is one method:

- `CacheDelete.deleteCache()`

![Sample image](https://github.com/takuya-nakayasu/image-garage/blob/22409e0710cbedbcfc68f4de8d6ca30178050588/cordova-plugin-cache-delete.png)

## Installation

**Cordova**

```
cordova plugin add cordova-plugin-cache-delete
```

## Supported Platforms

- Android

## Methods

| **Method**                    | **Signature**                             | **Description**                                                                                           |
| ----------------------------- | ----------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| **CacheDelete.deleteCache()** | `CacheDelete.deleteCache(): Promise<any>` | Delete the cordova webview cache. This method returns a promise that fulfills when a call was successful. |

## Code example

To use in a TypeScript(Ionic v5/Angular) file:

```typescript
import { Component } from "@angular/core";
import { Platform } from "@ionic/angular";

// Ambient Declarations
declare var CacheDelete: any;

@Component({
  selector: "app-tab1",
  templateUrl: "tab1.page.html",
  styleUrls: ["tab1.page.scss"],
})
export class Tab1Page {
  constructor(private platform: Platform) {}

  public ngOnInit(): void {
    this.platform.ready().then(() => {
      if (this.platform.is("android")) {
        // delete cache
        CacheDelete.deleteCache()
          .then(() => console.log("delete cache success!!"))
          .catch((error) => console.error(error));
      }
    });
  }
}
```

## License

Applying the Apache License, Version 2.0
