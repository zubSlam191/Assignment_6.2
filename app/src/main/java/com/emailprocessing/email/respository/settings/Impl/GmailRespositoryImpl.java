package com.emailprocessing.email.respository.settings.Impl;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.emailprocessing.email.conf.databases.DBConstants;
import com.emailprocessing.email.domain.Email;
import com.emailprocessing.email.respository.settings.EmailsRespository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by student on 2016/04/17.
 */
public class GmailRespositoryImpl extends SQLiteOpenHelper implements EmailsRespository {
    public static final String TABLE_EMAILS = "gmail";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_DESCRIPTION = "description";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_EMAILS + "("
            +COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_EMAIL + " TEXT NOT NULL , "
            + COLUMN_DESCRIPTION + " TEXT NOT NULL);";

    public GmailRespositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Email findById(long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_EMAILS,
                new String[]{
                        COLUMN_ID,
                        COLUMN_EMAIL,
                        COLUMN_DESCRIPTION},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Email settings = new Email
                    .Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .address(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)))
                    .description(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)))
                    .build();

            return settings;
        } else {
            return null;
        }
    }

    @Override
    public Email save(Email entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, entity.getAddress());
        values.put(COLUMN_DESCRIPTION, entity.getDescription());
        long id =  db.insertOrThrow(TABLE_EMAILS, null, values);
        Email insertedEntity =  new Email.Builder()
                .copy(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public Email update(Email entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, entity.getAddress());
        values.put(COLUMN_DESCRIPTION, entity.getDescription());
        db.update(
                TABLE_EMAILS,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Email delete(Email entity) {
        open();
        db.delete(
                TABLE_EMAILS,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Email> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Email> email = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_EMAILS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                final Email setting = new Email.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .address(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)))
                        .description(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)))
                        .build();
                email.add(setting);
            } while (cursor.moveToNext());
        }
        return email;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_EMAILS, null, null);
        // close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMAILS);
        onCreate(db);

    }

    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "mesage" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(SQLException sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        } catch(Exception ex){

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }


    }
}

