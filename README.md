# Cordova plugin to delete Webview cache

This is a WebView cache plugin for Cordova supporting Android. It allows to delete the cordova webview cache.

There is one method:

- CacheDelete.deleteCache(successCallback, errorCallback)

![Sample image](https://github.com/l08084/image-garage/blob/22409e0710cbedbcfc68f4de8d6ca30178050588/cordova-plugin-cache-delete.png)

## Installation

**Cordova**

```
cordova plugin add cordova-plugin-cache-delete
```

## Supported Platforms
- Android

## Code example

```typescript
import { Component } from '@angular/core';
import { Platform } from '@ionic/angular';

// Ambient Declarations
declare var CacheDelete: any;

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss'],
})
export class Tab1Page {
  constructor(private platform: Platform) {}

  public ngOnInit(): void {
    this.platform.ready().then(() => {
      if (this.platform.is('android')) {
        // delete cache
        CacheDelete.deleteCache(this.successCallback, this.errorCallback);
      }
    });
  }

  /**
   * success callback
   *
   * @private
   * @memberof Tab1Page
   */
  private successCallback(): void {
    console.log('success');
  }

  /**
   * error callback
   *
   * @private
   * @memberof Tab1Page
   */
  private errorCallback(): void {
    console.log('error');
  }
}
```

## License
Applying the Apache License, Version 2.0