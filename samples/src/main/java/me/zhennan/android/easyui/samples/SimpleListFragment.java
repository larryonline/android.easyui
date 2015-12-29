package me.zhennan.android.easyui.samples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.zhennan.android.easyui.library.list.EasyList;
import me.zhennan.android.easyui.library.list.EasyListViewDecorator;

/**
 * Created by zhangzhennan on 15/12/28.
 */
public class SimpleListFragment extends Fragment {


    private EasyList easyList = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        easyList = (EasyList)view.findViewById(R.id.easy_list);
        easyList.setDataProvider(new DP());
        easyList.setViewDecorator(new VD());
    }

    class DP implements EasyList.DataProvider{

        private List<String> source = null;
        protected List<String> getSource(){
            if(null == source){
                source = new ArrayList<>();
            }
            return source;
        }

        @Override
        public int getCount() {
            return getSource().size();
        }

        @Override
        public int getItemViewType(int position) {
            return 0;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_row, parent, false);
            return new SimpleHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            if(holder instanceof SimpleListFragment.SimpleHolder){
                ((SimpleHolder) holder).update(getSource().get(position));
            }
        }

        @Override
        public boolean isLastPage() {
            return getSource().size() > 100;
        }

        @Override
        public void onLoadFirstPage() {
            getSource().clear();
            for(int i = 0; i < 5; i++){
                getSource().add(""+i);
            }

            easyList.notifyDataSetChanged();
        }

        @Override
        public void onLoadNextPage() {
            int offset = getSource().size();
            for (int i = offset; i < offset + 5; i++){
                getSource().add(""+i);
            }

            easyList.notifyDataSetChanged();
        }
    }

    class VD extends EasyListViewDecorator{

        @Override
        protected int getEmptyViewResId() {
            return R.layout.empty_view;
        }

        @Override
        protected int getLastViewResId() {
            return R.layout.more_view;
        }

        @Override
        protected int getLoadMoreViewResId() {
            return R.layout.last_view;
        }
    }

    class SimpleHolder extends RecyclerView.ViewHolder{
        public SimpleHolder(View itemView) {
            super(itemView);
        }

        public void update(String data){
            TextView textView = (TextView)itemView.findViewById(R.id.text_view);
            textView.setText(data);
        }
    }
}
