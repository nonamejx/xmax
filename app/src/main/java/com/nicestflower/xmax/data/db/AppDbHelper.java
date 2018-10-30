package com.nicestflower.xmax.data.db;

import com.nicestflower.xmax.R;
import com.nicestflower.xmax.ui.lesson.Lesson;
import com.nicestflower.xmax.ui.main.category.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDbHelper implements DbHelper {

    @Inject
    public AppDbHelper() {
    }

    @Override
    public Observable<List<Book>> getCategoryList() {
        return Observable.fromCallable(new Callable<List<Book>>() {
            @Override
            public List<Book> call() throws Exception {
                final List<Book> lstBook = new ArrayList<>();
                lstBook.add(new Book("The Vegitarian", "Categorie Book", "Description book", R.drawable.thevigitarian));
                lstBook.add(new Book("The Wild Robot", "Categorie Book", "Description book", R.drawable.thewildrobot));
                lstBook.add(new Book("Maria Semples", "Categorie Book", "Description book", R.drawable.mariasemples));
                lstBook.add(new Book("The Martian", "Categorie Book", "Description book", R.drawable.themartian));
                lstBook.add(new Book("He Died with...", "Categorie Book", "Description book", R.drawable.hediedwith));
                lstBook.add(new Book("The Vegitarian", "Categorie Book", "Description book", R.drawable.thevigitarian));
                lstBook.add(new Book("The Wild Robot", "Categorie Book", "Description book", R.drawable.thewildrobot));
                lstBook.add(new Book("Maria Semples", "Categorie Book", "Description book", R.drawable.mariasemples));
                lstBook.add(new Book("The Martian", "Categorie Book", "Description book", R.drawable.themartian));
                lstBook.add(new Book("He Died with...", "Categorie Book", "Description book", R.drawable.hediedwith));
                lstBook.add(new Book("The Vegitarian", "Categorie Book", "Description book", R.drawable.thevigitarian));
                lstBook.add(new Book("The Wild Robot", "Categorie Book", "Description book", R.drawable.thewildrobot));
                lstBook.add(new Book("Maria Semples", "Categorie Book", "Description book", R.drawable.mariasemples));
                lstBook.add(new Book("The Martian", "Categorie Book", "Description book", R.drawable.themartian));
                lstBook.add(new Book("He Died with...", "Categorie Book", "Description book", R.drawable.hediedwith));
                return lstBook;
            }
        });
    }

    @Override
    public Observable<List<Lesson>> getLessonList() {
        return Observable.fromCallable(new Callable<List<Lesson>>() {
            @Override
            public List<Lesson> call() throws Exception {
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
}
