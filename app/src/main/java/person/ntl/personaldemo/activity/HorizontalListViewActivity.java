package person.ntl.personaldemo.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import person.ntl.personaldemo.R;
import person.ntl.personaldemo.view.InterceptScrollContainer;
import person.ntl.personaldemo.view.MyHScrollView;

public class HorizontalListViewActivity extends Activity {
    ListView mListView1;
    MyAdapter myAdapter;
    RelativeLayout mHead;
    LinearLayout main;

    boolean clickOk = true;

    int screenWidth = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_list_view);

        mHead = (RelativeLayout) findViewById(R.id.head);
        mHead.setFocusable(true);
        mHead.setClickable(true);
        mHead.setBackgroundColor(Color.parseColor("#b2d235"));
        mHead.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());

        mListView1 = (ListView) findViewById(R.id.listView1);
        mListView1.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());

        myAdapter = new MyAdapter(this, R.layout.item_horizontal_listview);
        mListView1.setAdapter(myAdapter);
        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (clickOk){
                    Toast.makeText(HorizontalListViewActivity.this,position+"",Toast.LENGTH_SHORT).show();
                }
            }
        });

        DisplayMetrics  dm = new DisplayMetrics();
        //取得窗口属性
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        //窗口的宽度
        screenWidth = dm.widthPixels;


    }

    class ListViewAndHeadViewTouchLinstener implements View.OnTouchListener {
        private float startx;
        private float starty;
        private float upoffset;
        private float offset;


        private boolean isLock = false;
        private boolean isHor = false;

        @Override
        public boolean onTouch(View arg0, MotionEvent arg1) {
            HorizontalScrollView mHead = (HorizontalScrollView) HorizontalListViewActivity.this.mHead.findViewById(R.id.horizontalScrollView1);

            switch (arg1.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    clickOk = true;
                    startx = arg1.getX();
                    starty = arg1.getY();
                    mHead.onTouchEvent(arg1);
                    break;

                case MotionEvent.ACTION_MOVE:
                    float xNow = arg1.getX();
                    float yNow = arg1.getY();
                    offset = xNow - startx;
                    upoffset = yNow - starty;

                    if (isLock){
                        if (isHor){
                            if (xNow< screenWidth){
                                Log.d("=======>","xNow:"+xNow +"   屏幕宽度："+ screenWidth);
                                arg1.setLocation(xNow,starty);
                                mHead.onTouchEvent(arg1);
                            }

                        }else {
                            arg1.setLocation(startx,yNow);
                            mHead.onTouchEvent(arg1);

                        }
                    }else {
                        if (Math.abs(offset) > 100){
                            clickOk = false;
                            isLock = true;
                            isHor = true;
                            startx = xNow;
                        }else if (Math.abs(upoffset) > 100){
                            clickOk = false;
                            isLock = true;
                            isHor = false;
                            starty = yNow;
                        }
                    }
                    break;

                case MotionEvent.ACTION_UP:
//                    clickOk = true;
                    startx = arg1.getX();
                    starty =arg1.getY();
//                    if (isLock){
//                    }else {
//                        mHead.onTouchEvent(arg1);
//                    }

                    mHead.onTouchEvent(arg1);
                    isLock = false;
                    break;


                default:
                    break;

            }


//            HorizontalScrollView mHead = (HorizontalScrollView) mHead
//                            .findViewById(R.id.horizontalScrollView1);
////            Log.e("TAG", "竖滑  x:" + arg1.getX() + "   y:" + arg1.getY()+ "   offset:"+offset +"   upoffset:"+upoffset+ "   startx:"+startx +"   starty:"+starty);
//            Log.e("TAG", "  x:" + arg1.getX() + "   y:" + arg1.getY());
//            arg1.setLocation(arg1.getX(),500);
//            mHead.onTouchEvent(arg1);
            return false;

        }
    }

    public class MyAdapter extends BaseAdapter {
        public List<ViewHolder> mHolderList = new ArrayList<ViewHolder>();



        int id_row_layout;
        LayoutInflater mInflater;

        public MyAdapter(Context context, int id_row_layout) {
            super();
            this.id_row_layout = id_row_layout;
            mInflater = LayoutInflater.from(context);

        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 250;
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parentView) {
            ViewHolder holder = null;
            if (convertView == null) {
                synchronized (HorizontalListViewActivity.this) {
                    convertView = mInflater.inflate(id_row_layout, null);
                    holder = new ViewHolder();

                    MyHScrollView scrollView1 = (MyHScrollView) convertView
                            .findViewById(R.id.horizontalScrollView1);

                    holder.scrollView = scrollView1;
                    holder.container = (InterceptScrollContainer) convertView.findViewById(R.id.scroollContainter);
                    holder.txt1 = (TextView) convertView
                            .findViewById(R.id.textView1);
                    holder.txt2 = (TextView) convertView
                            .findViewById(R.id.textView2);
                    holder.txt3 = (TextView) convertView
                            .findViewById(R.id.textView3);
                    holder.txt4 = (TextView) convertView
                            .findViewById(R.id.textView4);
                    holder.txt5 = (TextView) convertView
                            .findViewById(R.id.textView5);

                    MyHScrollView headSrcrollView = (MyHScrollView) mHead
                            .findViewById(R.id.horizontalScrollView1);
                    headSrcrollView
                            .AddOnScrollChangedListener(new OnScrollChangedListenerImp(
                                    scrollView1));

                    convertView.setTag(holder);
                    mHolderList.add(holder);
                }
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.txt1.setText(position + "" + 1);
            holder.txt2.setText(position + "" + 2);
            holder.txt3.setText(position + "" + 3);
            holder.txt4.setText(position + "" + 4);
            holder.txt5.setText(position + "" + 5);
//            holder.scrollView.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    switch (event.getAction()){
//                        case MotionEvent.ACTION_DOWN:
//                            Log.e("<============>","ACTION_DOWN");
//
//                            return true;
//                        case MotionEvent.ACTION_MOVE:
//                            Log.e("<============>","ACTION_MOVE");
//
//                            break;
//                        case MotionEvent.ACTION_UP:
//                            Log.e("<============>","ACTION_UP");
//
//                            break;
//
//                    }
//
//                    return false;
//                }
//            });
//            holder.container.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(HorizontalListViewActivity.this,position+"",Toast.LENGTH_SHORT).show();
//                }
//            });
//            convertView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(HorizontalListViewActivity.this,position+"",Toast.LENGTH_SHORT).show();
//                }
//            });
            return convertView;
        }

        class OnScrollChangedListenerImp implements MyHScrollView.OnScrollChangedListener {
            MyHScrollView mScrollViewArg;

            public OnScrollChangedListenerImp(MyHScrollView scrollViewar) {
                mScrollViewArg = scrollViewar;
            }

            @Override
            public void onScrollChanged(int l, int t, int oldl, int oldt) {
                Log.d("------------------","l:"+l+"       oldl"+l);
                mScrollViewArg.smoothScrollTo(l, t);
            }

        };

        class ViewHolder {
            TextView txt1;
            TextView txt2;
            TextView txt3;
            TextView txt4;
            TextView txt5;
            MyHScrollView scrollView;
            InterceptScrollContainer container;
        }
    }// end class my
}
