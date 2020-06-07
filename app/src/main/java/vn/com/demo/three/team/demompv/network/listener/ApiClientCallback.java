package vn.com.demo.three.team.demompv.network.listener;

public interface ApiClientCallback <T> {

    void onSuccess(T result);

    void onFailure(Throwable error);
}
