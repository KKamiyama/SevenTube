package com.seventube.gioqulo.seventube;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.SparseArrayCompat;

import java.util.ArrayList;

/**
 * Created by Shirase on 2014/12/11.
 */
public class SevenTubePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<SparseArrayCompat<String>> mList;
    public SevenTubePagerAdapter(FragmentManager manager){
        super(manager);
        mList = new ArrayList<SparseArrayCompat<String>>();
    }
    @Override
    public Fragment getItem(int position) {
        // 対象ページの色情報を取得
        SparseArrayCompat<String> item = mList.get(position);
        // 情報を Bundle にする
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putString("id", item.get(0));
        bundle.putString("title", item.get(1));
        bundle.putString("video_url", item.get(2));

        // Fragment をつくり Bundle をセットする
        SevenTubeFragment frag = new SevenTubeFragment();
        frag.setArguments(bundle);

        return frag;
    }
    @Override
    public int getCount() {
        return mList.size();
    }
    /**
     * 情報を追加する.
     * @param item 色情報
     */
    public void add(SparseArrayCompat<String> item) {
        mList.add(item);
    }
    /**
     * 情報をリストで追加する.
     * @param list 色情報リスト
     */
    public void addAll(ArrayList<SparseArrayCompat<String>> list) {
        mList.addAll(list);
    }
}
