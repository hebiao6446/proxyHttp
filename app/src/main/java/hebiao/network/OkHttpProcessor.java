package hebiao.network;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by apple on 2018/3/21.
 */

public class OkHttpProcessor implements IHttpProcessor{

    @Override
    public void post(String url, Map<String, Object> params, final ICallBack iCallBack) {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder formBody = new FormBody.Builder();//创建表单请求体
//        //传递键值对参数
        for (String key: params.keySet()) {
            formBody.add(key,(String )params.get(key));
        }

        final Request request = new Request.Builder()//创建Request 对象。
                .url(url)
                .post(formBody.build())//传递请求体
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iCallBack.onFailure(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                iCallBack.onSuccess(response.toString());
            }
        });
    }

    @Override
    public void get(String url, Map<String, Object> params,final ICallBack iCallBack) {
        post(url,params,iCallBack);
    }
}
