package online.goudan.util;

import online.goudan.domain.VideoInfo;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

/**
 * @author 刘成龙
 * @date 2021/6/24 13:50
 * @desc DBManager
 */
public class DBManager {
    private static DBManager instance = new DBManager();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private DBManager() {

    }

    public static DBManager getInstance() {
        return instance;
    }

    public void saveBase64Name(VideoInfo videoInfo) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql:///novel", "root", "root")) {
            String sql = "insert into au(name,url,gmt_create,gmt_modified) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            String fn = Base64.getEncoder().encodeToString(videoInfo.getVideoName().getBytes(StandardCharsets.UTF_8));
            preparedStatement.setString(1, fn);
            preparedStatement.setString(2, videoInfo.getM3u8Url());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = format.format(new Date());
            preparedStatement.setString(3, dateStr);
            preparedStatement.setString(4, dateStr);
            final int i = preparedStatement.executeUpdate();
            System.out.println(i > 0);
        } catch (Exception e) {
            System.out.println(videoInfo.getVideoName() + ", 保存到数据库失败");
        }
    }
}
