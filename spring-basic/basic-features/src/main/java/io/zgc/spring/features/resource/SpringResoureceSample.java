package io.zgc.spring.features.resource;

import org.springframework.core.io.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class SpringResoureceSample {
    public static void main(String[] args) throws IOException {
        Resource resource = new ClassPathResource("applicationContext.xml");
        InputStream in = resource.getInputStream();

        SpringResoureceSample sample = new SpringResoureceSample();
        sample.testByteArrayResource();
        sample.testInputStreamResource();
        sample.testFileSystemResource();
        sample.testClassPathResource();
    }

    public void testByteArrayResource(){
        String msg = "byte array resource";
        Resource resource = new ByteArrayResource(msg.getBytes());
        printStream(resource);
    }

    private void testInputStreamResource(){
        String msg = "inputstream resource";
        ByteArrayInputStream bais = new ByteArrayInputStream(msg.getBytes());
        Resource resource = new InputStreamResource(bais);
        printStream(resource);
    }

    private void testFileSystemResource() throws IOException {
        File file = new File("src/main/resources/fileSystemResource.txt");
        Resource resource = new FileSystemResource(file);
        if (resource.exists()) {
            printStream(resource);
        }
    }

    private void testClassPathResource(){
        Resource resource = new ClassPathResource("io/zgc/spring/features/resource/resourceDemo.properties");
        if (resource.exists()) {
            printStream(resource);
        }
    }

    private void testClassPathResourceFromJar(){

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

}
