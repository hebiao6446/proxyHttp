package hebiao.network;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by apple on 2018/3/21.
 */

public abstract class HttpCallBack<T> implements ICallBack {

    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Class<?> clazz = analysisClassInfo(this);
        T obj = (T) gson.fromJson(result,clazz);
        onSuccess(obj);

    }

    public abstract void onSuccess(T result);


    public static Class<?> analysisClassInfo(Object o){
        Type type = o.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)type).getActualTypeArguments();
        return  (Class<?>) params[0];
    }

    @Override
    public void onFailure(String e) {

    }
}
