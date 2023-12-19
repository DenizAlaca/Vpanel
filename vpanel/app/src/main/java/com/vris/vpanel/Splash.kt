package com.vris.vpanel

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior

class Splash : AppCompatActivity() {
    private var connectSql = ConnectSql()
    lateinit var userlogin: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        val PASSWORD:EditText=findViewById(R.id.editTextTextPersonName18)
        val giris:Button=findViewById(R.id.button54)
        giris.setOnClickListener {
            if (PASSWORD.text.toString()=="Naberla53"||PASSWORD.text.toString()=="Alaca6728*")
            {
                val intent = Intent(this, FreecashPanel::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,"yanlış bilgi",Toast.LENGTH_SHORT).show()}
        }




     /*   val intent = Intent(this, FreecashPanel::class.java)
        startActivity(intent)
        finish()
*/
       /* userlogin=getSharedPreferences("userlog", Context.MODE_PRIVATE)
        var log=userlogin.getString("ulog","")
        if (log!=null) {

            val login: PreparedStatement = connectSql.dbConn()
                ?.prepareStatement("select email_address,userName,password,ltc_address,dogrulama_kodu from Kullanici where email_address='" + log.toString() + "'")!!


            val rs = login.executeQuery()
            while (rs.next()) {


                val editor2: SharedPreferences.Editor = userlogin.edit()
                editor2.putString("nameuser1", rs.getString(2))

                editor2.apply()
                val editor3: SharedPreferences.Editor = userlogin.edit()
                editor3.putString("passworduser", rs.getString(3))

                editor3.apply()
                val editor4: SharedPreferences.Editor = userlogin.edit()
                editor4.putString("ltcadresi", rs.getString(4))

                editor4.apply()


                val editor: SharedPreferences.Editor = userlogin.edit()
                editor.putString("dogrulamakod", rs.getString(5))

                editor.apply()
                val editor1: SharedPreferences.Editor = userlogin.edit()

                editor1.putString("mailal", rs.getString(1))
                editor1.apply()
            }
        }
        Handler().postDelayed({
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
            finish()

        },1000)*/


    }

}