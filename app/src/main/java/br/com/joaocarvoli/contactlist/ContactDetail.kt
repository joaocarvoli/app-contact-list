package br.com.joaocarvoli.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import br.com.joaocarvoli.contactlist.dao.ContactArrayList
import br.com.joaocarvoli.contactlist.dao.ContactDAO
import br.com.joaocarvoli.contactlist.model.Contact

class ContactDetail : AppCompatActivity() {
    private lateinit var contactDAO : ContactDAO
    private var contact : Contact? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)
        contactDAO = ContactArrayList

        val intentExtras = intent.extras
        val contactID = intentExtras?.getInt("contactID")

        if (contactID != null) {
            contact = contactDAO.get(contactID)
        }

        val tvName : TextView = findViewById(R.id.tv_name)
        val tvNumber : TextView = findViewById(R.id.tv_number)
        val tvAddress : TextView = findViewById(R.id.tv_address)

        if(contact != null){
            tvName.text = contact?.getName()
            tvNumber.text = contact?.getNumber()
            tvAddress.text = contact?.getAddress()
        }
    }
}