// Generated code from Butter Knife. Do not modify!
package com.codonomics.spring_android_demo;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.codonomics.spring_android_demo.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230721, "field 'jokeButton' and method 'getJokeFromInternet'");
    target.jokeButton = finder.castView(view, 2131230721, "field 'jokeButton'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.getJokeFromInternet();
        }
      });
    view = finder.findRequiredView(source, 2131230720, "field 'jokeTextView'");
    target.jokeTextView = finder.castView(view, 2131230720, "field 'jokeTextView'");
  }

  @Override public void unbind(T target) {
    target.jokeButton = null;
    target.jokeTextView = null;
  }
}
