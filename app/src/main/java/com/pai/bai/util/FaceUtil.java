package com.pai.bai.util;

import android.graphics.Bitmap;

import org.opencv.android.Utils;
import org.opencv.core.Mat;


public class FaceUtil {

    public static void whitening(Bitmap bitmap) {
        // 双边模糊系数
        int bilateralFilterVal = 30;

        Mat rawMat = new Mat();
        Utils.bitmapToMat(bitmap, rawMat);


//        for (int y = 0; y < rawMat.rows(); y++) {
//            for (int x = 0; x < rawMat.cols(); x++) {
//                for (int c = 0; c < 3; c++) {
//                    rawMat.at
//
//
//                    matSelfPhoto.at<Vec3b> (y, x)[c] =saturate_cast<uchar>
//                    (alpha * (matSelfPhoto.at < Vec3b > (y, x)[c])+beta);
//                }
//            }
//        }

    }
}
