package online.goudan.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenglongliu
 * @date 2021/4/9 22:24
 * @desc 自定义log输出
 */
public class LogUtil {
    private String className;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    private static FileOutputStream outputStream;
    private FileOutputStream logOut;

    private LogUtil(String name) {
        className = name;
        logOut = outputStream;
    }

    public static LogUtil getInstance(Class clazz) {
        if (outputStream == null) {
            File dirfile = new File(System.getProperty("user.dir"));
            File outFile = new File(dirfile, "douyu.log");
            try {
                if (!outFile.exists()) {
                    outFile.createNewFile();

                }
                outputStream = new FileOutputStream(outFile,true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new LogUtil(clazz.getName());
    }

    public void error(String msg) {
        print("ERROR", msg);
    }

    public void info(String msg) {
        print("INFO", msg);
    }

    private void print(String level, String msg) {
        try {
            logOut.write(String.format("[%s] [%s] %s: %s%n", level, simpleDateFormat.format(new Date()), className, msg).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
