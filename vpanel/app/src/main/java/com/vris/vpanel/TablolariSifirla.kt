package com.vris.vpanel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.sql.PreparedStatement

class TablolariSifirla : AppCompatActivity() {

    private var connectSql = ConnectSql()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablolari_sifirla)
        val freeclear: Button =findViewById(R.id.button55)
        val okxclear: Button =findViewById(R.id.button56)
        val bitclear: Button =findViewById(R.id.button57)
        val gelirgider: Button =findViewById(R.id.button59)
        val Freechk: CheckBox =findViewById(R.id.checkBox5)
        val Okxchk: CheckBox =findViewById(R.id.checkBox10)
        val Bitchk: CheckBox =findViewById(R.id.checkBox9)
        val toplam:TextView=findViewById(R.id.textView61)
        val toplamf:TextView=findViewById(R.id.textView62)
        val toplamb:TextView=findViewById(R.id.textView63)
        val toplamo:TextView=findViewById(R.id.textView64)

        val kullaniciliste:Button=findViewById(R.id.button)
        //delete giftbitexen where uid!=0

        kullaniciliste.setOnClickListener {
            val intent = Intent(this, Users::class.java)
            startActivity(intent)
            finish()
        }

        freeclear.setOnClickListener {
            if (Freechk.isChecked == true) {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("delete giftfreacash where uid!=0")!!

                freacashchkekle.executeUpdate()
                Toast.makeText(this,"Silindi.", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this,"onaylamalısın.", Toast.LENGTH_SHORT).show()}

        }
        okxclear.setOnClickListener {
            if (Okxchk.isChecked == true) {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("delete giftokx where uid!=0")!!

                freacashchkekle.executeUpdate()
                Toast.makeText(this,"Silindi.", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this,"onaylamalısın.", Toast.LENGTH_SHORT).show()}
        }
        bitclear.setOnClickListener {
            if (Bitchk.isChecked == true) {
                val freacashchkekle: PreparedStatement = connectSql.dbConn()
                    ?.prepareStatement("delete giftBitpanda where uid!=0")!!

                freacashchkekle.executeUpdate()
                Toast.makeText(this,"Silindi.", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this,"onaylamalısın.", Toast.LENGTH_SHORT).show()}
        }
        gelirgider.setOnClickListener {

            var gelir:Int=0
            var gider:Int=0

            val idchk: PreparedStatement = connectSql.dbConn()
                ?.prepareStatement("select gelir,gider from GelirGider where teklif_adı='Freecash'")!!

            val rs = idchk.executeQuery()
            while (rs.next())
            {
toplamf.setText("GELİR: "+rs.getString(1)+" GİDER: "+rs.getString(2))
                gelir+=rs.getString(1).toInt()
                gider+=rs.getString(2).toInt()
                break
            }
            val idchk1: PreparedStatement = connectSql.dbConn()
                ?.prepareStatement("select gelir,gider from GelirGider where teklif_adı='Bitpanda'")!!

            val rs1 = idchk1.executeQuery()
            while (rs1.next())
            {
                toplamb.setText("GELİR: "+rs1.getString(1)+" GİDER: "+rs1.getString(2))
                gelir+=rs1.getString(1).toInt()
                gider+=rs1.getString(2).toInt()
                break
            }
            val idchk2: PreparedStatement = connectSql.dbConn()
                ?.prepareStatement("select gelir,gider from GelirGider where teklif_adı='Okx'")!!

            val rs2 = idchk2.executeQuery()
            while (rs2.next())
            {
                toplamo.setText("GELİR: "+rs2.getString(1)+" GİDER: "+rs2.getString(2))
                gelir+=rs2.getString(1).toInt()
                gider+=rs2.getString(2).toInt()
                break
            }
            toplam.setText("Toplam gelir: "+gelir.toString()+" Toplam Gider: "+gider.toString())
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

        val versionup: ImageView =findViewById(R.id.updateImage)
        versionup.setOnClickListener {

            val intent = Intent(this, UpdateVersion::class.java)
            startActivity(intent)
            finish()
        }
    }
}