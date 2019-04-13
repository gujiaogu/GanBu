package com.uestc.ganbu.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.uestc.ganbu.MainActivity;
import com.uestc.ganbu.R;
import com.uestc.ganbu.app.MyApplication;
import com.uestc.ganbu.entity.DaoSession;
import com.uestc.ganbu.entity.MobilePhoneEntity;
import com.uestc.ganbu.entity.MobilePhoneEntityDao;
import com.uestc.ganbu.util.SharedPreferenceUtil;
import com.uestc.ganbu.util.ToastUtil;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    public static final String KEY_LOGIN_INFO = "key_login_info";

    @BindView(R.id.button_login)
    Button mBtnLogin;
    @BindView(R.id.edit_login)
    EditText mText;

    private DaoSession daoSession;
    private SharedPreferenceUtil sharedPreferenceUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        sharedPreferenceUtil = new SharedPreferenceUtil(this);
        daoSession = ((MyApplication) getApplication()).getDaoSession();

        mBtnLogin.setOnClickListener(v -> {
            String mobile = mText.getText().toString().trim();
            if (TextUtils.isEmpty(mobile)) {
                ToastUtil.textToast(LoginActivity.this, "请输入电话号码");
                return;
            }
            new LoginTask().execute(mobile);
        });
    }

    private class LoginTask extends AsyncTask<String, Void, Boolean> {

        private String mobile = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (aBoolean) {
                sharedPreferenceUtil.putString(KEY_LOGIN_INFO, mobile);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                ToastUtil.textToast(LoginActivity.this, "请检查手机号码");
            }
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            mobile = strings[0];
            boolean flag = false;
            QueryBuilder<MobilePhoneEntity> queryBuilder = daoSession.queryBuilder(MobilePhoneEntity.class);
            List<MobilePhoneEntity> list = queryBuilder.where(MobilePhoneEntityDao.Properties.Mobile.eq(mobile)).build().list();
            if (list != null && list.size() > 0) {
                flag = true;
            }
            return flag;
        }
    }
}
