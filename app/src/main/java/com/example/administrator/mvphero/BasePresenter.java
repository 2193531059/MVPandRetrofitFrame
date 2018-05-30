package com.example.administrator.mvphero;

import java.lang.ref.WeakReference;

public class BasePresenter<V> {
    private WeakReference<V> viewReference;

    public void attachView(V view){
        viewReference = new WeakReference<V>(view);
    }

    public void detachView(){
        if (viewReference != null) {
            viewReference.clear();
            viewReference = null;
        }
    }

    public V getView(){
        return viewReference.get();
    }
}
