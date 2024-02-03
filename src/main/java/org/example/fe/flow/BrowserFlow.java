package org.example.fe.flow;

import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.core.annotations.DefaultUrl;
import org.example.fe.pom.PageObject;

@Slf4j
public class BrowserFlow {

    public void open(String pageObjectName) {
        open(getPageObjectClass(pageObjectName));
    }

    public void open(Class<? extends PageObject> pageObject) {
        Selenide.open(getDefaultUrl(pageObject), pageObject);
        waitUntilPageIsLoaded(pageObject);
    }

    @SuppressWarnings("unchecked")
    public Class<PageObject> getPageObjectClass(String pageObjectName) {
        try {
            return (Class<PageObject>) Class.forName("org.example.fe.pom." +
                    pageObjectName.replaceAll("\\s", StringUtils.EMPTY));
        } catch (ClassNotFoundException e) {
            log.error("Unable to map page object name to a class!", e);
            throw new IllegalStateException("Unable to map page object name to a class!");
        }
    }

    protected String getDefaultUrl(Class<? extends PageObject> pageObject) {
        return pageObject.getAnnotation(DefaultUrl.class).url();
    }

    public void waitUntilPageIsLoaded(Class<? extends PageObject> pageObjectClass) {
        Selenide.page(pageObjectClass).pageIsLoaded();
    }

}
