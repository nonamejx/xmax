package com.nicestflower.xmax.di.component;

import android.app.Application;
import android.content.Context;

import com.nicestflower.xmax.XMaxApp;
import com.nicestflower.xmax.data.DataManager;
import com.nicestflower.xmax.di.ApplicationContext;
import com.nicestflower.xmax.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(XMaxApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}