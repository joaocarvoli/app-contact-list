package br.com.joaocarvoli.contactlist.model

class Contact(id : Number, name : String, number : String, address : String) {
    private var id : Number
    private var name : String;
    private var number : String;
    private var address : String;

    init {
        this.id = id
        this.name = name
        this.number = number
        this.address = address
    }

    fun getId() : Number { return id }

    fun getName() : String { return name }
    fun setName(name : String){ this.name = name }

    fun getNumber() : String { return number }
    fun setNumber(number : String) { this.number = number }

    fun getAddress() : String { return address }
    fun setAddress(address : String) { this.address = address }

    override fun toString(): String {
        return "Name: $name Number: $number"
    }
}