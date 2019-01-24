package com.lonelypluto.testsectionedrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.lonelypluto.testsectionedrecyclerview.adapter.MyAdapter;
import com.lonelypluto.testsectionedrecyclerview.adapter.SimpleHeaderAdapter;
import com.lonelypluto.testsectionedrecyclerview.bean.MyBean;
import com.lonelypluto.testsectionedrecyclerview.widget.SpaceGridItemDecoration;
import com.truizlop.sectionedrecyclerview.SectionedSpanSizeLookup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_load;

    private RecyclerView rv;
    private MyAdapter adapter;
//    private SimpleHeaderAdapter adapter;
    private List<MyBean> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btn_load  =(Button)findViewById(R.id.main_btn_load);
        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < 3; i++) {
                    MyBean myBean = new MyBean();
                    myBean.setHeader("header " + i);
                    myBean.setFooter("footer " + i);
                    for (int j = 0; j < 6; j++) {
                        MyBean.ItemBean itemBean = new MyBean.ItemBean();
                        itemBean.setContent("content " + j);
                        myBean.getList().add(itemBean);
                    }
                    list.add(myBean);
                }
                adapter.notifyDataSetChanged();
            }
        });

        rv = (RecyclerView)findViewById(R.id.main_rv);
        adapter = new MyAdapter(this, list);
//        adapter = new SimpleHeaderAdapter(this, list);

//        rv.addItemDecoration(new SpaceGridItemDecoration());
        rv.setHasFixedSize(true);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        SectionedSpanSizeLookup lookup = new SectionedSpanSizeLookup(adapter, layoutManager);
        layoutManager.setSpanSizeLookup(lookup);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
    }
}
