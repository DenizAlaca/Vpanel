package com.vris.vpanel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.sql.PreparedStatement

class Users : AppCompatActivity() {
    private var connectSql = ConnectSql()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        val geridonb:Button=findViewById(R.id.geridonButton)
        geridonb.setOnClickListener {
            val intent = Intent(this, TablolariSifirla::class.java)
            startActivity(intent)
            finish()
        }

        val idchk: PreparedStatement = connectSql.dbConn()
            ?.prepareStatement("select * from Kullanici ")!!
        val arrayList: ArrayList<String> = ArrayList()
        val spinner:Spinner=findViewById(R.id.spinner3)



        val rs = idchk.executeQuery()
        while (rs.next())
        {

            arrayList.add(rs.getInt(1).toString())

            //=
            //rs.getInt(1).toString()

        }
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter

        val mail: TextView =findViewById(R.id.textView72)
        val name:TextView=findViewById(R.id.textView71)
        val password:TextView=findViewById(R.id.textView74)
        val trade:EditText=findViewById(R.id.editTextTextPersonName22)
        val date:TextView=findViewById(R.id.textView73)
        val kod:TextView=findViewById(R.id.textView75)
        val durum:TextView=findViewById(R.id.textView76)
        val chk:CheckBox=findViewById(R.id.checkBox19)
        val mail1:EditText=findViewById(R.id.editTextTextPersonName21)
        val bilgi:Button=findViewById(R.id.button67)
        bilgi.setOnClickListener {
            if (chk.isChecked==false) {
                val idchk: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement(
                        "select email_address,userName,password,ltc_address,create_date,dogrulama_kodu,dogrulama_kontrol from Kullanici where id=" + spinner.selectedItem.toString()
                            .toInt() + ""
                    )!!


                val rs = idchk.executeQuery()
                while (rs.next()) {

                    mail.setText(rs.getString(1))
                    name.setText(rs.getString(2))
                    password.setText(rs.getString(3))
                    trade.setText(rs.getString(4))
                    date.setText(rs.getString(5))
                    durum.setText(rs.getString(6))
                    kod.setText(rs.getBoolean(7).toString())


                    break
                }
            }
            else
            {
                val idchk: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement(
                        "select email_address,userName,password,ltc_address,create_date,dogrulama_kodu,dogrulama_kontrol from Kullanici where id=" +mail1.text.toString() + ""
                    )!!


                val rs = idchk.executeQuery()
                while (rs.next()) {

                    mail.setText(rs.getString(1))
                    name.setText(rs.getString(2))
                    password.setText(rs.getString(3))
                    trade.setText(rs.getString(4))
                    date.setText(rs.getString(5))
                    durum.setText(rs.getString(6))
                    kod.setText(rs.getBoolean(7).toString())


                    break
                }
            }
        }



    }
}