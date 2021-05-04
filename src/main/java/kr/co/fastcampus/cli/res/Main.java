package kr.co.fastcampus.cli.res;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*특정파일 읽을때...

        String path = "C:\\Users\\0992m\\Desktop\\spring_basic\\src\\main\\resources\\dao.xml";
        File file = new File(path);
        InputStream is = new FileInputStream(file);
        byte[] bytes = is.readAllBytes();
        System.out.println(new String(bytes));
        */

        /*클래스패스
        InputStream is = Main.class.getClassLoader().getResourceAsStream("dao.xml");
        byte[] bytes = is.readAllBytes();
        System.out.println(new String(bytes));
        */

        /*클래스패스 리소스 인터페이스
        ClassPathResource resource = new ClassPathResource("dao.xml");
        byte[] bytes = resource.getInputStream().readAllBytes();
        System.out.println(new String(bytes));
        */

        /* FileSystemResouce는 절대경로를 넣어주는것은 비슷하나 file과같이 프로토콜을 넣어주진 않는점이 차이이다.
        UrlResource resource = new UrlResource("file:C:\\\\Users\\\\0992m\\\\Desktop\\\\spring_basic\\\\src\\\\main\\\\resources\\\\dao.xml");
        byte[] bytes = resource.getInputStream().readAllBytes();
        System.out.println(resource.exists());
        */

        /*ResourceLoader Interface
        * prefix : classpath, file , http , none
        * file:절대경로
        *
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        System.out.println(new String(context.getResource("classpath:dao.xml").getInputStream().readAllBytes()));
        */

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ResourceExample.class);
        context.refresh();
        context.getBean(ResourceExample.class).print();
        context.close();
    }
}
