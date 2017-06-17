package com.bethena.realmrxjavatest;

import android.util.Log;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

/**
 * 描    述：
 * 作    者：chenml@13322.com
 * 时    间：2017/6/17
 */
public class Migration implements RealmMigration {

    final String TAG = "Migration";

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        Log.d(TAG, "migrate");
        Log.d(TAG, "oldVersion = " + oldVersion);
        Log.d(TAG, "newVersion = " + newVersion);


        RealmSchema schema = realm.getSchema();

        oldVersion++;

        if (oldVersion == 2) {
            RealmObjectSchema userSchema = schema.get("User");
            userSchema.removeField("id").addPrimaryKey("userId");

            oldVersion++;
        }

        if (oldVersion == 3) {
            RealmObjectSchema userSchema = schema.get("User");
            userSchema.addField("age", int.class);
            oldVersion++;
        }
    }
}
