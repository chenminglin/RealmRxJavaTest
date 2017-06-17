package com.bethena.realmrxjavatest.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bethena.realmrxjavatest.R;
import com.bethena.realmrxjavatest.bean.User;

import java.util.Date;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        for (int i = 20; i <= 30; i++) {
            realm.insertOrUpdate(new User("userid" + i, "name" + i + new Date()));

        }
        realm.commitTransaction();

    }
}
