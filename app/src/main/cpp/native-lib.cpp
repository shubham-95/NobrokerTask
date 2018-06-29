#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_example_nobrokertask_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
jstring
Java_com_example_nobrokertask_DI_NBTaskGeneratedModule_GetModule(JNIEnv *env, jobject instance,
                                                                 jint a) {
    if(a==1){
        return env->NewStringUTF("http://www.nobroker.in/");
    }
    else{
        return 0;
    }
}