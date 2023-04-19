package br.com.joaocarvoli.contactlist.dao

import android.util.Log
import br.com.joaocarvoli.contactlist.model.Contact

object ContactArrayList : ContactDAO {

    private var contactList : ArrayList<Contact> = ArrayList<Contact>()

    override fun add(contact: Contact): Boolean {
       contactList.add(contact)
       return true
    }

    override fun remove(id: Number): Boolean {
        contactList.forEach {contactInList ->
            if(contactInList.getId() == id){
                contactList.remove(contactInList)
                return true
            }
        }
        return false
    }

    override fun removeAll(): Boolean {
        return false
    }

    override fun get(id: Number): Contact? {
        var contact : Contact? = null

        contactList.forEach { contactInList ->
            if(contactInList.getId() == id){
                contact = contactInList
            }
        }

        return contact
    }

    override fun getAll(): ArrayList<Contact> {
        return contactList
    }
}