package org.montanajr.auth.security.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.*;

@Component
public class SecureResourceFilterInvocationDefinitionSource implements FilterInvocationSecurityMetadataSource, InitializingBean {
    private Logger logger = LoggerFactory.getLogger(SecureResourceFilterInvocationDefinitionSource.class);

    private PathMatcher matcher;

    private static Map<String, Collection<ConfigAttribute>> map = new HashMap<>();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        logger.info("getAttributes");
        FilterInvocation filterInvocation = (FilterInvocation) o;
        String requestURI = filterInvocation.getRequestUrl();
        for (Iterator<Map.Entry<String, Collection<ConfigAttribute>>> iter = map.entrySet().iterator(); iter.hasNext(); ) {
            Map.Entry<String, Collection<ConfigAttribute>> entry = iter.next();
            String url = entry.getKey();

            if (matcher.match(url, requestURI)) {
                return map.get(requestURI);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("afterPropertiesSet");
        this.matcher = new AntPathMatcher();
        Collection<ConfigAttribute> atts = new ArrayList<>();
        ConfigAttribute c1 = new SecurityConfig("ROLE_USER");
        atts.add(c1);
        map.put("/api/permission/apiPermissions", atts);
    }
}

