package cn.edu.nju.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by lance on 2/12/16.
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, SessionAware, ServletResponseAware {

    public HttpServletRequest request;
    public HttpServletResponse response;
    public Map session;

    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = request;
    }

    public void setSession(Map<String, Object> map) {
        this.session = session;
    }

    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

}
