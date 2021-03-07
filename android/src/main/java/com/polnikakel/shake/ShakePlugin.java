package com.polnikakel.shake;

import android.content.Context;
import android.hardware.SensorManager;
import androidx.activity.result.ActivityResult;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.ActivityCallback;
import com.getcapacitor.annotation.CapacitorPlugin;
import java.util.logging.Level;
import java.util.logging.Logger;

@CapacitorPlugin(name = "Shake")
public class ShakePlugin extends Plugin implements Shake.Listener {

    private SensorManager mSensorManager;
    private Shake shake;

    public void load() {
        if (this.mSensorManager == null) {
            this.mSensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        }

        this.shake = new Shake(this);
        this.shake.setSensitivity(10);
    }

    //    private SensorManager mSensorManager;

    //    private Shake implementation = new Shake(() -> {
    //        Logger.getAnonymousLogger().log(Level.ALL, "Data");
    //    });
    //    @PluginMethod
    //    public ShakePlugin(Context context) {
    //    }

    @Override
    public void hearShake() {
        Logger.getLogger("Test").log(Level.ALL, "Test");

        notifyListeners("shake", new JSObject());
    }

    @PluginMethod
    public void start(PluginCall call) {
        this.shake.start(this.mSensorManager);
        call.resolve();
    }

    @PluginMethod
    public void stop(PluginCall call) {
        this.shake.stop();
        call.resolve();
    }
}
