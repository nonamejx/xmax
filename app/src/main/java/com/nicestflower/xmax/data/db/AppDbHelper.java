package com.nicestflower.xmax.data.db;

import com.nicestflower.xmax.R;
import com.nicestflower.xmax.data.network.model.CategoryResponse;
import com.nicestflower.xmax.data.network.model.DaoMaster;
import com.nicestflower.xmax.data.network.model.DaoSession;
import com.nicestflower.xmax.ui.lesson.model.Lesson;
import com.nicestflower.xmax.ui.main.category.model.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDbHelper implements DbHelper {

    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public Observable<List<Category>> getCategoryList() {
        return Observable.fromCallable(new Callable<List<Category>>() {
            @Override
            public List<Category> call() throws Exception {
                // todo: please remove this
                final List<Category> lstCategory = new ArrayList<>();
                lstCategory.add(new Category("Part 1", "Categorie Category", "Description book", R.drawable.thevigitarian));
                lstCategory.add(new Category("Part 2", "Categorie Category", "Description book", R.drawable.thewildrobot));
                lstCategory.add(new Category("Part 3", "Categorie Category", "Description book", R.drawable.mariasemples));
                lstCategory.add(new Category("Part 4", "Categorie Category", "Description book", R.drawable.themartian));
                return lstCategory;
            }
        });
    }

    @Override
    public Observable<List<Lesson>> getLessonList() {
        return Observable.fromCallable(new Callable<List<Lesson>>() {
            @Override
            public List<Lesson> call() throws Exception {
                // todo: please remove this
                final List<String> fileLinks = Arrays.asList(
                        "http://128.199.127.135:6970/files/audios/part-1/002_TOEIC_part1.mp3",
                        "http://128.199.127.135:6970/files/audios/part-1/002_TOEIC_part1.mp3",
                        "http://128.199.127.135:6970/files/audios/part-1/002_TOEIC_part1.mp3",
                        "http://128.199.127.135:6970/files/audios/part-1/002_TOEIC_part1.mp3",
                        "http://128.199.127.135:6970/files/audios/part-1/002_TOEIC_part1.mp3");

                final List<Lesson> lessons = new ArrayList<>();
                lessons.add(new Lesson("The Vegitarian", fileLinks, "56MB"));
                lessons.add(new Lesson("The Wild Robot", fileLinks, "57MB"));
                lessons.add(new Lesson("The Martian", fileLinks, "58MB"));
                lessons.add(new Lesson("Maria Semples", fileLinks, "59MB"));
                lessons.add(new Lesson("He Died with...", fileLinks, "60MB"));
                lessons.add(new Lesson("The Vegitarian", fileLinks, "61MB"));
                lessons.add(new Lesson("The Wild Robot", fileLinks, "62MB"));
                lessons.add(new Lesson("The Vegitarian", fileLinks, "56MB"));
                lessons.add(new Lesson("The Wild Robot", fileLinks, "57MB"));
                lessons.add(new Lesson("The Martian", fileLinks, "58MB"));
                lessons.add(new Lesson("Maria Semples", fileLinks, "59MB"));
                lessons.add(new Lesson("He Died with...", fileLinks, "60MB"));
                lessons.add(new Lesson("The Vegitarian", fileLinks, "61MB"));
                lessons.add(new Lesson("The Wild Robot", fileLinks, "62MB"));

                return lessons;
            }
        });
    }

    @Override
    public Observable<Boolean> saveCategoryList(final List<CategoryResponse> categories) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getCategoryResponseDao().insertInTx(categories);
                return true;
            }
        });
    }

    @Override
    public Observable<List<CategoryResponse>> getAllCategoriesFromDb() {
        return Observable.fromCallable(new Callable<List<CategoryResponse>>() {
            @Override
            public List<CategoryResponse> call() throws Exception {
                return mDaoSession.getCategoryResponseDao().loadAll();
            }
        });
    }
}
