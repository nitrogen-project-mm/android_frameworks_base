/*
 * Copyright (C) 2016 Nitrogen Project
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

package com.android.systemui.qs.tiles;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.UserHandle;
import android.view.View;

import com.android.systemui.R;
import com.android.systemui.qs.QSTile;
import com.android.systemui.qs.QSTileView;
import com.android.internal.logging.MetricsLogger;

public class ViperFxTile extends QSTile<QSTile.BooleanState> {

    private static final Intent APP_VIPER_FX_TILE = new Intent().setComponent(
        new ComponentName(
            "com.vipercn.viper4android_v2",
            "com.vipercn.viper4android_v2.activity.ViPER4Android"
        )
    );

    public ViperFxTile(Host host) {
        super(host);
    }

    @Override
    protected void handleDestroy() {
        super.handleDestroy();
    }
   @Override
    public int getMetricsCategory() {
        return MetricsLogger.QS_VIPER_FX;
    }


    @Override
    protected BooleanState newTileState() {
        return new BooleanState();
    }

    @Override
    public void setListening(boolean listening) {
    }

    @Override
    protected void handleClick() {
	mHost.startActivityDismissingKeyguard(APP_VIPER_FX_TILE);
    }

    @Override
    protected void handleUpdateState(BooleanState state, Object arg) {
        state.visible = true;
        state.label = mContext.getString(R.string.quick_settings_viper_fx_label);
        state.contentDescription = mContext.getString(R.string.accessibility_quick_settings_viper_fx);
        state.icon = ResourceIcon.get(R.drawable.ic_qs_viper_fx);
    }
}