package online.goudan.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘成龙
 * @date 2021/6/24 10:40
 * @desc M3U8
 */
public class M3U8 {
    private String basePath;
    private String localDirPath;
    private float totalTime;
    private float downloadedTime;
    private List<M3U8Ts> m3U8TsList = new ArrayList<>();
    private List<File> m3U8TsFileList = new ArrayList<>();
    private List<M3U8Ts> downloadedM3U8TsList = new ArrayList<>();

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getLocalDirPath() {
        return localDirPath;
    }

    public float getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(float totalTime) {
        this.totalTime = totalTime;
    }

    public void setLocalDirPath(String localDirPath) {
        this.localDirPath = localDirPath;
    }

    public List<M3U8Ts> getM3U8TsList() {
        return m3U8TsList;
    }

    public float getDownloadedTime() {
        return downloadedTime;
    }

    public void setDownloadedTime(float downloadedTime) {
        this.downloadedTime = downloadedTime;
    }

    public List<File> getM3U8TsFileList() {
        return m3U8TsFileList;
    }

    public List<M3U8Ts> getDownloadedM3U8TsList() {
        return downloadedM3U8TsList;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addM3U8Ts(M3U8Ts m3U8Ts) {
        m3U8TsList.add(m3U8Ts);
    }

    public void addM3U8TsFile(File file) {
        m3U8TsFileList.add(file);
    }

    public void addDownloadedM3U8Ts(M3U8Ts m3U8Ts) {
        downloadedM3U8TsList.add(m3U8Ts);
        downloadedTime += m3U8Ts.getSeconds();
    }

    public int getProcess() {
        return (int) (downloadedTime * 100 / totalTime);
    }
}
