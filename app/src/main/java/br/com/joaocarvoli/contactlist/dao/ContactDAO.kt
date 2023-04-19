package br.com.joaocarvoli.contactlist.dao

import br.com.joaocarvoli.contactlist.model.Contact

interface ContactDAO {
    fun add(contact: Contact) : Boolean
    fun remove(id : Number) : Boolean
    fun removeAll() : Boolean
    fun get(id : Number) : Contact?
    fun getAll() : ArrayList<Contact>
}