package com.example.assignmentmvp__rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.assignmentmvp__rxjava.models.NewsData;
import com.example.assignmentmvp__rxjava.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new MainActivityPresenter(this).getNewsData();
	}

	@Override
	public void updateNewsData(NewsData newsData) {
		newsData.getArticles();
	}

	@Override
	public void onPointerCaptureChanged(boolean hasCapture) {

	}
}