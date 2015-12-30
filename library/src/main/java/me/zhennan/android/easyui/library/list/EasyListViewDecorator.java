package me.zhennan.android.easyui.library.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhangzhennan on 15/12/29.
 */
public abstract class EasyListViewDecorator implements EasyList.ViewDecorator {

    @Override
    public boolean applyItemGapForTop() {
        return true;
    }

    @Override
    public int getHorizontalGapPixelSize() {
        return 0;
    }

    @Override
    public int getVerticalGapPixelSize() {
        return 0;
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return null;
    }

    @Override
    public View onCreateEmptyView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(getEmptyViewResId(), parent, false);
    }

    @Override
    public View onCreateLoadMoreView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(getLoadMoreViewResId(), parent, false);
    }

    @Override
    public View onCreateLastView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(getLastViewResId(), parent, false);
    }

    abstract protected int getEmptyViewResId();
    abstract protected int getLastViewResId();
    abstract protected int getLoadMoreViewResId();

}
