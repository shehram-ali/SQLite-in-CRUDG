package com.example.myapplication.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import datavalue.mydbhandler;
import modelss.Contact;
import android.util.Log;
public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydbhandler db = new mydbhandler(MainActivity.this);

        Contact student1 =new Contact();
        student1.setPhoneNumber("03734567645");
        student1.setName("student1");

        db.addContact(student1);
        Log.d("student1","Id for student1 successfully added in database ");
        Contact student2 =new Contact();
        student1.setPhoneNumber("03734567645");
        student1.setName("student2");

        db.addContact(student2);
        Log.d("student2","Id for student1 successfully added in database ");
        Contact student3 =new Contact();
        student1.setPhoneNumber("03734567645");
        student1.setName("student3");

        db.addContact(student3);
        Log.d("student3","Id for student1 successfully added in database ");
        student3.setId(20);
        student3.setName("student3 update");
        int affectedRows = db.updateContact(student3);

        Log.d("dbstudent1","No of affected rows ");


        List<Contact> allContacts=db.getAllContacts();
        for (Contact contact:allContacts){
            Log.d("student","Id: "+ contact.getId()+"\n Name: "+contact.getName()+"\n phone Number "+contact.getPhoneNumber()+"\n");
        }
    }


}