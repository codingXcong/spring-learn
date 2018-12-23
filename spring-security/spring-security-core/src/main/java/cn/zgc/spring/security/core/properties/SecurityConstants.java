package cn.zgc.spring.security.core.properties;

public interface SecurityConstants {
    /**
     * 当请求需要身份认证时，默认跳转的url
     *
     * @see SecurityController
     */
    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";

    /**
     * 默认登录页面
     *
     * @see SecurityController
     */
    public static final String DEFAULT_LOGIN_PAGE_URL = "/my-signIn.html";
}
