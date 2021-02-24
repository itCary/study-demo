package online.goudan.pojo;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author chenglongliu
 * @date 2020/12/21 14:38
 * @desc 请求数据的封装
 */
public class RequestPojo<T> {
    private String method;
    private T params;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "RequestPojo{" +
                "method='" + method + '\'' +
                ", params=" + params +
                '}';
    }
}
