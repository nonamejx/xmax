package com.nicestflower.xmax.di.component;

import com.nicestflower.xmax.di.PerActivity;
import com.nicestflower.xmax.di.module.ActivityModule;
import com.nicestflower.xmax.ui.main.category.CategoryFragment;
import com.nicestflower.xmax.ui.main.favorite.FavoriteFragment;
import com.nicestflower.xmax.ui.main.file.FileFragment;
import com.nicestflower.xmax.ui.main.MainActivity;
import com.nicestflower.xmax.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(SplashActivity activity);

    void inject(CategoryFragment fragment);

    void inject(FavoriteFragment fragment);

    void inject(FileFragment fragment);

}
