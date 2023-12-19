package com.vris.vpanel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import java.lang.Exception
import java.sql.PreparedStatement

class UpdateVersion : AppCompatActivity() {
    private var connectSql = ConnectSql()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_version)

        val updatebtn:Button=findViewById(R.id.button42)
        val text:EditText=findViewById(R.id.editTextTextPersonName14)
        val chk:CheckBox=findViewById(R.id.checkBox4)
        val chkf:CheckBox=findViewById(R.id.checkBox14)
        val chko:CheckBox=findViewById(R.id.checkBox15)
        val textf:EditText=findViewById(R.id.editTextTextPersonName19)
        val texto:EditText=findViewById(R.id.editTextTextPersonName20)
        val updatebtnf:Button=findViewById(R.id.button61)
        val updatebtno:Button=findViewById(R.id.button63)
val acchk:CheckBox=findViewById(R.id.checkBox)
        val kapatchk:CheckBox=findViewById(R.id.checkBox2)
        val dailybutton:Button=findViewById(R.id.button4)
        val freebutton:Button=findViewById(R.id.button5)
        val okxbutton:Button=findViewById(R.id.button6)
        val spinner:Spinner=findViewById(R.id.spinner4)
        getir()

        val refresh: SwipeRefreshLayout =findViewById(R.id.constraintLayout186)

        dailybutton.setOnClickListener {
            if (acchk.isChecked==true)
            {
                val idchk: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update dailykont set kontrol=1 ")!!
             idchk.executeUpdate()
            }
            else if (kapatchk.isChecked==true)
            {
                val idchk: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update dailykont set kontrol=0 ")!!
                idchk.executeUpdate()
            }
        }
        freebutton.setOnClickListener {
            if (acchk.isChecked==true)
            {
                val idchk: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update freekont set kontrol=1 ")!!
                idchk.executeUpdate()
            }
            else if (kapatchk.isChecked==true)
            {
                val idchk: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update freekont set kontrol=0 ")!!
                idchk.executeUpdate()
            }
        }
        okxbutton.setOnClickListener {
            if (acchk.isChecked==true)
            {
                val idchk: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update oxkkont set kontrol=1 ")!!
                idchk.executeUpdate()
            }
            else if (kapatchk.isChecked==true)
            {
                val idchk: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update oxkkont set kontrol=0 ")!!
                idchk.executeUpdate()
            }
        }

        refresh.setOnRefreshListener {
            getir()
            refresh.isRefreshing=false
        }

try {
    val spin:Button=findViewById(R.id.button2)
    spin.setOnClickListener {

        val trade:EditText=findViewById(R.id.editTextTextPersonName)
        val idchk: PreparedStatement = connectSql.dbConn()
            ?.prepareStatement("select ltc_address  from kullanici where id="+spinner.selectedItem.toString().toInt()+"")!!
        val rs = idchk.executeQuery()
        while (rs.next())
        {

            trade.setText(rs.getString(1).toString())

            //=
            //rs.getInt-(1).toString()
            break
        }


    }

}



catch (e:Exception)
{
    Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show()
}
        val onay:Button=findViewById(R.id.button3)
        onay.setOnClickListener {
            val idchk: PreparedStatement = connectSql.dbConn()
                ?.prepareStatement("update daily set kont=0 where id="+spinner.selectedItem.toString().toInt()+"")!!
           idchk.executeUpdate()
            getir()
        }


        updatebtnf.setOnClickListener {
            if (chkf.isChecked==true) {
                val deneme = textf.text.toString()
                var sayi=deneme.toInt()
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update progress set katılımcısayisi=" + sayi + " where teklifadi='GiftFreacash' ")!!

                freacashchkekle.executeUpdate()
                Toast.makeText(this, "Güncellendi", Toast.LENGTH_SHORT).show()
            }
            else
            {Toast.makeText(this, "Onaylamalısın", Toast.LENGTH_SHORT).show()}
        }
        updatebtno.setOnClickListener {
            if (chko.isChecked==true) {
                val deneme = texto.text.toString()
                var sayi=deneme.toInt()
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update progress set katılımcısayisi=" + sayi + " where teklifadi='GiftOKX' ")!!

                freacashchkekle.executeUpdate()
                Toast.makeText(this, "Güncellendi", Toast.LENGTH_SHORT).show()
            }
            else
            {Toast.makeText(this, "Onaylamalısın", Toast.LENGTH_SHORT).show()}
        }



        updatebtn.setOnClickListener {
            if (chk.isChecked==true) {
                val deneme = text.text.toString()
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("update Version set version='" + deneme + "'")!!

                freacashchkekle.executeUpdate()
                Toast.makeText(this, "Güncellendi", Toast.LENGTH_SHORT).show()
            }
            else
            {Toast.makeText(this, "Onaylamalısın", Toast.LENGTH_SHORT).show()}
            }
        val yonetim: ImageView =findViewById(R.id.ackapatImage)
        yonetim.setOnClickListener {
            val intent = Intent(this, CekilisAcKapat::class.java)
            startActivity(intent)
            finish()
        }
        val sil: ImageView =findViewById(R.id.gelirgiderImage)
        sil.setOnClickListener {
            val intent = Intent(this, GelirGiderAyar::class.java)
            startActivity(intent)
            finish()
        }
        val geligider: ImageView =findViewById(R.id.freecashImage)
        geligider.setOnClickListener {
            val intent = Intent(this, FreecashPanel::class.java)
            startActivity(intent)
            finish()
        }

        val versionup: ImageView =findViewById(R.id.sifirlaImage)
        versionup.setOnClickListener {

            val intent = Intent(this, TablolariSifirla::class.java)
            startActivity(intent)
            finish()
        }
    }
    fun getir()
    {
        val idchk: PreparedStatement = connectSql.dbConn()
            ?.prepareStatement("select id from Daily where kont=1")!!
        val arrayList: ArrayList<String> = ArrayList()
        val spinner:Spinner=findViewById(R.id.spinner4)



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
    }
}

