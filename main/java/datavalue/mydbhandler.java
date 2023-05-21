package datavalue;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import modelss.Contact;
import paramet.parameter;

public class mydbhandler extends SQLiteOpenHelper {


    public mydbhandler(Context context) {
        super(context, parameter.DB_NAME, null, parameter.DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create ="CREATE TABLE "+ parameter.Table_NAME +"("
                + parameter.KEY_ID+"INTEGER PRIMARY KEY,"+ parameter.KEY_NAME + "TEXT, "
                +parameter.KEY_PHONE+" TEXT " + ")";

        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }



    public void addContact(Contact contact){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(parameter.KEY_NAME,contact.getName());
        values.put(parameter.KEY_PHONE,contact.getPhoneNumber());

        db.insert(parameter.Table_NAME,null,values);
        db.close();
    }

    public List<Contact> getAllContacts(){
        List<Contact> contactList=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM "+parameter.Table_NAME;
        Cursor cursor=db.rawQuery(select,null);

        if (cursor.moveToFirst()){
            do{
                Contact contact=new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                contactList.add(contact);
            }while(cursor.moveToNext());
        }
        return contactList;
    }
    public int updateContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(parameter.KEY_PHONE, contact.getPhoneNumber());
        values.put(parameter.KEY_NAME, contact.getName());

        return db.update(parameter.Table_NAME, values,parameter.KEY_ID+"??",
            new String[]{String.valueOf(contact.getId())});
    }


}
