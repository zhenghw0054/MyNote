package cn.plczl.mynote;

import android.app.Activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button bt_text,bt_img,bt_video;
    private ListView lv_main;
    private static final String TAG = "MainActivity";

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        bt_text = (Button) findViewById(R.id.bt_text);
        bt_img = (Button) findViewById(R.id.bt_img);
        bt_video = (Button) findViewById(R.id.bt_video);
        lv_main = (ListView) findViewById(R.id.lv_main);

        bt_text.setOnClickListener(this);
        bt_img.setOnClickListener(this);
        bt_video.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        intent=new Intent(this,AddContent.class);

        switch ((v.getId())){
            case R.id.bt_text:
                intent.putExtra("flag",1);
                startActivity(intent);

                break;

            case R.id.bt_img:
                intent.putExtra("flag",2);
                startActivity(intent);
                break;

            case R.id.bt_video:
                intent.putExtra("flag",3);
                startActivity(intent);
                break;

        }
    }
}
