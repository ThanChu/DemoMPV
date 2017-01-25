package com.datarepository.data;

/**
 * Created by ThangNTX on 12/1/2016.
 */

public interface DataCallback<T> {
    void onSuccess(T t);

    void onError();
}
