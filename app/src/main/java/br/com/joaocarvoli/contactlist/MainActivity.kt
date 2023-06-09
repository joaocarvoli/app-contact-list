package br.com.joaocarvoli.contactlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import br.com.joaocarvoli.contactlist.dao.ContactArrayList
import br.com.joaocarvoli.contactlist.dao.ContactDAO
import br.com.joaocarvoli.contactlist.model.Contact
import br.com.joaocarvoli.contactlist.ui.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var contactDAO : ContactDAO
    private lateinit var arrayAdapter: ArrayAdapter<Contact>
    private var idCounter = 0;
    private lateinit var viewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactDAO = ContactArrayList
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactDAO.getAll())
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val lvContactList : ListView = findViewById(R.id.lv_contacts_list)
        lvContactList.adapter = arrayAdapter

        lvContactList.setOnItemClickListener { _, _, position, _ ->
            startDetailActivity(position)
        }

        val etName : TextView = findViewById(R.id.et_name)
        val etNumber : TextView = findViewById(R.id.et_number)
        val etAddress : TextView = findViewById(R.id.et_address)
        val btnAddContact : Button = findViewById(R.id.btn_add)

        btnAddContact.setOnClickListener {
            viewModel.addContact(etName, etNumber, etAddress)
            arrayAdapter.notifyDataSetChanged()
        }
    }


    private fun startDetailActivity(contactPosition : Int){
        val intent = Intent(this, ContactDetail::class.java).apply {
            putExtra("contactID", contactPosition)
        }
        startActivity(intent)
    }
}