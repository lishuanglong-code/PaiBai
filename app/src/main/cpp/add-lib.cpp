#include <jni.h>
#include <string>

JNIEXPORT jstring JNICALL Java_com_pai_bai_util_TestUtils_add(JNIEnv *env, jobject /* this */) {
    std::string hello = "Test、jni！！！";
    jstring pJstring = env->NewStringUTF(hello.c_str());
    return pJstring;
}

