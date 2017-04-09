package com.example.joy.myapplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yujoi on 2017/04/09.
 */

@Module
public class HelloModule {
    @Provides
    Hello provideHelloImpl() {
        return new HelloImpl();
    }


}
