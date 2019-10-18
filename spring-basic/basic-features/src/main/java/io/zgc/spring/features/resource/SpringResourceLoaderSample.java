package io.zgc.spring.features.resource;

import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStream;

public class SpringResourceLoaderSample {
    public static void main(String[] args) throws Exception{
        SpringResourceLoaderSample sample = new SpringResourceLoaderSample();
        sample.testResourceLoad();
        sample.testPathMatchingResourcePatternResolver();
    }

    private void testPathMatchingResourcePatternResolver() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:META-INF/spring.handlers");
        printStream(resources[0]);
        Assert.isTrue(resources.length == 1,"长度不为1");

        Resource[] resources1 = resolver.getResources("classpath:applicationContext*.xml");
        System.out.println(resources1.length);
        Assert.isTrue(resources1.length == 1,"长度不为1");

        Resource[] resources2 = resolver.getResources("classpath*:META-INF/spring.handlers");
        System.out.println(resources2.length);
        Assert.isTrue(resources2.length > 1,"长度不大于1");

        Resource[] resources3 = resolver.getResources("classpath*:META-INF/*.handlers");
        System.out.println(resources3.length);
        Assert.isTrue(resources3.length > 1,"长度不大于1");
    }

    private void printStream(Resource resource) {
        try (InputStream is = resource.getInputStream();){
            byte[] msgBytes = new byte[is.available()];
            is.read(msgBytes);
            System.out.println(new String(msgBytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void testResourceLoad(){
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:io/zgc/spring/features/resource/resourceDemo.properties");
        Assert.isInstanceOf(ClassPathResource.class,resource);

        Resource resource1 = resourceLoader.getResource("file:io/zgc/spring/features/resource/resourceDemo.properties");
        Assert.isInstanceOf(UrlResource.class, resource1);

        Resource resource2 = resourceLoader.getResource("io/zgc/spring/features/resource/resourceDemo.properties");
        Assert.isInstanceOf(ClassPathResource.class,resource2);
    }
}
