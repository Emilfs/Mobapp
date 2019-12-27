//
// Created by Emilfs on 12/27/2019.
//

#include <jni.h>

extern "C" JNIEXPORT jint JNICALL Java_com_example_test_ui_main_NativeConnection_div
        (JNIEnv * env, jobject obj, jint a, jint b) {
    return a/b;
}