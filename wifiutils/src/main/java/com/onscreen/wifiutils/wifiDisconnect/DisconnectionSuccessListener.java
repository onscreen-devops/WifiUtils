package com.onscreen.wifiutils.wifiDisconnect;

import androidx.annotation.NonNull;

public interface DisconnectionSuccessListener {
    void success();

    void failed(@NonNull DisconnectionErrorCode errorCode);
}