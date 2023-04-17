package br.com.joaocarvoli.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import br.com.joaocarvoli.contactlist.dao.ContactArrayList
import br.com.joaocarvoli.contactlist.dao.ContactDAO
import br.com.joaocarvoli.contactlist.model.Contact

class MainActivity : AppCompatActivity() {

    private lateinit var contactDAO : ContactDAO
    private lateinit var arrayAdapter: ArrayAdapter<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactDAO = ContactArrayList()
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactDAO.getAll())

        val lvContactList : ListView = findViewById(R.id.lv_contacts_list)
        lvContactList.adapter = arrayAdapter


        val etName : TextView = findViewById(R.id.et_name)
        val etNumber : TextView = findViewById(R.id.et_number)
        val etAddress : TextView = findViewById(R.id.et_address)
        val btnAddContact : Button = findViewById(R.id.btn_add)
        btnAddContact.setOnClickListener {
            val contact = Contact(1, etName.text.toString(), etNumber.text.toString().toInt(), etAddress.text.toString())
            contactDAO.add(contact)
            arrayAdapter.notifyDataSetChanged()
        }
    }
}