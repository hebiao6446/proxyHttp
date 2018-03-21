package hebiao.network;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 2018/3/21.
 */

public class HttpHelper implements IHttpProcessor{

    private static IHttpProcessor mIHttpProcessor = null;

    private static HttpHelper httpHelper;

    private Map<String ,Object> params;


    private HttpHelper(){
        params = new HashMap<>();
    }

    public static HttpHelper getInstance(){
        synchronized (HttpHelper.class){
            if (httpHelper == null){
                httpHelper = new HttpHelper();
            }
        }


        return httpHelper;
    }


    public static void init(IHttpProcessor iHttpProcessor){
        mIHttpProcessor = iHttpProcessor;
    }


    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {
        mIHttpProcessor.post(url,params,callBack);
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallBack callBack) {
        mIHttpProcessor.get(url,params,callBack);
    }
}
