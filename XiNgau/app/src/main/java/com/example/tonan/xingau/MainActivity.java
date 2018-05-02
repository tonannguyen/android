package com.example.tonan.xingau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView img1,img2,img3,img_tai,img_xiu;
    TextView tv,tv_taixiu;
    Button btn;
    int random;
    boolean flag = false;
    boolean taixiu;

    int mang_hinh_xx[]={
            R.drawable.xx1,R.drawable.xx2,R.drawable.xx3,R.drawable.xx4,R.drawable.xx5,R.drawable.xx6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(new GIFView(this));Ảnh động

        img1 	=  (ImageView) findViewById(R.id.imageView1);
        img2 	=  (ImageView) findViewById(R.id.imageView2);
        img3 	=  (ImageView) findViewById(R.id.imageView3);
        img_tai =  (ImageView) findViewById(R.id.imageView4);
        img_xiu =  (ImageView) findViewById(R.id.imageView5);

        tv 		=  (TextView) findViewById(R.id.textView2);
        tv_taixiu	=  (TextView) findViewById(R.id.textView3);
        btn		=  (Button)	  findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(flag)
                    doXiNgau();
                else tv_taixiu.setText("TÀI hay XỈU. Đặt đi bạn ơi!!!");
            }
        });

        img_tai.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tv_taixiu.setText("Bạn đã đặt TÀI");
                flag = true;
                taixiu = true;

            }
        });

        img_xiu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tv_taixiu.setText("Bạn đã đặt XỈU");
                flag = true;
                taixiu = false;
            }
        });
    }
    public int soNgauNhien()
    {
        return random = (int) (Math.random()*6);
    }

    public void doXiNgau()
    {
        // Khai báo các biến chứa giá trị xx1,xx2,xx3 và tổng nút
        int value1,value2,value3,sonut;
        // Khai báo biến kq để chứa chuỗi "Thắng" hay "Thua"
        String kq;

        //Gán số nút cho xí ngầu
        value1 = soNgauNhien();
        value2 = soNgauNhien();
        value3 = soNgauNhien();

        img1.setImageResource(mang_hinh_xx[value1]);
        img2.setImageResource(mang_hinh_xx[value2]);
        img3.setImageResource(mang_hinh_xx[value3]);

        //Tổng nút
        sonut = value1+value2+value3+3;

        //Xuất kết quả tài xỉu
        if((taixiu & sonut>9) || (!taixiu & sonut<=9))
        {
            kq = "\n Thắng";
        }
        else
        {
            kq = "\n Thua";
        }

        //Xuất kết quả ra textView
        tv.setText("Số nút là :"+sonut+kq);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
