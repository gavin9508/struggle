package com.struggle.base.io.test;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Author gavin
 * @Date 2022/8/5 17:59
 */
public class IoTest {

    private String filePath = "src/main/java/com/struggle/base/io/file/";

    @Test
    public void charTest() {
        char a = '\uffff';
        //超出 char 的承受范围的字符，无法表示。
        //char b = '\uD801\uDC37';
        System.out.println(a);
    }


    /**
     * 基本数据类型输入输出流
     *
     * @throws IOException
     */
    @Test
    public void dataTest() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filePath + "data.txt"));
        dataOutputStream.writeByte(10);
        dataOutputStream.writeShort(100);
        dataOutputStream.writeInt(1000);
        dataOutputStream.writeLong(10000L);
        dataOutputStream.writeFloat(12.34F);
        dataOutputStream.writeDouble(12.56);
        dataOutputStream.writeBoolean(true);
        dataOutputStream.writeChar('A');
        dataOutputStream.flush();
        dataOutputStream.close();
        System.out.println("基本数据类型写入完毕");

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath + "data.txt"));
        byte b = dataInputStream.readByte();
        short s = dataInputStream.readShort();
        int i = dataInputStream.readInt();
        long l = dataInputStream.readLong();
        float f = dataInputStream.readFloat();
        double d = dataInputStream.readDouble();
        boolean bo = dataInputStream.readBoolean();
        char ch = dataInputStream.readChar();
        dataInputStream.close();
        System.out.println("基本数据类型读取完毕");
        System.out.println("byte=" + b + " short=" + s + " int=" + i + " long=" + l + " float=" + f + " double=" + d + " boolean=" + bo + " char=" + ch);
    }

    /**
     * 数组流
     *
     * @throws IOException
     */
    @Test
    public void arrayTest() throws IOException {
        System.out.println("数组流也称内存流");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] info = "数组流输出测试".getBytes();
        byteArrayOutputStream.write(info, 0, info.length);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        String str = new String(bytes);
        System.out.println("输出数据：" + str);
        byteArrayOutputStream.close();

        InputStream is = new BufferedInputStream(new ByteArrayInputStream("数组流输入测试".getBytes()));
        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush))) {
            System.out.println(new String(flush, 0, len));
        }
        is.close();
    }

    /**
     * 对象序列化/反序列化
     */
    @Test
    public void objectTest() {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(
                new File(filePath + "object.txt")))) {
            output.writeUTF("对象序列化");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("对象序列化写入完成");

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(
                new File(filePath + "object.txt")))) {
            String str = input.readUTF();
            System.out.println("对象反序列化读取完成：" + str);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 文件流
     */
    @Test
    public void fileTest() throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath + "filePut.txt");
        fos.write("FileOutputStream 文件输出流".getBytes());
        fos.close();
        System.out.println("FileOutputStream 文件输出完成");

        byte[] bytes = new byte[32];
        String str = "";
        FileInputStream fis1 = new FileInputStream(filePath + "filePut.txt");
        while (fis1.read(bytes) != -1) {
            str += new String(bytes);
        }
        fis1.close();
        System.out.println("FileInputStream 文件读取完成：" + str);

        FileWriter fileWriter = new FileWriter(filePath + "filewrite.txt");
        char[] chars = "FileWriter 文件输出流".toCharArray();
        fileWriter.write(chars, 0, chars.length);
        fileWriter.close();
        System.out.println("FileWriter 文件读取完成");

        int b1 = 0;
        String str1 = "";
        FileReader fileReader = new FileReader(filePath + "filewrite.txt");
        while ((b1 = fileReader.read()) != -1) {
            str1 += (char) b1;
        }
        fileReader.close();
        System.out.println("FileReader 文件读取完成：" + str1);
    }

    /**
     * 转换
     *
     * @throws IOException
     */
    @Test
    public void transTest() throws IOException {
        File f = new File(filePath + "trans.txt");
        Writer out = new OutputStreamWriter(new FileOutputStream(f));
        out.write("字节流装换测试");
        out.close();
        System.out.println("字节输出流装换为字符流");

        InputStreamReader isr = new InputStreamReader(
                new FileInputStream(filePath + "trans.txt"));
        char[] cha = new char[1024];
        int len = isr.read(cha);
        System.out.println("字节输入流装换为字符流");
        System.out.println("读取到的内容：" + new String(cha, 0, len));
        isr.close();
    }

    /**
     * 打印流
     *
     * @throws IOException
     */
    @Test
    public void printTest() {
        StringWriter buffer = new StringWriter();
        try (PrintWriter pw = new PrintWriter(buffer)) {
            pw.println("打印流");
        }
        System.out.println(buffer.toString());
    }

    /**
     * 缓存流
     * 缓冲流将数据加载至缓冲区，一次性读取/写入多个字节
     *
     * @throws IOException
     */
    @Test
    public void BufferedTest() throws IOException {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(filePath +"book.pdf");
             FileOutputStream fos = new FileOutputStream(filePath +"book(1).pdf")) {
            int content;
            while ((content = fis.read()) != -1) {
                fos.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用普通流复制文件总耗时:" + (end - start) + " 毫秒");

        long start1 = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath +"book.pdf"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath +"book(1).pdf"))) {
            int content;
            while ((content = bis.read()) != -1) {
                bos.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end1 = System.currentTimeMillis();
        System.out.println("使用缓冲流复制文件总耗时:" + (end1 - start1) + " 毫秒");
    }

    /**
     * 管道流
     * 一个线程通过 PipedOutputStream 写入的数据可以被另外一个线程通过相关联的 PipedInputStream 读取出来。
     *
     * @throws IOException
     */
    @Test
    public void pipedTest() throws IOException {
        final PipedOutputStream pipedOutputStream = new PipedOutputStream();
        final PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String str = "管道流测试";
                    pipedOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
                    System.out.println("线程 A 写入：" + str);
                    pipedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程 B 读取...");
                    byte[] flush = new byte[1024];
                    int len = 0;
                    while (-1 != (len = pipedInputStream.read(flush))) {
                        System.out.println("读取到的内容：" + new String(flush, 0, len));
                    }
                    pipedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        thread1.start();
        thread2.start();
    }
}
