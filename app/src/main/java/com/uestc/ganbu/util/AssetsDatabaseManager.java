package com.uestc.ganbu.util;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class AssetsDatabaseManager {
    private static final String DATABASE_PATH = "/data/data/%s/database";

    private Context context;

    public AssetsDatabaseManager(Context context) {
        this.context = context;
    }

    private boolean isDatabaseExist(String assetsSrc) {
        File dbFile = new File(getDatabaseFile(assetsSrc));
        return dbFile.exists();
    }

    private String getDatabaseFilepath(){
        return String.format(DATABASE_PATH, context.getApplicationInfo().packageName);
    }

    private String getDatabaseFile(String dbfile){
        return getDatabaseFilepath() + File.separator + dbfile;
    }

    private boolean copyAssetsToFilesystem(String assetsSrc, String des){
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
            am.close();
        } catch(Exception e) {
            flag = false;
            e.printStackTrace();
        } finally {
            StreamUtil.close(istream);
            StreamUtil.close(ostream);
        }
        return flag;
    }
}
