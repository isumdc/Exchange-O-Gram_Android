package com.androiddev.josephelliott.exchange_o_gram;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Joseph Elliott on 1/24/2016.
 */
public class CameraActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_camera);

        // Camera2 api is garbage and infinitely more confusing than necessary.

        //CameraManager -> Select Camera -> Create CameraDevice

        //CameraDevice -> Create CaptureRequest -> Create CameraCaptureSession

        //CaptureRequest, CaptureRequest.CameraBuilder -> Link Surface for Viewing -> Make CaptureRequest

        //CameraCaptureSession -> Capture Camare Image and put the result on the Surface registered in CaptureRequest.
=======
        setContentView(R.layout.activity_main);
>>>>>>> origin/master

    }

}
