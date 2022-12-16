package com.onscreen.wifiutils;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.onscreen.wifiutils.wifiConnect.ConnectionScanResultsListener;
import com.onscreen.wifiutils.wifiConnect.ConnectionSuccessListener;
import com.onscreen.wifiutils.wifiDisconnect.DisconnectionSuccessListener;
import com.onscreen.wifiutils.wifiRemove.RemoveSuccessListener;
import com.onscreen.wifiutils.wifiScan.ScanResultsListener;
import com.onscreen.wifiutils.wifiState.WifiStateListener;
import com.onscreen.wifiutils.wifiWps.ConnectionWpsListener;

public interface WifiConnectorBuilder {
    void start();

    interface WifiUtilsBuilder {
        void enableWifi(WifiStateListener wifiStateListener);

        void enableWifi();

        void disableWifi();

        @NonNull
        WifiConnectorBuilder scanWifi(@Nullable ScanResultsListener scanResultsListener);

        @NonNull
        WifiSuccessListener connectWith(@NonNull String ssid);

        @NonNull
        WifiSuccessListener connectWith(@NonNull String ssid, @NonNull String password);

        @NonNull
        WifiSuccessListener connectWith(@NonNull String ssid, @NonNull String bssid, @NonNull String password);

        WifiSuccessListener connectWith(@NonNull String ssid, @NonNull String password, @NonNull TypeEnum type);

        @NonNull
        WifiUtilsBuilder patternMatch();

        @Deprecated
        void disconnectFrom(@NonNull String ssid, @NonNull DisconnectionSuccessListener disconnectionSuccessListener);

        void disconnect(@NonNull DisconnectionSuccessListener disconnectionSuccessListener);

        void remove(@NonNull String ssid, @NonNull RemoveSuccessListener removeSuccessListener);

        @NonNull
        WifiSuccessListener connectWithScanResult(@NonNull String password, @Nullable ConnectionScanResultsListener connectionScanResultsListener);

        @NonNull
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        WifiWpsSuccessListener connectWithWps(@NonNull String bssid, @NonNull String password);

        void cancelAutoConnect();

        boolean isWifiConnected(@NonNull String ssid);
        boolean isWifiConnected();
    }

    interface WifiSuccessListener {
        @NonNull
        WifiSuccessListener setTimeout(long timeOutMillis);

        @NonNull
        WifiConnectorBuilder onConnectionResult(@Nullable ConnectionSuccessListener successListener);
    }

    interface WifiWpsSuccessListener {
        @NonNull
        WifiWpsSuccessListener setWpsTimeout(long timeOutMillis);

        @NonNull
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        WifiConnectorBuilder onConnectionWpsResult(@Nullable ConnectionWpsListener successListener);
    }
}
