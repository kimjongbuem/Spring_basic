package kr.co.fastcampus.cli.res;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class ResourceExample implements ResourceLoaderAware {
    private ResourceLoader resourceLoader; //@Autowired

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void print(){
        System.out.println(resourceLoader);
    }
}
