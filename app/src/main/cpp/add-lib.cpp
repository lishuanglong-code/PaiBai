#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_pai_bai_util_TestUtils_stringff(JNIEnv *env, jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

