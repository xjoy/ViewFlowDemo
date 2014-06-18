package com.pdh.mvf;

import org.taptwo.android.widget.CircleFlowIndicator;
import org.taptwo.android.widget.PullToRefreshBase;
import org.taptwo.android.widget.LayersLayout;
import org.taptwo.android.widget.ViewFlow;

import com.pdh.adapter.ViewFlowAdapter;
import com.pdh.adapter.PullToRefreshListAdapter;
import com.vf.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */

	private ListView listView; // 下拉刷新的listview
	private ViewFlow viewFlow; // 进行图片轮播的viewFlow
	private LayersLayout layersLayout; // 自定义图层，用于对触屏事件进行重定向

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.pull_to_refresh_list);
		PullToRefreshBase<?> pullToRefresh = (PullToRefreshBase<?>) findViewById(R.id.pulltorefreshlistview);// 获得下拉刷新的listview
		listView = (ListView) pullToRefresh.getAdapterView();
		
		layersLayout = (LayersLayout) findViewById(R.id.layerslayout);// 获得自定义图层，对触屏事件进行重定向

		LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
		View header = inflater.inflate(R.layout.viewflow, null);
		listView.addHeaderView(header); // 将viewFlow添加到listview中
		
		viewFlow = (ViewFlow) header.findViewById(R.id.viewflow);// 获得viewFlow对象
		viewFlow.setAdapter(new ViewFlowAdapter(getApplicationContext())); // 对viewFlow添加图片
		viewFlow.setmSideBuffer(3);
		CircleFlowIndicator indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic); // viewFlow下的indic
		viewFlow.setFlowIndicator(indic);
		viewFlow.setTimeSpan(4500);
		viewFlow.setSelection(3 * 1000); // 设置初始位置
		viewFlow.startAutoFlowTimer(); // 启动自动播放

		layersLayout.setView(viewFlow); // 将viewFlow对象传递给自定义图层，用于对事件进行重定向
		listView.setAdapter(new PullToRefreshListAdapter(this)); // 绑定数据
	} 
}