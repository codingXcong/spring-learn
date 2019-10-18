package io.zgc.spring.features.resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDKResourceReadDemo {
    public static void main(String[] args) {
        JDKResourceReadDemo resourceRead = new JDKResourceReadDemo();
        resourceRead.readFromRelativePathByClass();
        resourceRead.readFromAbsolutePathByClass();
        // classloader加载资源以classpath为相对路径，且不能以"/"开头
        resourceRead.readByClassLoader();
        resourceRead.readFromJar();
    }

    private void readFromRelativePathByClass(){
        try (InputStream is = this.getClass().getResourceAsStream("resourceDemo.properties");) {
            Properties prop = new Properties();
            prop.load(is);
            // output : package
            System.out.println(prop.getProperty("key"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromAbsolutePathByClass(){
        try (InputStream is = this.getClass().getResourceAsStream("/resourceDemo.properties");) {
            Properties prop = new Properties();
            prop.load(is);
            // output : resources
            System.out.println(prop.getProperty("key"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream is = this.getClass().getResourceAsStream("/io/zgc/spring/features/resource/resourceDemo.properties");) {
            Properties prop = new Properties();
            prop.load(is);
            // output : package
            System.out.println(prop.getProperty("key"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readByClassLoader() {
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("resourceDemo.properties");) {
            Properties prop = new Properties();
            prop.load(is);
            // output : resources
            System.out.println(prop.getProperty("key"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("io/zgc/spring/features/resource/resourceDemo.properties");) {
            Properties prop = new Properties();
            prop.load(is);
            // output : package
            System.out.println(prop.getProperty("key"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromJar() {
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("META-INF/spring.handlers");) {
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = is.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            outSteam.close();
            is.close();
            System.out.println(new String(outSteam.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
