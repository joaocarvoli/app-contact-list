package br.com.joaocarvoli.contactlist.ui

import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.lifecycle.ViewModel
import br.com.joaocarvoli.contactlist.dao.ContactArrayList
import br.com.joaocarvoli.contactlist.dao.ContactDAO
import br.com.joaocarvoli.contactlist.model.Contact

class MainActivityViewModel : ViewModel() {
    private val contactDAO : ContactDAO = ContactArrayList
    private var idCounter = 0;

    fun addContact(name : TextView, number: TextView, address : TextView){
        val contact = Contact(idCounter++, name.text.toString(), number.text.toString(), address.text.toString())
        contactDAO.add(contact)
    }
}