package cn.plczl.mynote;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddContent extends Activity implements View.OnClickListener {

    private String val;

    private Button c_save,c_quxiao;
    private EditText ettext;
    private ImageView c_img;
    private VideoView c_video;

    private NotesDB notesDB;
    private SQLiteDatabase dbWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);
        val=getIntent().getStringExtra("flag");
        c_save = (Button) findViewById(R.id.c_save);
        c_quxiao = (Button) findViewById(R.id.c_quxiao);
        ettext = (EditText) findViewById(R.id.ettext);
        c_img = (ImageView) findViewById(R.id.c_img);
        c_video = (VideoView) findViewById(R.id.c_video);
        c_save.setOnClickListener(this);
        c_quxiao.setOnClickListener(this);

        notesDB=new NotesDB(this);
        dbWrite=notesDB.getWritableDatabase();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.c_save:
                addDB();
                finish();
                break;
            case R.id.c_quxiao:
                finish();
                break;
        }

    }

    public void addDB(){
        ContentValues contentValues=new ContentValues();
        contentValues.put(notesDB.CONTENT,ettext.getText().toString());
        contentValues.put(notesDB.TIME,getTime());
        dbWrite.insert(NotesDB.TABLE_NAME,null,contentValues);
    }

    private String getTime() {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        Date date=new Date();
        String datetime=format.format(date);
        return datetime;
    }
}
