package cn.plczl.mynote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ProgressBar;

/**
 * 作者：郑华伟 on 2020-02-20
 * 电话：13982987219
 * QQ:1052456158
 * 作用：
 */
public class NotesDB extends SQLiteOpenHelper {

    public static final String TABLE_NAME="mynotes";//数据库表名
    public static final String ID="_id";//ID字段
    public static final String CONTENT="context";//内容字段
    public static final String PATH="path";//图片
    public static final String VIDEO="video";//视频
    public static final String TIME="time";//时间字段

    /**
     * 上下文，其中super中的notes为数据库名
     * @param context
     */
    public NotesDB(Context context){

        super(context,"notes",null,1);

    }

    /**
     * 新建一个数据库
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + CONTENT + " TEXT NOT NULL,"
                + PATH + " TEXT NOT NULL,"
                + VIDEO + " TEXT NOT NULL,"
                + TIME +" TEXT NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
