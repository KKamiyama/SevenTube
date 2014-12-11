package com.seventube.gioqulo.seventube;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.seventube.gioqulo.seventube.R;

/**
 * Created by Shirase on 2014/12/11.
 */
public class SevenTubeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // 情報を取得
        Bundle bundle = getArguments();
        int position = bundle.getInt("position");
        String id = bundle.getString("id");
        String title = bundle.getString("title");
        String video_url = bundle.getString("video_url");
        int start_msec = 0;

        // View をつくる
        View layout = inflater.inflate(R.layout.fragment_seven_tube, container, false);
        // layout.setBackgroundColor(Color.parseColor("red"));

        // タイトル
        TextView titleView = (TextView) layout.findViewById(R.id.title_view);
        titleView.setText(title);
        VideoView videoView = (VideoView) layout.findViewById(R.id.video_view);
        videoView.setVideoURI(Uri.parse(video_url));
        videoView.seekTo(start_msec);

        videoView.start();

        return layout;
    }
}
