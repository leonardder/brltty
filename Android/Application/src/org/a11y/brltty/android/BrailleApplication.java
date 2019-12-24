/*
 * BRLTTY - A background process providing access to the console screen (when in
 *          text mode) for a blind person using a refreshable braille display.
 *
 * Copyright (C) 1995-2019 by The BRLTTY Developers.
 *
 * BRLTTY comes with ABSOLUTELY NO WARRANTY.
 *
 * This is free software, placed under the terms of the
 * GNU Lesser General Public License, as published by the Free Software
 * Foundation; either version 2.1 of the License, or (at your option) any
 * later version. Please see the file LICENSE-LGPL for details.
 *
 * Web Page: http://brltty.app/
 *
 * This software is maintained by Dave Mielke <dave@mielke.cc>.
 */

package org.a11y.brltty.android;

import android.util.Log;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class BrailleApplication extends Application {
  private static final String LOG_TAG = BrailleApplication.class.getName();

  private static BrailleApplication applicationObject = null;
  private static Handler applicationHandler = null;

  @Override
  public void onCreate () {
    super.onCreate();
    applicationObject = this;
    applicationHandler = new Handler();
  }

  public static BrailleApplication get () {
    return applicationObject;
  }

  public static void post (Runnable runnable) {
    applicationHandler.post(runnable);
  }
}
