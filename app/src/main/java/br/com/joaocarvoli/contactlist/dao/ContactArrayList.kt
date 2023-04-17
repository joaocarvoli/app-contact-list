package br.com.joaocarvoli.contactlist.dao

import br.com.joaocarvoli.contactlist.model.Contact

class ContactArrayList : ContactDAO {

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

    override fun get(id: Number): Contact {
        return Contact(1,"", 1, "")
    }

    override fun getAll(): ArrayList<Contact> {
        return contactList
    }
}