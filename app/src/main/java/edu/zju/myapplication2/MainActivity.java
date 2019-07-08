package edu.zju.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.media.SoundPool;
public class MainActivity extends AppCompatActivity {

    Switch mSwitch;
    private SoundPool soundPool;
    private boolean isRelease = true;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView = findViewById(R.id.imageView);
        mSwitch = (Switch)findViewById(R.id.onnn);
        mSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (isChecked) {
                    imageView.setImageResource(R.drawable.xiangcai1);
                } else {
                    imageView.setImageResource(R.drawable.jinguanzhang1);
                }
            }
        });

    }
    public void myClick(View view) {
        if(isRelease) {
            player=MediaPlayer.create(this,R.raw.guichuxiao);
            isRelease=false;
        }
        if (player.isPlaying()) {
            player.stop();
            isRelease=true;
        }
        else {
            player.start();
        }
        Toast.makeText(this,"Button响应",Toast.LENGTH_LONG).show();
    }



}
