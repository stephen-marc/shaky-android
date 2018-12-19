package com.linkedin.android.shaky;

import android.content.Context;

import github.nisrulz.easydeviceinfo.base.EasyAppMod;
import github.nisrulz.easydeviceinfo.base.EasyConfigMod;
import github.nisrulz.easydeviceinfo.base.EasyDeviceMod;
import github.nisrulz.easydeviceinfo.base.EasyDisplayMod;

public class DebugInfoUtil {

    public static String getDebugInfoString(Context ctx) {
        return ctx.getString(R.string.shaky_email_system_info_template, getEnvironmentalInfo(ctx), getAppInfo(ctx),
                             getDeviceInfo(ctx), getDisplayInfo(ctx));
    }


    private static String getEnvironmentalInfo(Context ctx) {
        EasyConfigMod configMod = new EasyConfigMod(ctx);
        String time = configMod.getFormattedTime();
        String date = configMod.getFormattedDate();
        return ctx.getString(R.string.shaky_email_env_template, date, time);
    }

    private static String getAppInfo(Context ctx) {
        EasyAppMod appMod = new EasyAppMod(ctx);
        String appVersion = ctx.getString(R.string.shaky_email_app_version_template, appMod.getAppVersion(),
                                          appMod.getAppVersionCode());
        return ctx.getString(R.string.shaky_email_app_template, appVersion);
    }

    private static String getDeviceInfo(Context ctx) {
        EasyDeviceMod deviceMod = new EasyDeviceMod(ctx);
        String androidVersion = deviceMod.getOSVersion();
        String manufacture = deviceMod.getManufacturer();
        String deviceModel = deviceMod.getModel();
        return ctx.getString(R.string.shaky_email_device_template, androidVersion, manufacture, deviceModel);
    }

    private static String getDisplayInfo(Context ctx) {
        EasyDisplayMod displayMod = new EasyDisplayMod(ctx);
        String displayRes = displayMod.getResolution();
        String displayDen = displayMod.getDensity();
        return ctx.getString(R.string.shaky_email_display_template, displayRes, displayDen);
    }
}
