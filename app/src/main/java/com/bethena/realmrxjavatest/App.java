package com.bethena.realmrxjavatest;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * 描    述：
 * 作    者：chenml@13322.com
 * 时    间：2017/6/17
 */
public class App extends Application {


    final static int REAML_DATABASE_VERSION = 1;


    @Override
    public void onCreate() {
        super.onCreate();


        initRealm();
        initStetho();
    }

    void initRealm(){
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .schemaVersion(REAML_DATABASE_VERSION)
                .migration(new Migration())
                .build();

        Realm.setDefaultConfiguration(configuration);
    }

    void initStetho(){
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());
    }
}
