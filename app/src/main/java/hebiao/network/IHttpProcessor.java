package hebiao.network;

import java.util.Map;

/**
 * Created by apple on 2018/3/21.
 */

public interface IHttpProcessor {
    void post(String url , Map<String ,Object> params, ICallBack callBack);
    void get(String url , Map<String ,Object> params, ICallBack callBack);
}
