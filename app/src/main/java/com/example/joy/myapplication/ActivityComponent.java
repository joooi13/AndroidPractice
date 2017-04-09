package com.example.joy.myapplication;

import dagger.Component;

/**
 * Created by yujoi on 2017/04/09.
 */

@Component(modules = HelloModule.class)
public interface ActivityComponent  {
    void inject(MainActivity activity);
}

