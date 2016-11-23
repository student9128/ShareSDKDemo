package com.kevin.tech.sharesdkdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cn.sharesdk.framework.ShareSDK;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        ShareSDK.initSDK(Context,"sharesdk的appkey");
        初始化第一个参数传当前activity的context对象，第二个参数传ShareSDK的appkey，
        第二个参数可以省略不传，因为sharesdk.xml已经配置，默认会访问的；
        初始化的代码尽量放到调用分享的activity的入口oncreat下就好，尽量不要再application里初始化，
        也可以多次调用初始化ShareSDK，初始化ShareSDK必须放到所有调用ShareSDK的最前端。
         */
        ShareSDK.initSDK(this);
        mBtnShare = (Button) findViewById(R.id.btn_share);
        mBtnShare.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_share) {
            showShare();
        }
    }

    private void showShare() {
        ShareSDK.initSDK(this);
        cn.sharesdk.onekeyshare.OnekeyShare oks = new cn.sharesdk.onekeyshare.OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
//        oks.setTitle("标题");
        oks.setTitle("Kevin Blog");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
//        oks.setTitleUrl("http://sharesdk.cn");
        oks.setTitleUrl("http://blog.csdn.net/student9128");
// text是分享文本，所有平台都需要这个字段
//        oks.setText("我是分享文本");
        oks.setText("Blog");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
oks.setImagePath("http://avatar.csdn.net/8/1/5/1_student9128.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("我是测试评论文本");
        oks.setComment("The Test Text");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.tips));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
//        oks.setSiteUrl("http://sharesdk.cn");
        oks.setSiteUrl("http://blog.csdn.net/student9128");
        oks.setSilent(false);// 显示编辑页面
// 启动分享GUI
        oks.show(this);
    }
}
