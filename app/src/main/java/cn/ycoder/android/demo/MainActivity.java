package cn.ycoder.android.demo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import cn.com.epsoft.common.view.PureRowTextView;
import cn.ycoder.android.demo.presenter.NotePresenter;
import cn.ycoder.android.demo.store.AppStore;
import cn.ycoder.android.library.BaseApplication;
import cn.ycoder.android.library.ToolbarActivity;
import cn.ycoder.android.library.WebActivity;
import cn.ycoder.android.library.route.RouteUtil;
import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends ToolbarActivity implements NotePresenter.View {

  private Button btn;
  private TextView txt;
  private NotePresenter presenter;
  private PureRowTextView tv1;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_main);
    //初始化及绑定
    this.presenter = new NotePresenter(this);
    this.txt = (TextView) findViewById(R.id.txt);
    this.btn = (Button) findViewById(R.id.btn);
    this.tv1= (PureRowTextView) findViewById(R.id.tv1);
    this.btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.load();
      }
    });
    findViewById(R.id.baidu).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(WebActivity.newIntent(getBaseContext(), "", "http://www.baidu.com"));
      }
    });
    BaseApplication.getInstance().setTag(AppStore.KEY_TAG1, "我是什么:");
    BaseApplication.getInstance().setTag(AppStore.KEY_TAG2, "法海");
  }

  @Override
  public void onLoadResult(final String msg) {
    txt.setText(msg);
    tv1.setText(msg);
    this.txt.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        ARouter.getInstance().build(RouteUtil.builderWithFragment("/main/test","/main/AAA?tab=1"))
            .withString("msg", msg)
            .navigation(MainActivity.this);
      }
    });
  }
}