/*
 * Copyright (C) 2018 ViperOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.viper.venom.fragments;

import android.app.Fragment;
import android.content.Context;
import android.provider.SearchIndexableResource;
import com.android.internal.logging.nano.MetricsProto.MetricsEvent;
import com.android.settings.dashboard.DashboardFragment;
import com.android.settingslib.core.AbstractPreferenceController;
import com.android.settingslib.core.lifecycle.Lifecycle;
import com.android.settings.R;
import java.util.ArrayList;
import java.util.List;

import com.android.settings.display.AccentPickerPreferenceController;
import com.android.settings.display.SystemThemePreferenceController;
import com.android.settings.display.QsTileStylesPreferenceController;
import com.android.settings.display.SwitchStylesPreferenceController;
import com.android.settings.display.LsClockStylePreferenceController;

public class ThemesSettings extends DashboardFragment {
    private static final String TAG = "ThemesSettings";

    @Override
    public int getMetricsCategory() {
        return MetricsEvent.VENOM;
    }

    @Override
    protected String getLogTag() {
        return TAG;
    }

    @Override
    protected int getPreferenceScreenResId() {
        return R.xml.themes_settings;
    }

    @Override
    protected List<AbstractPreferenceController> createPreferenceControllers(Context context) {
        return buildPreferenceControllers(context, getLifecycle(), this);
    }

    private static List<AbstractPreferenceController> buildPreferenceControllers(
            Context context, Lifecycle lifecycle, Fragment fragment) {
        final List<AbstractPreferenceController> controllers = new ArrayList<>();
        controllers.add(new LsClockStylePreferenceController(context, lifecycle, fragment));
        controllers.add(new SwitchStylesPreferenceController(context, lifecycle, fragment));
        controllers.add(new QsTileStylesPreferenceController(context, lifecycle, fragment));
        controllers.add(new AccentPickerPreferenceController(context, lifecycle, fragment));
        controllers.add(new SystemThemePreferenceController(context, lifecycle, fragment));
        return controllers;
    }
}