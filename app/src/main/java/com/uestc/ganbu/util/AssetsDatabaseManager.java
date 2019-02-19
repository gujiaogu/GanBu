package com.uestc.ganbu.util;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class AssetsDatabaseManager {
    private static final String DATABASE_PATH = "/data/data/%s/databases";
    private static final String DATABASE_FILE_NAME = "ganbu.db";

    private Context context;

    public AssetsDatabaseManager(Context context) {
        this.context = context;
    }

    public boolean isDatabaseExist() {
        return isDatabaseExist(DATABASE_FILE_NAME);
    }

    public boolean isDatabaseExist(String assetsSrc) {
        File dbFile = new File(getDatabaseFile(assetsSrc));
        return dbFile.exists();
    }

    public boolean copyAssetsToFilesystem() {
        return copyAssetsToFilesystem(DATABASE_FILE_NAME, getDatabaseFile(DATABASE_FILE_NAME));
    }

    public boolean copyAssetsToFilesystem(String assetsSrc, String des){
        if (!isCorrectFile(assetsSrc)) {
            return false;
        }

        boolean flag = true;
        InputStream istream = null;
        OutputStream ostream = null;
        try{
            AssetManager am = context.getAssets();
            istream = am.open(assetsSrc);
            ostream = new FileOutputStream(des);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = istream.read(buffer))>0){
                ostream.write(buffer, 0, length);
            }
        } catch(Exception e) {
            flag = false;
            e.printStackTrace();
        } finally {
            StreamUtil.close(istream);
            StreamUtil.close(ostream);
        }
        return flag;
    }

    private boolean isCorrectFile(String assetsSrc) {
        boolean flag = true;
        File dbFile = new File(getDatabaseFile(assetsSrc));
        if (dbFile.exists()) {
            dbFile.delete();
        }
        try {
            String fileDirPath = getDatabaseFilepath();
            File fileDir = new File(fileDirPath);
            if (!fileDir.exists()) {
                if(fileDir.mkdir()) {
                    if (!dbFile.createNewFile()) {
                        flag = false;
                    }
                } else {
                    flag = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    private String getDatabaseFilepath(){
        return String.format(DATABASE_PATH, context.getApplicationInfo().packageName);
    }

    private String getDatabaseFile(String dbFile){
        return getDatabaseFilepath() + File.separator + dbFile;
    }
}
