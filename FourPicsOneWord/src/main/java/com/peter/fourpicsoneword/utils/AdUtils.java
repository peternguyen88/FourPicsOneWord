package com.peter.fourpicsoneword.utils;

import com.google.android.gms.ads.AdRequest;

/**
 * Created by Peter on 6/26/2014.
 */
public class AdUtils {
    /** Gets a string error reason from an error code. */
    public static String getErrorReason(int errorCode) {
        String errorReason = "";
        switch(errorCode) {
            case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                errorReason = "Internal error";
                break;
            case AdRequest.ERROR_CODE_INVALID_REQUEST:
                errorReason = "Invalid request";
                break;
            case AdRequest.ERROR_CODE_NETWORK_ERROR:
                errorReason = "Network Error";
                break;
            case AdRequest.ERROR_CODE_NO_FILL:
                errorReason = "No fill";
                break;
        }
        return errorReason;
    }
}
