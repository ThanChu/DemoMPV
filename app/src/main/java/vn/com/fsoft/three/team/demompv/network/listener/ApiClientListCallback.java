package vn.com.fsoft.three.team.demompv.network.listener;

import java.util.List;

public interface ApiClientListCallback<T> {

    void onSuccess(List<T> results);

    void onFailure(Throwable error);
}
