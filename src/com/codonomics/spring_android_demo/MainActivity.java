package com.codonomics.spring_android_demo;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {
	private static final String URL = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";

	@Bind(R.id.jokeTextView) TextView jokeTextView;
	@Bind(R.id.jokeButton) Button jokeButton;

	private RestTemplate restTemplate = new RestTemplate(); //1. Init RestTemplate

	private AsyncTask<String, Void, String> asyncTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		restTemplate.getMessageConverters().add(new GsonHttpMessageConverter()); //2. Add Gson convertor to RestTemple Messageconverter
	}

	@OnClick(R.id.jokeButton)
	void getJokeFromInternet() {
		asyncTask = new AsyncJokeTask().execute();
	}

	private class AsyncJokeTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... params) {
			Log.d("AsyncJokeTask", "1 doInBackground(..)");
			final ICNDBJoke joke = restTemplate.getForObject(URL, ICNDBJoke.class); //3. Hit the URL and pass Java class type to which the result is to be converted
			Log.d("AsyncJokeTask", "2 doInBackground(..)");
			return joke.joke();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			Log.d("AsyncJokeTask", "onPostExecute(..)");
			jokeTextView.setText(result);
		}
	}

}
