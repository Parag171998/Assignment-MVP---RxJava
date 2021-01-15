package com.example.assignmentmvp__rxjava.presenter;

import android.annotation.SuppressLint;
import android.view.View;

import com.example.assignmentmvp__rxjava.models.NewsData;
import com.example.assignmentmvp__rxjava.network.NewsApiClient;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenter {

	private View view;

	public MainActivityPresenter(View view){
		this.view = view;
	}

	@SuppressLint("CheckResult")
	public void getNewsData(){

		NewsApiClient.getInstance().getApi().getHeadlines("us", NewsApiClient.NEWS_API_KEY)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.subscribeWith(new Observer<NewsData>() {
					@Override
					public void onSubscribe(@NonNull Disposable d) {
					}

					@Override
					public void onNext(@NonNull NewsData newsData) {
						view.updateNewsData(newsData);
					}

					@Override
					public void onError(@NonNull Throwable e) {

					}

					@Override
					public void onComplete() {

					}
				});
	}

	public interface View{
		void updateNewsData(NewsData newsData);
	}

}
