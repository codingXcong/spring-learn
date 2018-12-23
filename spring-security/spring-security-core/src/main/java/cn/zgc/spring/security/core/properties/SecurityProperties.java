package cn.zgc.spring.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my.security")
public class SecurityProperties {
    private BrowserProperties browserProperties = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browserProperties;
    }

    public void setBrowser(BrowserProperties browserProperties) {
        this.browserProperties = browserProperties;
    }
}
